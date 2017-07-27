package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UpData_Name_Activity extends BaseActivity {

    @BindView(R.id.updata_back)
    ImageView updataBack;
    @BindView(R.id.updata_baocun)
    TextView updataBaocun;
    @BindView(R.id.updata_et)
    EditText updataEt;
    @BindView(R.id.upda_gray)
    ImageView updaGray;
    @BindView(R.id.activity_up_data_name)
    PercentLinearLayout activityUpDataName;
    private SharedPreferences shape;
    private SharedPreferences.Editor editor;


    protected void initData() {


        updaGray.setVisibility(View.VISIBLE);
        updataBaocun.setTextColor(Color.parseColor("#d1d0d0"));
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        updataEt.setText(name);
        shape = getSharedPreferences("panda", MODE_PRIVATE);
        editor = shape.edit();
        String nickname = shape.getString("nickname", "");
        updataEt.setText(nickname);
        updaGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updaGray.setVisibility(View.GONE);
                updataBaocun.setTextColor(Color.parseColor("#ffffff"));
                updataEt.setText("");
            }
        });
        updataEt_click();

    }

    public void updataEt_click() {


        updataEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!updataEt.getText().toString().equals("")) {
                    updaGray.setVisibility(View.VISIBLE);
                    if (updataEt.getText().length() <= 10) {
                        updataBaocun.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final AlertDialog alertDialog = new AlertDialog.Builder(UpData_Name_Activity.this).create();
                                View inflate = LayoutInflater.from(UpData_Name_Activity.this).inflate(R.layout.layout_nick_name, null);
                                alertDialog.setView(inflate);
                                final Button butt = (Button) inflate.findViewById(R.id.butt);

                                butt.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        alertDialog.dismiss();
                                        finish();
                                        editor.putString("nickname", updataEt.getText().toString());
                                        editor.commit();

                                    }
                                });
                                alertDialog.show();
                            }
                        });
                    } else {
                        Toast.makeText(UpData_Name_Activity.this, "参数错误:长度有误。", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    updataBaocun.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(UpData_Name_Activity.this, "参数错误：昵称不能为空。", Toast.LENGTH_SHORT).show();
                        }
                    });
                    updaGray.setVisibility(View.GONE);
                }


                updataBaocun.setTextColor(Color.parseColor("#ffffff"));
                if (!updataEt.getText().toString().trim().equals("")) {
                    updaGray.setVisibility(View.VISIBLE);
                    updaGray.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            updataEt.setText("");
                            updaGray.setVisibility(View.GONE);
                        }
                    });

                } else {
                    updaGray.setVisibility(View.GONE);
                }

            }
        });

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_up_data__name;
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

    @OnClick({R.id.updata_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.updata_back:
                finish();
                break;
        }
    }
}
