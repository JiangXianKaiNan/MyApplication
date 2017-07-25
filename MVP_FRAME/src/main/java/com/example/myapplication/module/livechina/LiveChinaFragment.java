package com.example.myapplication.module.livechina;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.LiveChinaContentBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.LiveChinaView {

    Unbinder unbinder;
    @BindView(R.id.livechina_Xrv)
    XRecyclerView livechinaXrv;
    LiveChinaAdapter adapter;
    private String url;

    public LiveChinaFragment(String url) {
        this.url = url;
    }

    private LiveChinaContract.LiveChinaPresenter mliveChinaPresenter;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.livechina_fragment_home;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        mliveChinaPresenter = new LiveChinaPresenter(url,this);
        mliveChinaPresenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setPresenter(LiveChinaContract.LiveChinaPresenter liveChinaPresenter) {
        mliveChinaPresenter = liveChinaPresenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }


    @Override
    public void setResultData(LiveChinaContentBean liveChinaContentBean) {
        final List<LiveChinaContentBean.LiveBean> been = new ArrayList<>();
        been.addAll(liveChinaContentBean.getLive());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        livechinaXrv.setLayoutManager(layoutManager);
        livechinaXrv.setLoadingMoreEnabled(false);
        livechinaXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //refresh data here刷新
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        been.clear();
                        mliveChinaPresenter.start();
                        adapter.notifyDataSetChanged();
                        livechinaXrv.refreshComplete();
                    }

                }, 2500);
            }

            @Override
            public void onLoadMore() {
                // load more data here加载
                livechinaXrv.loadMoreComplete();
            }
        });
        adapter = new LiveChinaAdapter(getContext(), R.layout.livechina_item,been);
        livechinaXrv.setAdapter(adapter);

    }

    @OnClick(R.id.livechina_Xrv)
    public void onViewClicked() {
    }
}
