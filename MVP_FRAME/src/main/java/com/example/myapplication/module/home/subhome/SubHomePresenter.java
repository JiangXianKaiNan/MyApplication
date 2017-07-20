package com.example.myapplication.module.home.subhome;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.module.home.HomeContract;
import com.example.myapplication.network.MyCallBack;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-19 18:59
 * 修改人:
 * 修改内容:
 */

public class SubHomePresenter implements SubHomeContract.SubPresenter {

   private SubHomeContract.SubHomeView mView;
  private PandaChannelModelImp  mModelImpl;

    public SubHomePresenter(SubHomeContract.SubHomeView subView){
        mView=subView;
          mModelImpl=new PandaChannelModelImp();
        subView.setPresenter(this);

    }



    @Override
    public void start() {
        //处理逻辑 (获取数据交给View更新UI)
        mModelImpl.getMultiData(new MyCallBack<MultiBean>() {
            @Override
            public void onSuccess(MultiBean multiBean) {
                mView.getListDataBean(multiBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });


    }
}
