package com.example.myapplication.activity;


import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;

/**
 * Created by w1565 on 2017/7/18
 */

public interface LoginContract {

        interface LoginView extends BaseView<LoginPresenter> {
            void setResultData(LoginBean loginBean);
        }

        interface LoginPresenter extends BasePresenter {
        void setsend(String username, String password, String service, String from);

        }
}
