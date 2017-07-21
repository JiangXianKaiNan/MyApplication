package com.example.myapplication.global;

import android.app.Application;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:28
 * 作 者：T
 * 微信：704003376
 */

public class MyApp extends Application {
    public static BaseActivity mContext=null;
    public static BaseFragment lastfragment;
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setSinaWeibo("3921700954", "5970114b717c193cff00171d", "http://sns.whalecloud.com");
        //微信
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");

    }
}
