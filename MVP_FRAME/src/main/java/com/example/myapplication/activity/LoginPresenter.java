package com.example.myapplication.activity;

import android.util.Log;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.network.MyCallBack;


/**
 * Created by w1565 on 2017/7/18
 */

public class LoginPresenter implements LoginContract.LoginPresenter {
    private LoginContract.LoginView loginView;
    private PandaChannelModelImp modelImp;

    public LoginPresenter(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        modelImp = new PandaChannelModelImp();
        loginView.setPresenter(this);
    }

    @Override
    public void start() {
    }



    @Override
    public void setsend(String username, String password, String service, String from) {
        Log.e( "setsend: ",username+password+service+from );
            modelImp.getLoginData(username, password, service, from, new MyCallBack<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    loginView.setResultData(loginBean);
                    Log.e("onSuccess: ",loginBean.toString());
                }
                @Override
                public void onFaile(String msg) {

                }
            });
    }
}