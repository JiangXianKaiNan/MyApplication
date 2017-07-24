package com.example.myapplication.activity;

import android.os.Bundle;


import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class about_panda extends BaseActivity {




    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_about_panda;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.about_back)
    public void onViewClicked() {
        finish();
    }
}
