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

        videoView.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4 ", "王强强");
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
