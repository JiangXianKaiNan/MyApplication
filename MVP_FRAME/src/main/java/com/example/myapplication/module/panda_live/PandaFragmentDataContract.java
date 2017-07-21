package com.example.myapplication.module.panda_live;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.PandaFragmentlistData;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:18
 * 作 者：T
 * 微信：704003376
 */

public interface PandaFragmentDataContract {


    //PandaLiveView
    interface PandaLiveView extends BaseView<PandaDataListPresenter> {
        //TODO请求各种数据更新UI
        void setPandaFragmentlistData(PandaFragmentlistData pandaFragmentlistData);

    }


    //PandaLivePresenter
    interface PandaLivePresenter extends BasePresenter {


    }


}
