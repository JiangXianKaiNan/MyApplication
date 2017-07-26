package com.example.myapplication.module.home.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.constants.Urls;
import com.example.myapplication.global.MyApp;
import com.example.myapplication.model.bean.HomeDetailBean;
import com.example.myapplication.network.HttpUtils;
import com.example.myapplication.network.MyCallBack;
import com.example.myapplication.view.CommonPopupWindow;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import static com.umeng.socialize.utils.DeviceConfig.context;


public class HoneVideoActivity extends AppCompatActivity {
    VideoView videoview_top;
    private String url;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        videoview_top = (VideoView) findViewById(R.id.video_play);
        context = HoneVideoActivity.this;
        //获取网络管理
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();// 获取网络信息

        Intent intent = getIntent();
        final String s = intent.getStringExtra("homepid");
        final String homeurl = intent.getStringExtra("homeurl");
        Log.e("Pid=========", s);
        Log.e("HoneVideoActivity", homeurl);

        final Map<String, String> map = new HashMap<>();
        map.put("pid", s);

        if (mNetworkInfo.isAvailable()) {
            int type = mNetworkInfo.getType();//得到连接的网络类型
            if (type == ConnectivityManager.TYPE_WIFI) {// 无线网
                HttpUtils.getInstance().get(homeurl, map, new MyCallBack<HomeDetailBean>() {
                    @Override
                    public void onSuccess(HomeDetailBean homeDetailBean) {
                        Log.e("视频的url", homeDetailBean.getVideo().getChapters()+"");
                        url = homeDetailBean.getVideo().getChapters().get(0).getUrl();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("HoneVideoActivity", url);
                                videoview_top.setVideoURI(Uri.parse(url));
                                MediaController controller = new MediaController(HoneVideoActivity.this);
                                videoview_top.setMediaController(controller);
                                controller.setMediaPlayer(videoview_top);
                                videoview_top.setMediaController(controller);
                                videoview_top.requestFocus();
                                videoview_top.start();
                            }
                        });
                    }
                    @Override
                    public void onFaile(String msg) {
                    }
                });
            } else if (type == ConnectivityManager.TYPE_MOBILE) {// 4g网
                AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
                builder.setTitle("网络提示"); //设置标题
                builder.setMessage("你是4G网络是否继续播放? 亲"); //设置内容
                builder.setIcon(R.drawable.tab_panda_live_normal);//设置图标
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //关闭dialog
                        HttpUtils.getInstance().get(homeurl, map, new MyCallBack<HomeDetailBean>() {
                            @Override
                            public void onSuccess(HomeDetailBean homeDetailBean) {
                                url = homeDetailBean.getVideo().getChapters4().get(0).getUrl();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.e("HoneVideoActivity", url);
                                        videoview_top.setVideoURI(Uri.parse(url));
                                        MediaController controller = new MediaController(HoneVideoActivity.this);
                                        videoview_top.setMediaController(controller);
                                        controller.setMediaPlayer(videoview_top);
                                        videoview_top.setMediaController(controller);
                                        videoview_top.requestFocus();
                                        videoview_top.start();
                                    }
                                });
                            }
                            @Override
                            public void onFaile(String msg) {
                            }
                        });
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                        return;
                    }
                });
                //参数都设置完成了，创建并显示出来
                builder.create().show();
            }
        }else {
            Toast.makeText(context, "没有网络哦，亲", Toast.LENGTH_SHORT).show();
            return;
        }
    }

}
