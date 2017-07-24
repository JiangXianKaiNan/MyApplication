package com.example.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class PlayVideoActivity extends AppCompatActivity {
    VideoView videoview_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        videoview_top = (VideoView) findViewById(R.id.video_play);
        Intent intent = getIntent();
        String s = intent.getStringExtra("url");
        videoview_top.setVideoURI(Uri.parse(s));

        MediaController controller = new MediaController(this);

        videoview_top.setMediaController(controller);

        controller.setMediaPlayer(videoview_top);

//        controller.setVisibility(View.INVISIBLE);

        videoview_top.setMediaController(controller);

        videoview_top.requestFocus();

        videoview_top.start();   //开始播放
    }
}
