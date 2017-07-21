package com.example.myapplication.module.panda_live;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;

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
        void setResultData(PandaLiveBean pandaLiveBean);
        void setResultData(MultiBean multiBean);
        void setPandatablelist(TableListBaen listBaen);

    }


    //PandaLivePresenter
    interface PandaLivePresenter extends BasePresenter {


    }


}
