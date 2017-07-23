package com.example.myapplication.module.home.activity;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.OriginalBean;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-22 10:41
 * 修改人:
 * 修改内容:
 */

public interface OriginalContract {

    interface OriginalView extends BaseView<OriginalPresenter>{
        void setOriginal(OriginalBean original);
    }


    interface OriginalPresenter extends BasePresenter{

    }

}
