package com.example.myapplication.module.livechinatab;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.LiveChinaBean;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public interface LiveChinaTabContract {
    //View
    interface LiveChinaTabView extends BaseView<LiveChinaTabPresenter> {
        //TODO请求各种数据更新UI
        void setResultData(LiveChinaBean liveChinaBean);
    }


    //Presenter
    interface LiveChinaTabPresenter extends BasePresenter {

    }
}
