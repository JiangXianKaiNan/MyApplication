package com.example.myapplication.module.home;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.HomeDataBean;

import java.util.logging.MemoryHandler;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 *
 *
 *
 *
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {
    //TODO mHomePresenter未初始化
    private HomeContract.HomePresenter mHomePresenter;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.home_fragment;
    }


    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {
        mHomePresenter = presenter;
    }

    @Override
    public void setResultData(HomeDataBean bean) {
        //更新UI

    }

    @Override
    protected void initData() {
        mHomePresenter=new HomePresenter(this);
        //通过P层处理相关业务逻辑
        mHomePresenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {

    }
}
