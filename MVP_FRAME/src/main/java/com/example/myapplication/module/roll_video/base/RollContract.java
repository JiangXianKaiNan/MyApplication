package com.example.myapplication.module.roll_video.base;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.RollRollVideoBean;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:14
 * 作 者：T
 * 微信：704003376
 * 契约类  将 M层 V层, P层 对应的接口都放里面
 */
public interface RollContract {

    //View
    interface RollView extends BaseView<Presenter> {
        void setRollData(RollRollVideoBean dataBean);
    }


    //Presenter
    interface Presenter extends BasePresenter {

    }


}
