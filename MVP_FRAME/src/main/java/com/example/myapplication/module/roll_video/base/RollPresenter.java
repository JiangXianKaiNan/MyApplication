package com.example.myapplication.module.roll_video.base;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.RollRollVideoBean;
import com.example.myapplication.network.MyCallBack;

import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:33
 * 作 者：T
 * 微信：704003376
 * <p>
 * Preenter层  主要负责处理程序中的业务逻辑，和 通知View层(通过接口的方式)更新UI
 */
public class RollPresenter implements RollContract.Presenter {
    private RollContract.RollView rollView;
    private PandaChannelModelImp modelImp;

    public RollPresenter(RollContract.RollView rollView) {
        this.rollView = rollView;
        modelImp = new PandaChannelModelImp();
        //实例化
        rollView.setPresenter(this);
    }


    @Override
    public void start() {
        //处理相关业务逻辑

        modelImp.getRollVideoData(new MyCallBack<RollRollVideoBean>() {
            @Override
            public void onSuccess(RollRollVideoBean rollRollVideoBean) {
                rollView.setRollData(rollRollVideoBean);
            }

            @Override
            public void onFaile(String msg) {
            }
        });

    }


}
