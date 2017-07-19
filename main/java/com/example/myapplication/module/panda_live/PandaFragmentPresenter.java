package com.example.myapplication.module.panda_live;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.LiveChinaBean;
import com.example.myapplication.network.MyCallBack;

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

    public PandaFragmentPresenter(PandaLiveContract.PandaLiveView pandaLiveView) {
        this.mPandaLiveView = pandaLiveView;
        mPandaChannelModelImp = new PandaChannelModelImp();
        //实例化PandaLiveContract中的Presenter的
        mPandaLiveView.setPresenter(this);
    }




    @Override
    public void start() {
        mPandaChannelModelImp.getLiveData(new MyCallBack<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
            //TODO 交给View层更新UI

            }


            @Override
            public void onFaile(String msg) {

            }
        });

    }
}
