package com.example.myapplication.module.livechina;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.LiveChinaContentBean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public interface LiveChinaContract {
    //View
    interface LiveChinaView extends BaseView<LiveChinaPresenter> {
        void setResultData(LiveChinaContentBean liveChinaContentBean);
    }


    //Presenter
    interface LiveChinaPresenter extends BasePresenter {

    }
}
