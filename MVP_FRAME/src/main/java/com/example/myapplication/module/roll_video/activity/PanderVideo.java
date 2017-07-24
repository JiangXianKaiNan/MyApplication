package com.example.myapplication.module.roll_video.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
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
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        jCVideoPlayer.setUp(Urls.ROLLIMG, title);
        jCVideoPlayer.ivThumb.setImageResource(R.mipmap._no_img);
    }
}
