package com.example.myapplication.module.panda_live;

import android.util.Log;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.LiveListBean;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:27
 * 作 者：T
 * 微信：704003376
 * <p>
 * 熊猫直播 P层  获取Model层的数据，并将数据交给View层更新UI
 */

public class PandaFragmentPresenter implements PandaLiveContract.PandaLivePresenter {
    private PandaLiveContract.PandaLiveView mPandaLiveView;
    private PandaChannelModelImp mPandaChannelModelImp;
    private String vsid = "ipanda";
    public PandaFragmentPresenter(PandaLiveContract.PandaLiveView pandaLiveView, String vsid) {
        this.mPandaLiveView = pandaLiveView;
        this.vsid = vsid;
        mPandaChannelModelImp = new PandaChannelModelImp();
        //实例化PandaLiveContract中的Presenter的
        mPandaLiveView.setPresenter(this);
    }

    @Override
    public void start() {
        Log.e("-***----","456456456");
        mPandaChannelModelImp.getPandaLiveData(new MyCallBack<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {
                Log.e("网络请求_________",pandaLiveBean.toString());

                //TODO 交给View层更新UI
                mPandaLiveView.setResultData(pandaLiveBean);
            }


            @Override
            public void onFaile(String msg) {

            }
        });


    }

    @Override
    public void setUid(String uid) {


    }
}
