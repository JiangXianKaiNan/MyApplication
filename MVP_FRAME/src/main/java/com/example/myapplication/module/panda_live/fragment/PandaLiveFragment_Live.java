package com.example.myapplication.module.panda_live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
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
    ImageView IamgeVideo;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    private PandaLiveContract.PandaLiveView mPandaLiveView;
    private PandaLiveFragmentpagerAdapter adapter;
    private List<Fragment> list;



    @Override
    protected void initData() {
        Log.e("Tag","initData");
        mPandaLivPresenter = new PandaFragmentPresenter(this);
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
        Log.e("Tag","initView");
    }

    @Override
    public int getFragmentLayoutId() {
        Log.e("Tag","getFragmentLayoutId");
        return R.layout.pandalive_live;
    }



    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        liveTitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
        liveIntroduction.setText(pandaLiveBean.getLive().get(0).getBrief());
        Log.e("iamge",pandaLiveBean.getLive().get(0).getUrl());
        Glide.with(this).load(pandaLiveBean.getLive().get(0).getImage()).into(IamgeVideo);
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
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivPresenter = pandaLivePresenter;
        Log.e("Tag","setPresenter");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("Tag","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Log.e("Tag","onDestroy");
        super.onDestroy();
    }
}
