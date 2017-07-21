package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.module.panda_live.PandaFragmentPresenter;
import com.example.myapplication.module.panda_live.PandaLiveContract;
import com.example.myapplication.module.panda_live.adapter.GridViewMultiangleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class Live_multiangle extends BaseFragment implements PandaLiveContract.PandaLiveView {

//    @BindView(R.id.multiangle_grid)
    GridView multiangleGrid;
    private GridViewMultiangleAdapter adapter;
    private List<MultiBean.ListBean> liveBeen;
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;

    @Override
    public int getFragmentLayoutId() {
        Log.e("TAG","getFragmentLayoutId");
        return R.layout.live_multiangle;
    }

    @Override
    protected void initView(View view) {
        Log.e("TAG","initView");
        multiangleGrid = (GridView) view.findViewById(R.id.multiangle_grid);
    }

    @Override
    protected void initData() {
        Log.e("TAG","initData");
        mPandaLivPresenter = new PandaFragmentPresenter(this);
        mPandaLivPresenter.start();

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
        Log.e("TAG","setResultData");
        liveBeen = new ArrayList<>();
        liveBeen.addAll(multiBean.getList());
        adapter = new GridViewMultiangleAdapter(getActivity(),liveBeen);
        multiangleGrid.setAdapter(adapter);
    }

    @Override
    public void setPandatablelist(TableListBaen listBaen) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","onDestroy");
        super.onDestroy();
    }
}