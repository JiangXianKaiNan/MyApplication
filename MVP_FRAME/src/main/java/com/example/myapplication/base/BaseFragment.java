package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static butterknife.ButterKnife.bind;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:35
 * 作 者：T
 * 微信：704003376
 */

public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutId(), null);
         unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        setGoneFragment();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            onHidden();
        } else {
            onShow();
        }
    }

    /**
     * 加载的Fragment的布局
     *
     * @return
     */
    public abstract int getFragmentLayoutId();

    /**
     * Fragment初始化View控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * Fragment初始化数据
     */
    protected abstract void initData();



    /**
     * 当fragment可见时
     */
    protected void onShow() {
        setGoneFragment();
    }

    /**
     * 当Fragment不可见时
     */
    protected void onHidden() {
        setGoneFragment();
    }

    protected void setGoneFragment() {

    }


    /**
     * 页面却换传递数据
     *
     * @param bundle
     */
    public abstract void setParams(Bundle bundle);

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
