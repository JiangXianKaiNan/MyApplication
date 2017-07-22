package com.example.myapplication.module.panda_live.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.LiveListBean;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.module.panda_live.PandaFragmentPresenter;
import com.example.myapplication.module.panda_live.PandaLiveContract;
import com.example.myapplication.module.panda_live.adapter.PandaLiveFragmentpagerAdapter;
import com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet.Live_multiangle;
import com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet.Sidelook_sidechat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

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
    @BindView(R.id.live_Introduction)
    TextView liveIntroduction;
    @BindView(R.id.Iamge_video)
    VideoView IamgeVideo;
    Unbinder unbinder;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    private PandaLiveContract.PandaLiveView mPandaLiveView;
    private PandaLiveFragmentpagerAdapter adapter;
    private List<Fragment> list;
    private String flv1 = "http://ipanda.vtime.cntv.cloudcdn.net:8000/live/flv/channel54?AUTH=e6wH+irSHbGV6vSASn9wxqzWZ5tk1JJED1f8RQpGx+Nu7yNJFkfWWE7WE5JhUdG4c0UrfJgITMLysEh6GbX4Og==";


    @Override
    protected void initData() {
        Log.e("Tag", "initData");
        mPandaLivPresenter = new PandaFragmentPresenter(this,"");
        mPandaLivPresenter.start();
        list = new ArrayList<>();
        list.add(new Live_multiangle());
        list.add(new Sidelook_sidechat());
        adapter = new PandaLiveFragmentpagerAdapter(getChildFragmentManager(), list);
        livePager.setAdapter(adapter);
        liveTablayout.setupWithViewPager(livePager);


    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {
        Log.e("URLURLURLURLURL",flv1);
        IamgeVideo.setVideoURI(Uri.parse("http://livechina.cntv.wscdns.com:8000/live/flv/channel369?AUTH=ampQYfwK3AJo9dmXUoWPN3EL/DUmZG+yaE5M62GwQ87KBW5Kb9s9eJ7ZSPASP2kj/0TTNkXxO7niJfrmPtl7RA=="));
        MediaController controller = new MediaController(getActivity());
        IamgeVideo.setMediaController(controller);

        controller.setMediaPlayer(IamgeVideo);

//        controller.setVisibility(View.INVISIBLE);

        IamgeVideo.setMediaController(controller);

        IamgeVideo.requestFocus();

        IamgeVideo.start();   //开始播放
    }

    @Override
    public int getFragmentLayoutId() {
        Log.e("Tag", "getFragmentLayoutId");
        return R.layout.pandalive_live;
    }


    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        liveTitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
        liveIntroduction.setText(pandaLiveBean.getLive().get(0).getBrief());
        Log.e("iamge", pandaLiveBean.getLive().get(0).getUrl());
        liveCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    liveIntroduction.setVisibility(View.VISIBLE);
                } else {
                    liveIntroduction.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void setResultData(MultiBean multiBean) {
//        Log.e("mulitangleBea",multiBean.getList().toString());
    }

    @Override
    public void setPandatablelist(TableListBaen listBaen) {
    }

    @Override
    public void setLiveListData(LiveListBean liveListBean) {
    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivPresenter = pandaLivePresenter;
        Log.e("Tag", "setPresenter");
    }


    @Override
    public void onDestroy() {
        Log.e("Tag", "onDestroy");
        super.onDestroy();
    }

}
