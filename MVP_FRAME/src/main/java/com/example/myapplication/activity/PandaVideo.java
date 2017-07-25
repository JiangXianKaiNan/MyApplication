package com.example.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.network.HttpUtils;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PandaVideo extends BaseActivity {



    @Override
    protected void initView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("网络提示"); //设置标题
        builder.setMessage("你是4G网络是否继续播放? "); //设置内容
        builder.setIcon(R.drawable.tab_panda_live_normal);//设置图标
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //关闭dialog
                String path= "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/07/20/429732b855b24e95ad208807174eb85c_h2641200000nero_aac16-1.mp4";
                Intent intent=new Intent(PandaVideo.this,PlayVideoActivity.class);
                intent.putExtra("url",path);
                startActivity(intent);


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

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.videoview;
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
