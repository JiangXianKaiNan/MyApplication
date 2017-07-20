package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.module.panda_live.PandaLiveContract;

import butterknife.BindView;

/**
 * Created by ASUS on 2017/7/19.
 */

public class Live_multiangle extends BaseFragment implements PandaLiveContract.PandaLiveView {

    @BindView(R.id.multiangle_grid)
    GridView multiangleGrid;


    @Override
    public int getFragmentLayoutId() {
        return R.layout.live_multiangle;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void setResultData(MultiBean multiBean) {

    }

}
