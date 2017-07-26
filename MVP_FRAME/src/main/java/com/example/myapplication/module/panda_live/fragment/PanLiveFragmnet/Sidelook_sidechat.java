package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.SidelookBean;
import com.example.myapplication.module.panda_live.adapter.SidelookXrecyclerAdapter;
import com.example.myapplication.view.MyStaggeredGridLayoutManager;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ASUS on 2017/7/19.
 */

public class Sidelook_sidechat extends BaseFragment implements SidelooksidechatContract.SidelooksidechatView{
    @BindView(R.id.sidelook_xrecycler)
    XRecyclerView sidelookXrecycler;
    private SidelooksidechatContract.SidelooksidePresenter sidelooksidePresenter;
    private List<SidelookBean.DataBean.ContentBean> dataBeanList = new ArrayList<>();
    private SidelookXrecyclerAdapter adapter;
    int P;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.sidelook_sidechat;
    }

    @Override
    protected void initView(View view) {
        sidelookXrecycler.setLayoutManager(new MyStaggeredGridLayoutManager(1,MyStaggeredGridLayoutManager.VERTICAL));
        adapter =  new SidelookXrecyclerAdapter(getActivity(),dataBeanList);
        sidelookXrecycler.setAdapter(adapter);
        sidelookXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                sidelookXrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                sidelookXrecycler.loadMoreComplete();
                P++;
                initData();
                sidelookXrecycler.refreshComplete();
            }
        });
    }

    @Override
    protected void initData() {
        sidelooksidePresenter = new SidelooksidechatPresenter(this,P);
        sidelooksidePresenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setPresenter(SidelooksidechatPresenter sidelooksidechatPresenter) {
    }

    @Override
    public void setSidelookData(SidelookBean sidelookBean) {
        if(sidelookBean.getData()!=null){

            dataBeanList.addAll(sidelookBean.getData().getContent());
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(getActivity(), "别刷了哥,没数据了", Toast.LENGTH_SHORT).show();
        }
    }
}
