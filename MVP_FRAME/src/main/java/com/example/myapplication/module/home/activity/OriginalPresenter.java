package com.example.myapplication.module.home.activity;

import com.example.myapplication.model.PandaChannelModelImp;
import com.example.myapplication.model.bean.OriginalBean;
import com.example.myapplication.module.home.HomeContract;
import com.example.myapplication.network.MyCallBack;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:  P层
 * 创建人: LENOVO
 * 创建时间: 2017-7-22 10:41
 * 修改人:
 * 修改内容:
 */

public class OriginalPresenter implements OriginalContract.OriginalPresenter{

    private OriginalContract.OriginalView originalView;
    private PandaChannelModelImp modelImp;

    public OriginalPresenter(OriginalContract.OriginalView originalView) {
        this.originalView = originalView;
        this.modelImp = new PandaChannelModelImp();
        originalView.setPresenter(this);
    }


    @Override
    public void start() {
        modelImp.getOriginalData(new MyCallBack<OriginalBean>() {
            @Override
            public void onSuccess(OriginalBean originalBean) {
                originalView.setOriginal(originalBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
