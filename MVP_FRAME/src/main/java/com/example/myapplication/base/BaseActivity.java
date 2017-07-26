package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myapplication.global.MyApp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static butterknife.ButterKnife.bind;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:30
 * 作 者：T
 * 微信：704003376
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        MyApp.mContext=this;
        unbinder = ButterKnife.bind(this);
        initView();
        initListener();
        loadData();
        Log.e("BaseActivity", "BaseActivity:->onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("BaseActivity", "BaseActivity:->onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("BaseActivity", "BaseActivity:->onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("BaseActivity", "BaseActivity:->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("BaseActivity", "BaseActivity:->onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("BaseActivity", "BaseActivity:->onStop");
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



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("BaseActivity", "BaseActivity:->onDestroy");
        unbinder.unbind();
    }

}
