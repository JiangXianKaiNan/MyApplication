package com.example.myapplication.module.livechinatab;

import android.util.Log;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.LiveChinaBean;
import com.example.myapplication.network.MyCallBack;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class LiveChinaTabPresenter implements LiveChinaTabContract.LiveChinaTabPresenter{
    private LiveChinaTabContract.LiveChinaTabView mLiveChinaTabView;
    private PandaChannelModelImp modelImp;

    public LiveChinaTabPresenter(LiveChinaTabContract.LiveChinaTabView mLiveChinaTabView) {
        this.mLiveChinaTabView = mLiveChinaTabView;
        modelImp = new PandaChannelModelImp();
        mLiveChinaTabView.setPresenter(this);
    }

    @Override
    public void start() {
       modelImp.getLiveData(new MyCallBack<LiveChinaBean>() {
           @Override
           public void onSuccess(LiveChinaBean liveChinaBean) {
               if(liveChinaBean.equals("")){
                   return;
               }
               Log.d("LiveChinaTabPresenter", "liveChinaBean:" + liveChinaBean.toString());
               mLiveChinaTabView.setResultData(liveChinaBean);

           }

           @Override
           public void onFaile(String msg) {

           }
       });
    }
}
