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

public class Register_Activity extends BaseActivity {

    PhoneRegister phoneRegister;
    EmailRegister emailRegister;
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
        return R.layout.activity_register;
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
        transaction.replace(R.id.register_pager, new PhoneRegister());
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
                if (phoneRegister == null) {
                    phoneRegister = new PhoneRegister();
                    transaction.add(R.id.register_pager, phoneRegister);
                } else {
                    transaction.show(phoneRegister);
                }
                break;
            case R.id.email_zhuce:
                phoneZhuce.setTextColor(Color.parseColor("#000000"));
                emailZhuce.setTextColor(Color.parseColor("#3565a6"));
                www.setBackgroundColor(Color.parseColor("#3565a6"));
                qqq.setBackgroundColor(Color.parseColor("#ffffff"));
                if (emailRegister == null) {
                    emailRegister = new EmailRegister();
                    transaction.add(R.id.register_pager, emailRegister);
                } else {
                    transaction.show(emailRegister);
                }
                break;
        }
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction) {
        if (emailRegister != null) {
            transaction.hide(emailRegister);
        }
        if (phoneRegister != null) {
            transaction.hide(phoneRegister);
        }
    }
}


