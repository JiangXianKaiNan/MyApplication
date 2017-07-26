package com.example.myapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends BaseActivity {


    @BindView(R.id.set_back)
    ImageView setBack;
    @BindView(R.id.accept_box)
    CheckBox acceptBox;
    @BindView(R.id.automatic_box)
    CheckBox automaticBox;
    @BindView(R.id.laji)
    TextView laji;
    @BindView(R.id.clear)
    PercentRelativeLayout clear;
    @BindView(R.id.user_tickling)
    PercentRelativeLayout userTickling;
    @BindView(R.id.upgrade)
    PercentRelativeLayout upgrade;
    @BindView(R.id.goodreputation)
    PercentRelativeLayout goodreputation;
    @BindView(R.id.about_pandachannel)
    PercentRelativeLayout aboutPandachannel;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_set;
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

    @OnClick({R.id.set_back, R.id.accept_box, R.id.automatic_box, R.id.clear, R.id.user_tickling, R.id.upgrade, R.id.goodreputation, R.id.about_pandachannel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_back:
                finish();
                break;
            case R.id.accept_box:
                break;
            case R.id.automatic_box:
                break;
            case R.id.clear:
                final AlertDialog dialog = new AlertDialog.Builder(this).create();
                View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
                TextView message = (TextView) inflate.findViewById(R.id.message);
                Button quxiao_butt = (Button) inflate.findViewById(R.id.quxiao_butt);
                Button quedin_butt = (Button) inflate.findViewById(R.id.quedin_butt);
                message.setText("确认清除缓存吗？");
                quedin_butt.setTextColor(Color.parseColor("#d1d0d0"));
                dialog.setView(inflate);
                quedin_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        laji.setText("0.00M");
                        dialog.dismiss();
                    }
                });
                quxiao_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.user_tickling:
                Intent intent = new Intent(SetActivity.this, User_FanKuai_Activity.class);
                startActivity(intent);

                break;
            case R.id.upgrade:
                final ProgressDialog dialog1 = new ProgressDialog(this);
                dialog1.show();
                dialog1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(SetActivity.this, "已是最新版本", Toast.LENGTH_SHORT).show();
                                dialog1.dismiss();
                            }

                        });

                    }
                }).start();

                break;
            case R.id.goodreputation:
                break;
            case R.id.about_pandachannel:
                Intent intent1 = new Intent(SetActivity.this, about_panda.class);
                startActivity(intent1);
                break;
        }
    }
}
