package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.SidelookBean;

/**
 * Created by ASUS on 2017/7/21.
 */

public interface SidelooksidechatContract {

    interface  SidelooksidechatView extends BaseView<SidelooksidechatPresenter>{
        void setSidelookData(SidelookBean sidelookBean);
    }

    //PandaLivePresenter
    interface SidelooksidePresenter extends BasePresenter {


    }
}
