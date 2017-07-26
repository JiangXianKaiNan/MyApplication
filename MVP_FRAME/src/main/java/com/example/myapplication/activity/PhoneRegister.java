package com.example.myapplication.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class PhoneRegister extends BaseFragment {


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.phone_phone)
    TextView phonePhone;
    @BindView(R.id.tupian_yanzhang)
    EditText tupianYanzhang;
    @BindView(R.id.phone_image)
    ImageView phoneImage;
    @BindView(R.id.phone_tpyz)
    TextView phoneTpyz;
    @BindView(R.id.duanxin_yanzhang)
    EditText duanxinYanzhang;
    @BindView(R.id.phone_but)
    Button phoneBut;
    @BindView(R.id.phone_dxyz)
    TextView phoneDxyz;
    @BindView(R.id.register_pass)
    EditText registerPass;
    @BindView(R.id.phone_tsmm)
    TextView phoneTsmm;
    @BindView(R.id.phone_treaty)
    CheckBox phoneTreaty;
    @BindView(R.id.phone_gouxuan)
    TextView phoneGouxuan;
    @BindView(R.id.phone_register)
    Button phoneRegister;
    Unbinder unbinder;
    private String JSESSIONID = null;
    private byte[] bytes;
    private String exception;
    private String phoneyanzhengma;
    private String passwrod;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_phone_register;
    }

    @Override
    protected void initView(View view) {
        getPersonalRegImgCheck();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.phone_image, R.id.phone_but, R.id.phone_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_image:
                getPersonalRegImgCheck();
                break;
            case R.id.phone_but:
                String tPhoneNumber = phone.getText().toString().trim();
//                    图形验证码
                String imgyanzhengma = tupianYanzhang.getText().toString().trim();

                if (tPhoneNumber.equals("")&&tPhoneNumber==null&&imgyanzhengma.equals("")&&imgyanzhengma==null&&phoneyanzhengma.equals("")&&phoneyanzhengma==null) {
                    phone.setText("手机号不能为空");
                    tupianYanzhang.setText("验证码不能为空");

                }
                getPersonalRegPhoneCheck();
                break;
            case R.id.phone_register:
                try {
                    getRegister();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                phoneTreaty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked==true) {
                            try {
                                getRegister();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }else {
                            Toast.makeText(getActivity(), "未勾选《央视网网络服务使用协议》", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
    public void getPersonalRegImgCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
                okHttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Headers headers = response.headers();

                        JSESSIONID = headers.get("Set-Cookie");
                        Log.e("TAG", "图形验证码的额" + JSESSIONID);

//                            for (int x=0;x<headers.size();x++){
//                                String name = headers.name(x);
//                                String name1 = headers.get(name);
//                                if(name1.contains("JSESSIONID")) {
//                                    JSESSIONID=name1;
//                                    break;
//                                }
//                                Log.e("TAG",name1+"---+++");
//                            }

                        bytes = response.body().bytes();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Drawable captchaImage = byteToDrawable(bytes);
                                phoneImage.setImageDrawable(captchaImage);
                            }
                        });
                    }
                });
            }
        }).start();
    }


    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }


    public void getPersonalRegPhoneCheck() {
//17600304681


        OkHttpClient click = new OkHttpClient();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
//                    手机号
        String tPhoneNumber = phone.getText().toString().trim();
//                    图形验证码
        String imgyanzhengma = tupianYanzhang.getText().toString().trim();
//                请求  获取验证码的 网络请求
//                post 请求体
        Log.e("TAG", "图形验证码" + JSESSIONID);
        RequestBody body = new FormBody.Builder()
                .add("method", "getRequestVerifiCodeM")
                .add("mobile", tPhoneNumber)
                .add("verfiCodeType", "1")
                .add("verificationCode", imgyanzhengma)
                .build();
        try {
//                    post  请求头
            Request request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", JSESSIONID)
                    .post(body).build();

            click.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    exception = e.getMessage().toString();
                    Log.e("TAG", e.getMessage().toString());


                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String string = response.body().string();
                    Log.e("TAG", "手机验证码结果" + string);

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


    public void getRegister() throws UnsupportedEncodingException {

        OkHttpClient client = new OkHttpClient();
//                    手机号
        String tPhoneNumber = phone.getText().toString().trim();
        Log.e("TAG", "手机号：" + tPhoneNumber);
//                    图形验证码
        String imgyanzhengma = tupianYanzhang.getText().toString().trim();
        //手机验证码
        phoneyanzhengma = duanxinYanzhang.getText().toString().trim();
        Log.e("TAG", "手机验证码：" + phoneyanzhengma);
//mima
        passwrod = registerPass.getText().toString().trim();

        Log.e("TAG", "密码：" + passwrod);

//                请求  获取验证码的 网络请求
//                post 请求体
        Log.e("TAG", "图形验证码" + JSESSIONID);
        RequestBody body = new FormBody.Builder()
                .add("method", "saveMobileRegisterM")
                .add("mobile", tPhoneNumber)
                .add("verfiCode", phoneyanzhengma)
                .add("passWd", URLEncoder.encode(passwrod, "UTF-8"))
                .add("verfiCod eType", "1")
                .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                .build();

        Request build = new Request.Builder().url("https://reg.cntv.cn/regist/mobileRegist.do")
                .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                .post(body)
                .build();

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                if (BuildConfig.DEBUG) {
                    Log.e("TAG", e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String tString = response.body().string();
                if (BuildConfig.DEBUG) {
                    Log.e("TAG", "注册：" + tString);

                    if(tString.equals("Success")) {
                        Toast.makeText(getActivity(), "注册成功，返回注册", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                }
            }
        });

    }
}