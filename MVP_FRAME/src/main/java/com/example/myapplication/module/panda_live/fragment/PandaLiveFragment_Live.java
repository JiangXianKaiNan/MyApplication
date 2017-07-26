package com.example.myapplication.module.panda_live.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    private PandaLiveContract.PandaLiveView mPandaLiveView;
    private PandaLiveFragmentpagerAdapter adapter;
    private List<Fragment> list;
    private boolean available = false ;

//    private String flv1 = "http://livechina.cntv.wscdns.com:8000/live/flv/channel369?AUTH=ampQYfwK3AJo9dmXUoWPN3EL/DUmZG+yaE5M62GwQ87KBW5Kb9s9eJ7ZSPASP2kj/0TTNkXxO7niJfrmPtl7RA==";
    /*ProgressDialog dialog;*/
private String flv1 ="";
    private NetworkInfo mNetworkInfo;
    private ConnectivityManager mConnectivityManager;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String title = intent.getStringExtra("title");
            flv1 = intent.getStringExtra("url");

            liveTitle.setText("[正在直播]" + title);
            wangluopanduan();

       }
    };


    public void wangluopanduan(){
        mConnectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        Log.e("456456",""+mNetworkInfo);
        if(mNetworkInfo==null){
            Toast.makeText(getActivity(), "当前无网络", Toast.LENGTH_SHORT).show();
        }else{
            available = mNetworkInfo.isAvailable();

                int netWorkType =mNetworkInfo.getType();
                if(netWorkType==ConnectivityManager.TYPE_WIFI){
                    IamgeVideo.setVideoURI(Uri.parse(flv1));
                    IamgeVideo.requestFocus();
                    IamgeVideo.start();
                }else if(netWorkType==ConnectivityManager.TYPE_MOBILE){
                    showNormalDialog();
                }
        }
    }


    @Override
    protected void initData() {

        Log.e("Tag", "initData");
        mPandaLivPresenter = new PandaFragmentPresenter(this, "");
        mPandaLivPresenter.start();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("zhibo");
        getActivity().registerReceiver(receiver, intentFilter);
        if(!flv1.equals("")){
            wangluopanduan();
        }else {
            Toast.makeText(getActivity(), "当前网络地址为空", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public void setParams(Bundle bundle) {

    }

    private void showNormalDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialoglayout, null);//获取自定义布局
        builder.setView(view);
        final AlertDialog dlg = builder.create();
        dlg.show();
        dlg.setCanceledOnTouchOutside(false);
        view.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IamgeVideo.setVideoURI(Uri.parse(flv1));
                IamgeVideo.requestFocus();
                IamgeVideo.start();
                dlg.dismiss();

        }
        });

        view.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
                return;
            }
        });

    }

    @Override
    protected void initView(View view) {

        list = new ArrayList<>();
        list.add(new Live_multiangle());
        list.add(new Sidelook_sidechat());
        adapter = new PandaLiveFragmentpagerAdapter(getChildFragmentManager(), list);
        livePager.setAdapter(adapter);
        liveTablayout.setupWithViewPager(livePager);
        liveTablayout.setTabMode(TabLayout.GRAVITY_CENTER);
    }

    @Override
    public int getFragmentLayoutId() {

        Log.e("Tag", "getFragmentLayoutId");
        return R.layout.pandalive_live;
    }


    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {
        /*dialog.dismiss();*/
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
