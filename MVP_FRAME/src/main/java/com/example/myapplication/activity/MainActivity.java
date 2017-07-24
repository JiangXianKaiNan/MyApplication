package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.myapplication.Home_Iv_Personal_Fragment;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.config.FragmentBuilder;
import com.example.myapplication.global.MyApp;
import com.example.myapplication.module.home.HomeFragment;
import com.example.myapplication.module.panda_live.PandaLiveFragment;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;

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

    private FragmentManager fragmentManager = getSupportFragmentManager();



    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        FragmentBuilder.getInstance().init().start(HomeFragment.class).build();
         HomeRlHomeTitle.setVisibility(View.VISIBLE);
//     View   HomeRlLiveTitle.setVisibility(View.GONE);

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
                Intent intent=new Intent(MainActivity.this,Personal_center_Activity.class);
                startActivity(intent);
                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("个人中心");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
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
                FragmentBuilder.getInstance().init().start(PandaLiveFragment.class).build();
                break;
            case R.id.HomeTab_rollingvideo:// 滚滚视频

                HomeRlHomeTitle.setVisibility(View.GONE);
                HomeTvTitleName.setText("滚滚视频");
                HomeRlLiveTitle.setVisibility(View.VISIBLE);
                break;
            case R.id.HomeTab_pandareport:// 熊猫播报
                FragmentBuilder.getInstance().init().start(PandaFragment.class).build();
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

    /**
     * 自定义回退栈管理；
     * 获取栈顶的fragment的名字，判断名字是否和主页的名字是否一样，
     * 如果一样就退出应用，如果不是就回退上一个fragment；
     */
    @Override
    public void onBackPressed() {
        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomeFragment".equals(simpleName) ||
                "PandaLiveFragment".equals(simpleName) ||
                "FindFragment".equals(simpleName) ||
                "MyFragment".equals(simpleName)) {

            finish();
        } else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();//
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                MyApp.lastfragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }
    }

}
