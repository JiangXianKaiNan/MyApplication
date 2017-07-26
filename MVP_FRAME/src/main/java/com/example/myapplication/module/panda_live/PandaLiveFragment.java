package com.example.myapplication.module.panda_live;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.LiveListBean;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.module.panda_live.adapter.PandaLive_PagerAdapter;
import com.example.myapplication.module.panda_live.fragment.PandaLiveFragment_Live;
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

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.PandaLiveView {

    @BindView(R.id.pandalive_tabLayout)
    TabLayout pandaliveTabLayout;
    @BindView(R.id.pandalive_viewpager)
    ViewPager pandaliveViewpager;
    PandaLiveContract.PandaLivePresenter mpandaLivePresenter;
    private ProgressDialog progressDialog;



    @Override
    protected void initData() {
        mpandaLivePresenter = new PandaFragmentPresenter(this,"");
        mpandaLivePresenter.start();
        progressDialog.show();
}


    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载数据...");
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.pandalive_fragment;
    }


    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void setResultData(MultiBean multiBean) {

    }

    @Override
    public void setPandatablelist(TableListBaen listBaen) {
        Log.e("setPandatablelist",listBaen.toString());
        List<String> titles = new ArrayList<>();
        List<Fragment> list = new ArrayList<>();
        list.add(new PandaLiveFragment_Live());
        for(int i = 0;i<listBaen.getTablist().size();i++){
            titles.add(listBaen.getTablist().get(i).getTitle());
            if(i>0) {
                PandaLiveFragment_wonderful fragmentWonderful = new PandaLiveFragment_wonderful();
                Bundle bundle = new Bundle();
                bundle.putString("id", listBaen.getTablist().get(i).getId());
                fragmentWonderful.setArguments(bundle);
                list.add(fragmentWonderful);
            }
        }


        PandaLive_PagerAdapter adapter = new PandaLive_PagerAdapter(getActivity().getSupportFragmentManager(),list,titles);
        pandaliveViewpager.setAdapter(adapter);
        pandaliveTabLayout.setupWithViewPager(pandaliveViewpager);
        pandaliveTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        progressDialog.dismiss();
    }

    @Override
    public void setLiveListData(LiveListBean liveListBean) {

    }
}
