package com.example.myapplication.module.panda_live;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.PandaFragmentlistData;
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

public class PandaDataListPresenter implements PandaFragmentDataContract.PandaLivePresenter {
    private PandaFragmentDataContract.PandaLiveView mPandaLiveView;
    private PandaChannelModelImp mPandaChannelModelImp;
    private String id;
    int p;
    public PandaDataListPresenter(PandaFragmentDataContract.PandaLiveView pandaLiveView, String id, int p) {
        this.mPandaLiveView = pandaLiveView;
        mPandaChannelModelImp = new PandaChannelModelImp();
        this.id = id;
        this.p = p;
        //实例化PandaLiveContract中的Presenter的
        mPandaLiveView.setPresenter(this);
    }


    @Override
    public void start() {
        Map<String,String> map = new HashMap<>();
//        http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1
        map.put("vsid",id);
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p",p+"");

        mPandaChannelModelImp.getPandaFragmentlistData(map, new MyCallBack<PandaFragmentlistData>() {
            @Override
            public void onSuccess(PandaFragmentlistData pandaFragmentlistData) {
                mPandaLiveView.setPandaFragmentlistData(pandaFragmentlistData);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
