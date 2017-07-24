package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginContract.LoginView {
    LoginContract.LoginPresenter loginPresenter;
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
    ImageView numx;
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
        tishiEmail.setText("");
        tishiPass.setText("");
        numx.setVisibility(View.GONE);
        passX.setVisibility(View.GONE);
        pass_click();
        num_click();
    }

    public void num_click() {
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setFocusable(true);
                num.setFocusableInTouchMode(false);
                num.requestFocus();
                num.requestFocusFromTouch();
                InputMethodManager inputManager = (InputMethodManager) num.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(num, 0);
                tishiEmail.setText("");
                tishiPass.setText("");
                passX.setVisibility(View.GONE);
            }
        });
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
                    tishiEmail.setText("");
                    numx.setVisibility(View.VISIBLE);
                    numx.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            num.setText("");
                            numx.setVisibility(View.GONE);
                        }
                    });
                } else {
                    numx.setVisibility(View.GONE);
                    tishiEmail.setText("");
                }
            }
        });

    }

    public void pass_click() {

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                String s2 = pass.getText().toString().trim();

                if (!s2.equals("")) {
                    tishiPass.setText("");
                    passX.setVisibility(View.VISIBLE);
                    passX.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pass.setText("");
                            passX.setVisibility(View.GONE);
                        }
                    });
                } else {
                    passX.setVisibility(View.GONE);
                    tishiPass.setText("");
                }
            }

        });
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setFocusable(true);
                pass.setFocusableInTouchMode(false);
                pass.requestFocus();
                pass.requestFocusFromTouch();
                InputMethodManager inputManager = (InputMethodManager) pass.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(pass, 0);
                numx.setVisibility(View.GONE);
                if (!num.getText().toString().trim().equals("")) {
                    if (num.getText().length() == 11 || (num.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && ss.length() > 0)) {
                        tishiEmail.setText("");
                    } else {
                        tishiEmail.setVisibility(View.VISIBLE);
                        tishiEmail.setText("邮箱/手机号格式不正确");

                    }
                } else {
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
                Button quxiao_butt = (Button) inflate.findViewById(R.id.quxiao_butt);
                Button quedin_butt = (Button) inflate.findViewById(R.id.quedin_butt);
                dialog.setView(inflate);
                quedin_butt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
             /*           OnekeyShare onekeyShare=new OnekeyShare();
                        onekeyShare.show(LoginActivity.this);
                        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
                        platform.authorize();*/
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
            case R.id.login_QQ:
            /*    OnekeyShare onekeyShare=new OnekeyShare();
                onekeyShare.show(LoginActivity.this);
                Platform platform =ShareSDK.getPlatform(QQ.NAME);
                platform.authorize();//单独授权,OnComplete返回的hashmap是空的*/
                break;
            case R.id.login_weibo:
                final AlertDialog dialog_weibo = new AlertDialog.Builder(this).create();
                View inflate_weibo = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
                TextView message_weibo = (TextView) inflate_weibo.findViewById(R.id.message);
                Button quxiao_butt_weibo = (Button) inflate_weibo.findViewById(R.id.quxiao_butt);
                Button quedin_butt_weibo = (Button) inflate_weibo.findViewById(R.id.quedin_butt);
                dialog_weibo.setView(inflate_weibo);
                message_weibo.setText("熊猫频道想要打开微博");
                quedin_butt_weibo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      /*  OnekeyShare onekeyShare=new OnekeyShare();
                        onekeyShare.show(LoginActivity.this);
                        Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
                        platform.authorize();*/
                        dialog_weibo.dismiss();
                    }
                });
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
                aa();


                break;
        }
    }

    public void aa() {
        loginPresenter = new LoginPresenter(LoginActivity.this);
        String num_ed = num.getText().toString().trim();
        String pass_ed = pass.getText().toString().trim();
        String service = "client_transaction";
        String form = "https://reg.cntv.cn/login/login.action";
        loginPresenter.setsend(num_ed, pass_ed, service, form);
        Log.e("tag", "aa: ");
    }

    @Override
    public void setResultData(LoginBean loginBean) {
        SharedPreferences shape = getSharedPreferences("panda", MODE_PRIVATE);
        SharedPreferences.Editor editor = shape.edit();
        String errMsg = loginBean.getErrMsg();
        String errType = loginBean.getErrType();
        String ticket = loginBean.getTicket();
        String user_seq_id = loginBean.getUser_seq_id();
        String usrid = loginBean.getUsrid();
        String timestamp = loginBean.getTimestamp();
        Log.e("tag", "setResultData: " + errMsg);
        editor.putString("errMsg", errMsg);
        editor.putString("errType", errType);
        editor.putString("ticket", ticket);
        editor.putString("user_seq_id", user_seq_id);
        editor.putString("usrid", usrid);
        editor.putString("timestamp", timestamp);
        editor.commit();
        String errMsg1 = shape.getString("errMsg", "");
        String n = num.getText().toString().trim();
        String p = pass.getText().toString().trim();
        if (!n.equals("") && !p.equals("")) {
            if (num.getText().length() == 11 || (num.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && ss.length() > 0)) {

                if (errMsg1.equals("成功")) {
                    editor.putBoolean("login", true);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, Personal_center_Activity.class);
                    startActivity(intent);
                    Toast.makeText(this, errMsg1, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, errMsg1, Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            tishiEmail.setText("邮箱/手机号不能为空");
            if (!n.equals("") && p.equals("")) {
                tishiEmail.setText("");
                tishiPass.setText("密码不能为空");
            }

        }
    }


    @Override
    public void setPresenter(LoginContract.LoginPresenter loginPresenter) {

    }
}
