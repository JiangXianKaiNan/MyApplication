package com.example.myapplication.module.home;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.example.myapplication.model.bean.HomeDataBean;
import com.example.myapplication.network.MyCallBack;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:33
 * 作 者：T
 * 微信：704003376
 * <p>
 * Preenter层  主要负责处理程序中的业务逻辑，和 通知View层(通过接口的方式)更新UI
 */
public class HomePresenter implements HomeContract.HomePresenter {
    private HomeContract.HomeView homeView;
    private PandaChannelModelImp modelImp;

    public HomePresenter(HomeContract.HomeView homeView) {
        this.homeView = homeView;
        modelImp = new PandaChannelModelImp();
        //实例化
        homeView.setPresenter(this);
    }


    @Override
    public void start() {
        //处理相关业务逻辑
        modelImp.getHomeData(new MyCallBack<HomeDataBean>() {
            @Override
            public void onSuccess(HomeDataBean homeDataBean) {
                //P层是桥梁 将Model层获取的数据交给View层更新UI
                homeView.setResultData(homeDataBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });



    }


//    @Override
//    public String setAmazingData(String url) {
//      modelImp.getWinderfulTwo(url, new MyCallBack<HomeCCTVBean>() {
//          @Override
//          public void onSuccess(HomeCCTVBean homeCCTVBean) {
//              homeView.setXX(homeCCTVBean);
//          }
//
//          @Override
//          public void onFaile(String msg) {
//
//          }
//      });
//        return null;
//    }

}
