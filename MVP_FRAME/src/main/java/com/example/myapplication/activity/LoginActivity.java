package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {

    Editable ss;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_weixin)
    RadioButton loginWeixin;
    @BindView(R.id.login_QQ)
    RadioButton loginQQ;
    @BindView(R.id.login_weibo)
    RadioButton loginWeibo;
    @BindView(R.id.num)
    EditText num;
    @BindView(R.id.num_x)
    ImageView numX;
    @BindView(R.id.tishi_email)
    TextView tishiEmail;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.pass_x)
    ImageView passX;
    @BindView(R.id.tishi_pass)
    TextView tishiPass;
    @BindView(R.id.forget_pass)
    TextView forgetPass;
    @BindView(R.id.dengl)
    Button dengl;


    protected void initData() {
//        // 只能输入数字
//        num.setInputType(InputType.TYPE_CLASS_NUMBER);
//        // 只能输入电话
//        num.setInputType(InputType.TYPE_CLASS_PHONE);
//        //只能输入邮箱
//        num.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        tishiEmail.setVisibility(View.INVISIBLE);
        numX.setVisibility(View.GONE);
        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ss = s;
                String s1 = num.getText().toString().trim();
                if (!s1.equals("")) {
                    tishiEmail.setVisibility(View.INVISIBLE);
                    numX.setVisibility(View.VISIBLE);
                    numX.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            num.setText("");
                            numX.setVisibility(View.GONE);
                        }
                    });
                } else {
                    numX.setVisibility(View.GONE);
                    tishiEmail.setVisibility(View.INVISIBLE);
                }
            }
        });
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setFocusable(true);
                num.setFocusableInTouchMode(true);
                num.requestFocus();
                num.requestFocusFromTouch();
                InputMethodManager inputManager =
                        (InputMethodManager) num.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(num, 0);
                tishiEmail.setVisibility(View.INVISIBLE);
            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {

            }
        });
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setFocusable(true);
                pass.setFocusableInTouchMode(true);
                pass.requestFocus();
                pass.requestFocusFromTouch();
                InputMethodManager inputManager = (InputMethodManager) pass.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(pass, 0);
                if (!num.getText().toString().trim().equals("")) {
                    if (num.getText().length() != 11 || !(num.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && ss.length() > 0)) {
                        tishiEmail.setVisibility(View.VISIBLE);
                        tishiEmail.setText("邮箱/手机号格式不正确");
                    } else {
                        tishiEmail.setVisibility(View.INVISIBLE);
                    }
                } else {
                    tishiEmail.setVisibility(View.VISIBLE);
                    tishiEmail.setText("邮箱/手机号不能为空");
                }
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_login;
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

    @OnClick({R.id.back, R.id.register, R.id.login_weixin, R.id.login_QQ, R.id.login_weibo, R.id.forget_pass, R.id.dengl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.register:
                Intent intent2 = new Intent(LoginActivity.this, Register_Activity.class);
                startActivity(intent2);
                break;
            case R.id.login_weixin:
                final AlertDialog dialog = new AlertDialog.Builder(this).create();
                View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
                TextView message = (TextView) inflate.findViewById(R.id.message);
                Button quxiao_butt = (Button) inflate.findViewById(R.id.quxiao_butt);
                Button quedin_butt = (Button) inflate.findViewById(R.id.quedin_butt);
                dialog.setView(inflate);
//                quedin_butt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
//                        platform.authorize();
//                    }
//                });
                quxiao_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.login_QQ:

//                    Platform platform =ShareSDK.getPlatform(QQ.NAME);
//                    platform.authorize();//单独授权,OnComplete返回的hashmap是空的
//
//
//

                break;
            case R.id.login_weibo:
                final AlertDialog dialog_weibo = new AlertDialog.Builder(this).create();
                View inflate_weibo = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
                TextView message_weibo = (TextView) inflate_weibo.findViewById(R.id.message);
                Button quxiao_butt_weibo = (Button) inflate_weibo.findViewById(R.id.quxiao_butt);
                Button quedin_butt_weibo = (Button) inflate_weibo.findViewById(R.id.quedin_butt);
                dialog_weibo.setView(inflate_weibo);
                message_weibo.setText("熊猫频道想要打开微博");
//                quedin_butt_weibo.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
//                        platform.authorize();
//

//                    }
//                });
                quxiao_butt_weibo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog_weibo.dismiss();
                    }
                });
                dialog_weibo.show();
                break;
            case R.id.forget_pass:
                Intent intent1 = new Intent(LoginActivity.this, Forget_Pass_Activity.class);
                startActivity(intent1);
                break;
            case R.id.dengl:
                break;
        }
    }
//    private void showShare() {
//        OnekeyShare oks = new OnekeyShare();
//        oks.show(this);
//
//    }
}
