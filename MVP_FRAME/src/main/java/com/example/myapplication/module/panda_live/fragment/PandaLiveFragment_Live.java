package com.example.myapplication.module.panda_live.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.module.panda_live.PandaFragmentPresenter;
import com.example.myapplication.module.panda_live.PandaLiveContract;
import com.example.myapplication.module.panda_live.adapter.PandaLiveFragmentpagerAdapter;
import com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet.Live_multiangle;
import com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet.Sidelook_sidechat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ASUS on 2017/7/19.
 */

public class PandaLiveFragment_Live extends BaseFragment implements PandaLiveContract.PandaLiveView {
    @BindView(R.id.live_title)
    TextView liveTitle;
    @BindView(R.id.live_checkbox)
    CheckBox liveCheckbox;
    @BindView(R.id.live_pager)
    ViewPager livePager;
    @BindView(R.id.live_tablayout)
    TabLayout liveTablayout;
    Unbinder unbinder;
    @BindView(R.id.live_Introduction)
    TextView liveIntroduction;
    Unbinder unbinder1;
    @BindView(R.id.Iamge_video)
    ImageView IamgeVideo;
    Unbinder unbinder2;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    private PandaLiveContract.PandaLiveView mPandaLiveView;
    private PandaLiveFragmentpagerAdapter adapter;

    @Override
    protected void initData() {
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();
        List<Fragment> list = new ArrayList<>();
        list.add(new Live_multiangle());
        list.add(new Sidelook_sidechat());
        adapter = new PandaLiveFragmentpagerAdapter(getActivity().getSupportFragmentManager(), list);
        livePager.setAdapter(adapter);
        liveTablayout.setupWithViewPager(livePager);
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.pandalive_live;
    }


    @OnClick(R.id.live_checkbox)
    public void onViewClicked() {
        liveCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liveCheckbox.isChecked() == true) {
//                    liveCheckbox.setChecked(true);
                    liveIntroduction.setVisibility(View.VISIBLE);
                } else {
                    liveIntroduction.setVisibility(View.GONE);
//                    liveCheckbox.setChecked(false);
                }
            }
        });
    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        liveTitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
        liveIntroduction.setText(pandaLiveBean.getLive().get(0).getBrief());
        Log.e("iamge",pandaLiveBean.getLive().get(0).getUrl());
        Glide.with(this).load(pandaLiveBean.getLive().get(0).getImage()).into(IamgeVideo);
    }

    @Override
    public void setResultData(MultiBean multiBean) {
//        Log.e("mulitangleBea",multiBean.getList().toString());
    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivPresenter = pandaLivePresenter;

    }

}
