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
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.HomeDetailBean;
import com.example.myapplication.model.bean.HomeLiveShowDetailBean;
import com.example.myapplication.network.HttpUtils;
import com.example.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

import static com.umeng.qq.handler.a.s;
import static com.umeng.socialize.utils.DeviceConfig.context;


public class HoneLiveVideoActivity extends AppCompatActivity {
    VideoView videoview_top;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        videoview_top = (VideoView) findViewById(R.id.video_play);
        context = HoneLiveVideoActivity.this;

        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

        Intent intent = getIntent();
        final String zhobo = intent.getStringExtra("zhobo");
        Log.e("Pid=========", zhobo);

        if (mNetworkInfo.isAvailable()) {
            //获取网络类型
            int netWorkType = mNetworkInfo.getType();
            if (netWorkType == ConnectivityManager.TYPE_WIFI) {
                HttpUtils.getInstance().get(zhobo, null, new MyCallBack<HomeLiveShowDetailBean>() {
                    @Override
                    public void onSuccess(HomeLiveShowDetailBean homeLiveShowDetailBean) {
                        final String flv2 = homeLiveShowDetailBean.getFlv_url().getFlv2();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("HoneVideoActivity", flv2);
                                videoview_top.setVideoURI(Uri.parse(flv2));
                                MediaController controller = new MediaController(HoneLiveVideoActivity.this);
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
            }else if (netWorkType == ConnectivityManager.TYPE_MOBILE){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
                builder.setTitle("网络提示"); //设置标题
                builder.setMessage("你是4G网络是否继续播放? 亲"); //设置内容
                builder.setIcon(R.drawable.tab_panda_live_normal);//设置图标
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //关闭dialog
                        HttpUtils.getInstance().get(zhobo, null, new MyCallBack<HomeLiveShowDetailBean>() {
                            @Override
                            public void onSuccess(HomeLiveShowDetailBean homeLiveShowDetailBean) {
                                final String flv2 = homeLiveShowDetailBean.getFlv_url().getFlv2();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.e("HoneVideoActivity", flv2);
                                        videoview_top.setVideoURI(Uri.parse(flv2));
                                        MediaController controller = new MediaController(HoneLiveVideoActivity.this);
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
            Toast.makeText(context, "当前无网络", Toast.LENGTH_SHORT).show();
            return;
        }

    }


}
