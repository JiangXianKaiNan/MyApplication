package com.example.myapplication.module.livechina;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.LiveChinaContentBean;
import com.example.myapplication.network.MyCallBack;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class LiveChinaPresenter implements LiveChinaContract.LiveChinaPresenter{
    private LiveChinaContract.LiveChinaView mLiveChinaView;
    private PandaChannelModelImp modelImp;
     private String url;
    public LiveChinaPresenter(String urll,LiveChinaContract.LiveChinaView mLiveChinaView) {
        this.mLiveChinaView = mLiveChinaView;
        this.url = urll;
        modelImp = new PandaChannelModelImp();
        mLiveChinaView.setPresenter(this);
    }

    @Override
    public void start() {
        modelImp.getliveChinaContentData(url,new MyCallBack<LiveChinaContentBean>() {
            @Override
            public void onSuccess(LiveChinaContentBean liveChinaContentBean) {
                mLiveChinaView.setResultData(liveChinaContentBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
