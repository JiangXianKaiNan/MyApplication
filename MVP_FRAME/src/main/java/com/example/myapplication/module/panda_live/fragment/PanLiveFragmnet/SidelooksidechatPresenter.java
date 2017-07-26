package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.SidelookBean;
import com.example.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2017/7/21.
 */

public class SidelooksidechatPresenter implements SidelooksidechatContract.SidelooksidePresenter {

    private SidelooksidechatContract.SidelooksidechatView mPidelooksidechatview;
    private PandaChannelModelImp mPandaChannelModelImp;
    private int P;
    public SidelooksidechatPresenter(SidelooksidechatContract.SidelooksidechatView mPidelooksidechatview, int p) {
        this.mPidelooksidechatview = mPidelooksidechatview;
        this.P = p;
        mPandaChannelModelImp = new PandaChannelModelImp();
        mPidelooksidechatview.setPresenter(this);
    }
    @Override
    public void start() {
        Map<String,String> map = new HashMap<>();

        map.put("prepage","20");
        map.put("nature","1");
        map.put("app","ipandaApp");
        map.put("page",P+"");
        map.put("itemid","zhiboye_chat");
        mPandaChannelModelImp.getSidelookSidechattData(map, new MyCallBack<SidelookBean>() {
            @Override
            public void onSuccess(SidelookBean sidelookBean) {
                mPidelooksidechatview.setSidelookData(sidelookBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });

    }
}
