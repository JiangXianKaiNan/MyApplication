package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PandaVideo extends BaseActivity {



    @Override
    protected void initView() {
        JCVideoPlayer videoView = (JCVideoPlayer)findViewById(R.id.videocontroller1);

        videoView.setUp("http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/07/20/429732b855b24e95ad208807174eb85c_h2641200000nero_aac16-1.mp4", "王强");
        videoView.ivThumb.setImageResource(R.drawable.def_no_play);
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
