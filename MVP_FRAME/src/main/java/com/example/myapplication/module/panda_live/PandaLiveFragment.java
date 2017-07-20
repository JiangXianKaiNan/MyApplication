package com.example.myapplication.module.panda_live;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.module.panda_live.adapter.PandaLive_PagerAdapter;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_Live;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_Supercute;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_bear;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_especially;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_file;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_original;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_thing;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_top;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_wonderful;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:23
 * 作 者：T
 * 微信：704003376
 * <p>
 * 熊猫直播模块的View层  需要通过P层处理逻辑并且获取数据
 */

public class PandaLiveFragment extends BaseFragment {

    @BindView(R.id.pandalive_tabLayout)
    TabLayout pandaliveTabLayout;
    @BindView(R.id.pandalive_viewpager)
    ViewPager pandaliveViewpager;





    @Override
    protected void initData() {

        List<Fragment> list = new ArrayList<>();
        list.add(new PandaLiveFragment_Live());
        list.add(new PandaLiveFragment_wonderful());
        list.add(new PandaLiveFragment_bear());
        list.add(new PandaLiveFragment_Supercute());
        list.add(new PandaLiveFragment_file());
        list.add(new PandaLiveFragment_top());
        list.add(new PandaLiveFragment_thing());
        list.add(new PandaLiveFragment_especially());
        list.add(new PandaLiveFragment_original());
        PandaLive_PagerAdapter adapter = new PandaLive_PagerAdapter(getActivity().getSupportFragmentManager(),list);
        pandaliveViewpager.setAdapter(adapter);
        pandaliveTabLayout.setupWithViewPager(pandaliveViewpager);
        pandaliveTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.pandalive_fragment;
    }



}
