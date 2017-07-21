package com.example.myapplication.module.panda_live.fragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.PandaFragmentlistData;
import com.example.myapplication.module.panda_live.PandaDataListPresenter;
import com.example.myapplication.module.panda_live.PandaFragmentDataContract;
import com.example.myapplication.module.panda_live.adapter.XRecyclerViewAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ASUS on 2017/7/19.
 */

public class PandaLiveFragment_wonderful extends BaseFragment implements PandaFragmentDataContract.PandaLiveView {

    @BindView(R.id.pandalive_wonderful_listview)
    XRecyclerView pandaliveWonderfulListview;
    private PandaFragmentDataContract.PandaLivePresenter mPandaLivPresenter;
    private XRecyclerViewAdapter adapter;
    private List<PandaFragmentlistData.VideoBean> videosetBeen = new ArrayList<>();;
    int P = 1;
    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String id = bundle.getString("id", "");
        mPandaLivPresenter = new PandaDataListPresenter(this,id,P);
        mPandaLivPresenter.start();

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {
        adapter = new XRecyclerViewAdapter(getActivity(), videosetBeen);
        pandaliveWonderfulListview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        pandaliveWonderfulListview.setAdapter(adapter);
        pandaliveWonderfulListview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pandaliveWonderfulListview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pandaliveWonderfulListview.loadMoreComplete();
                P++;
                initData();
                pandaliveWonderfulListview.refreshComplete();
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.pandalive_wonderful;
    }

    @Override
    public void setPresenter(PandaDataListPresenter pandaDataListPresenter) {

    }



    @Override
    public void setPandaFragmentlistData(PandaFragmentlistData pandaFragmentlistData) {
        if(pandaFragmentlistData.getVideo()!=null){
            videosetBeen.addAll(pandaFragmentlistData.getVideo());
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(getActivity(), "别刷了哥,没数据了", Toast.LENGTH_SHORT).show();
        }

    }
}
