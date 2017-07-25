package com.example.myapplication.module.roll_video.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.PlayVideoActivity;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.constants.Urls;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by ASUS on 2017/7/20.
 */

public class PanderVideo extends BaseActivity {
    @Override
    public int getActivityLayoutId() {
        return R.layout.pande_video;
    }
    @Override
    protected void initView() {}

    @Override
    protected void initListener() {}
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void loadData() {

        ConnectivityManager mConnectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager
                .getActiveNetworkInfo();
        if (mNetworkInfo.isAvailable()) {
            //获取网络类型
            int netWorkType = mNetworkInfo.getType();
            //TYPE_WIFI状态  直接播放
            if (netWorkType == ConnectivityManager.TYPE_WIFI) {
                Intent intent = getIntent();
                String title = intent.getStringExtra("title");
                Intent intent1 = new Intent(PanderVideo.this, PlayVideoActivity.class);
                intent1.putExtra("url",Urls.ROLLIMG);
                startActivity(intent1);
            } else if (netWorkType == ConnectivityManager.TYPE_MOBILE) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
                builder.setTitle("网络提示"); //设置标题
                builder.setMessage("你是4G网络是否继续播放? 亲"); //设置内容
                builder.setIcon(R.drawable.tab_panda_live_normal);//设置图标
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        String title = intent.getStringExtra("title");

                      Intent intent1 = new Intent(PanderVideo.this, PlayVideoActivity.class);
                        intent1.putExtra("url",Urls.ROLLIMG);
                        startActivity(intent1);
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
            } else {
                Toast.makeText(this, "当前无网络", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
