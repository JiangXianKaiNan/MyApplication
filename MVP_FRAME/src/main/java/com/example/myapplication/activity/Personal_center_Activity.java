package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.network.HttpUtils;
import com.example.myapplication.network.MyCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


//  个人中心
public class Personal_center_Activity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.login_text)
    TextView loginText;
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
    private String userface;
    private String nickname;
    private String errMsg;
    private String iii;
    private String nickname1;

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

        Glide.with(this).load(R.drawable.personal_login_head).transform(new GlideCircleTransform(this)).into(loginImage);
        loginText.setText("点击登录");
        SharedPreferences shape = getSharedPreferences("panda", MODE_PRIVATE);
        iii = shape.getString("iii", "");
        errMsg = shape.getString("errMsg", "");
        nickname1 = shape.getString("nickname", "");
        String user_seq_id = shape.getString("user_seq_id", "");
        Log.e("sss", "user_seq_id: " + user_seq_id);
        if (errMsg.equals("成功")) {
            HttpUtils.getInstance().get("http://my.cntv.cn/intf/napi/api.php?client=ipanda_mobile&method=user.getNickNameAndFace&userid=" + user_seq_id, null, new MyCallBack<Person_CenterBean>() {

                public void onSuccess(Person_CenterBean person_centerBean) {
                    userface = person_centerBean.getContent().getUserface();
                    Personal_center_Activity.this.nickname = person_centerBean.getContent().getNickname();
                    Log.e("sss", "initData: " + userface);
                    Log.e("sss", "initData: " + Personal_center_Activity.this.nickname);
                    if (!iii.equals("")) {
                        Glide.with(Personal_center_Activity.this).load(iii).transform(new GlideCircleTransform(Personal_center_Activity.this)).into(loginImage);
                    } else {
                        Glide.with(Personal_center_Activity.this).load(userface).transform(new GlideCircleTransform(Personal_center_Activity.this)).into(loginImage);
                    }
                    if (!nickname1.equals("")) {
                        loginText.setText(nickname1);
                    } else {
                        loginText.setText(Personal_center_Activity.this.nickname + "");
                    }
                }

                public void onFaile(String msg) {
                }
            });

        } else {
            Glide.with(this).load(R.drawable.personal_login_head).into(loginImage);
            loginText.setText("点击登录");
        }
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
                if (errMsg.equals("成功")) {
                    Intent intent = new Intent(Personal_center_Activity.this, Personal_Message_Activity.class);
                    if (!iii.equals("")) {
                        intent.putExtra("image", iii);
                    } else {
                        intent.putExtra("image", userface);
                    }
                    if (!nickname1.equals("")) {
                        intent.putExtra("name", nickname1);
                    } else {
                        intent.putExtra("name", nickname);
                    }

                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Personal_center_Activity.this, LoginActivity.class);
                    startActivity(intent);

                }
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
