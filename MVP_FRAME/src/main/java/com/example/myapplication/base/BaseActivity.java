package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.global.MyApp;

import butterknife.ButterKnife;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:30
 * 作 者：T
 * 微信：704003376
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        MyApp.mContext=this;
        ButterKnife.bind(this);
        initView();
        initListener();
        loadData();
    }

    /**
     *   加载Activity的布局
     * @return Activity的布局ID
     */
    public abstract int getActivityLayoutId();

    /**
     * Activity初始化View控件
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 加载数据
     */
    protected abstract void loadData();

}
