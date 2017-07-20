package com.example.myapplication.module.home.subhome;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.model.bean.MultiBean;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-19 18:55
 * 修改人:
 * 修改内容:
 */

public interface SubHomeContract {
    //View层
     interface  SubHomeView extends BaseView<SubPresenter>{
          //TODO获取数据 更新UI方法
         void   getListDataBean(MultiBean bean);
     }


    //P层
    interface  SubPresenter extends BasePresenter{


    }


}
