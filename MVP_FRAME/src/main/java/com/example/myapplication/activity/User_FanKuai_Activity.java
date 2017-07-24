package com.example.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class User_FanKuai_Activity extends BaseActivity {

    Problem_user problem_user;
    MissProblem_user missProblem_user;
    @BindView(R.id.user_back)
    ImageView userBack;
    @BindView(R.id.phone_zhuce)
    Button phoneZhuce;
    @BindView(R.id.email_zhuce)
    Button emailZhuce;
    @BindView(R.id.register_tab)
    PercentLinearLayout registerTab;
    @BindView(R.id.qqq)
    TextView qqq;
    @BindView(R.id.www)
    TextView www;
    @BindView(R.id.register_pager)
    PercentFrameLayout registerPager;

    protected void initData() {
        phoneZhuce.setTextColor(Color.parseColor("#3565a6"));
        emailZhuce.setTextColor(Color.parseColor("#000000"));
        qqq.setBackgroundColor(Color.parseColor("#3565a6"));
        www.setBackgroundColor(Color.parseColor("#ffffff"));

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_user__fan_kuai;
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

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.register_pager, new Problem_user());
        transaction.commit();
    }

    @OnClick({R.id.user_back, R.id.phone_zhuce, R.id.email_zhuce})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (view.getId()) {
            case R.id.user_back:
                finish();
                break;
            case R.id.phone_zhuce:
                phoneZhuce.setTextColor(Color.parseColor("#3565a6"));
                emailZhuce.setTextColor(Color.parseColor("#000000"));
                qqq.setBackgroundColor(Color.parseColor("#3565a6"));
                www.setBackgroundColor(Color.parseColor("#ffffff"));
                if (problem_user == null) {
                    problem_user = new Problem_user();
                    transaction.add(R.id.register_pager, problem_user);
                } else {
                    transaction.show(problem_user);
                }
                break;
            case R.id.email_zhuce:
                phoneZhuce.setTextColor(Color.parseColor("#000000"));
                emailZhuce.setTextColor(Color.parseColor("#3565a6"));
                www.setBackgroundColor(Color.parseColor("#3565a6"));
                qqq.setBackgroundColor(Color.parseColor("#ffffff"));
                if (missProblem_user == null) {
                    missProblem_user = new MissProblem_user();
                    transaction.add(R.id.register_pager, missProblem_user);
                } else {
                    transaction.show(missProblem_user);
                }
                break;
        }
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (missProblem_user != null) {
            transaction.hide(missProblem_user);
        }
        if (problem_user != null) {
            transaction.hide(problem_user);
        }
    }
}


