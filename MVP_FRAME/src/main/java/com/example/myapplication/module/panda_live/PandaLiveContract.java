package com.example.myapplication.module.panda_live;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:18
 * 作 者：T
 * 微信：704003376
 */

public interface PandaLiveContract {


    //PandaLiveView
    interface PandaLiveView extends BaseView<PandaLivePresenter> {
        //TODO请求各种数据更新UI

    }


    //PandaLivePresenter
    interface PandaLivePresenter extends BasePresenter {


    }


}
