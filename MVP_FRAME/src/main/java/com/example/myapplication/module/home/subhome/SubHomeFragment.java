package com.example.myapplication.module.home.subhome;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.MultiBean;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-19 18:57
 * 修改人:
 * 修改内容:
 */

//只负责View展示

public class SubHomeFragment extends BaseFragment implements SubHomeContract.SubHomeView {
    private SubHomeContract.SubPresenter  mPresenter;
    @Override
    public int getFragmentLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void initData() {
        //在层处理相关逻辑
        mPresenter=new SubHomePresenter(this);
      mPresenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }


    @Override
    public void setPresenter(SubHomeContract.SubPresenter subPresenter) {

        this.mPresenter=subPresenter;
    }

    @Override
    public void getListDataBean(MultiBean bean) {
        //负责更新UI

    }
}
