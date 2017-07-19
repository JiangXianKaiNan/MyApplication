package com.example.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.config.FragmentBuilder;
import com.example.myapplication.module.home.HomeFragment;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.Home_Iv_Original)
    ImageView HomeIvOriginal;
    @BindView(R.id.Home_Iv_Personal)
    ImageView HomeIvPersonal;
    @BindView(R.id.Home_Rl_homeTitle)
    PercentRelativeLayout HomeRlHomeTitle;
    @BindView(R.id.Home_Tv_TitleName)
    TextView HomeTvTitleName;
    @BindView(R.id.Home_Iv_livePersonal)
    ImageView HomeIvLivePersonal;
    @BindView(R.id.Home_Rl_liveTitle)
    PercentRelativeLayout HomeRlLiveTitle;
    @BindView(R.id.Home_ComtentGroup)
    PercentFrameLayout HomeComtentGroup;
    @BindView(R.id.HomeTab_home)
    RadioButton HomeTabHome;
    @BindView(R.id.HomeTab_pandalive)
    RadioButton HomeTabPandalive;
    @BindView(R.id.HomeTab_rollingvideo)
    RadioButton HomeTabRollingvideo;
    @BindView(R.id.HomeTab_pandareport)
    RadioButton HomeTabPandareport;
    @BindView(R.id.HomeTab_livechian)
    RadioButton HomeTabLivechian;
    @BindView(R.id.Home_RadioGrop)
    RadioGroup HomeRadioGrop;



    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        FragmentBuilder.getInstance().init().start(HomeFragment.class).build();
        HomeRlHomeTitle.setVisibility(View.VISIBLE);
//        HomeRlLiveTitle.setVisibility(View.GONE);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.Home_Iv_Original, R.id.Home_Iv_Personal, R.id.Home_Iv_livePersonal, R.id.HomeTab_home, R.id.HomeTab_pandalive, R.id.HomeTab_rollingvideo, R.id.HomeTab_pandareport, R.id.HomeTab_livechian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Home_Iv_Original:// 原创·互动
                break;
            case R.id.Home_Iv_Personal://个人中心

                break;
            case R.id.Home_Iv_livePersonal:// 其他页面的个人中心

                break;
            case R.id.HomeTab_home:// 首页


                FragmentBuilder.getInstance().init().start(HomeFragment.class).build();
                HomeRlHomeTitle.setVisibility(View.VISIBLE);
                HomeRlLiveTitle.setVisibility(View.GONE);
                break;
            case R.id.HomeTab_pandalive:// 熊猫直播

                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("熊猫直播");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
                break;
            case R.id.HomeTab_rollingvideo:// 滚滚视频

                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("滚滚视频");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
                break;
            case R.id.HomeTab_pandareport:// 熊猫播报

                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("熊猫播报");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
                break;
            case R.id.HomeTab_livechian:// 直播中国

                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("直播中国");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
                break;
        }
    }

}
