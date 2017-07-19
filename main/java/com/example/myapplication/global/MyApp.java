package com.example.myapplication.global;

import android.app.Application;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BaseFragment;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:28
 * 作 者：T
 * 微信：704003376
 */

public class MyApp extends Application {
    public static BaseActivity mContext=null;
    public static BaseFragment lastfragment;

}
