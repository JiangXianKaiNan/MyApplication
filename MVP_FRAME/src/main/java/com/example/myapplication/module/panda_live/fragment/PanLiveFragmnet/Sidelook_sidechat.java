package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.module.panda_live.adapter.SidelookXrecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Created by ASUS on 2017/7/19.
 */

public class Sidelook_sidechat extends BaseFragment {
    @BindView(R.id.sidelook_xrecycler)
    XRecyclerView sidelookXrecycler;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.sidelook_sidechat;
    }

    @Override
    protected void initView(View view) {
        SidelookXrecyclerAdapter adapter = new SidelookXrecyclerAdapter();
        sidelookXrecycler.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setParams(Bundle bundle) {

    }

}
