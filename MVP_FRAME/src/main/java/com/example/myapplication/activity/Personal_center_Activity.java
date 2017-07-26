package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


//  个人中心
public class Personal_center_Activity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.login)
    LinearLayout login;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textt)
    TextView textt;
    @BindView(R.id.hostory)
    RelativeLayout hostory;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.textt1)
    TextView textt1;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textt2)
    TextView textt2;
    @BindView(R.id.set)
    RelativeLayout set;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_personal_center;
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

    @OnClick({R.id.back, R.id.login, R.id.hostory, R.id.shoucang, R.id.set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.login:
                Intent intent = new Intent(Personal_center_Activity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.hostory:
                Intent intent1 = new Intent(Personal_center_Activity.this, HostoryActivity.class);
                startActivity(intent1);
                break;
            case R.id.shoucang:
                Intent intent2 = new Intent(Personal_center_Activity.this, ShouCangActivity.class);
                startActivity(intent2);
                break;
            case R.id.set:
                Intent intent3 = new Intent(Personal_center_Activity.this, SetActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
