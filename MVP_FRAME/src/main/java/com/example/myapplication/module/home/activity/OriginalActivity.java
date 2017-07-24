package com.example.myapplication.module.home.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.model.bean.OriginalBean;
import com.example.myapplication.module.home.adapter.HomeOriginalAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-22 10:13
 * 修改人:
 * 修改内容:
 */

public class OriginalActivity extends BaseActivity implements OriginalContract.OriginalView {
    @BindView(R.id.Original_back)
    ImageView OriginalBack;
    @BindView(R.id.Home_OriginalRecyclerView)
    PullToRefreshRecyclerView HomeOriginalRecyclerView;

    private OriginalContract.OriginalPresenter originalPresenter;
    private HomeOriginalAdapter adapter;
    private List<OriginalBean.InteractiveBean> interactive;


    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_original;
    }

    @Override
    protected void initView() {
        originalPresenter = new OriginalPresenter(this);
        originalPresenter.start();

    }

    @Override
    protected void initListener() {



    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.Original_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void setOriginal(OriginalBean original) {
        interactive = original.getInteractive();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        HomeOriginalRecyclerView.setLayoutManager(llm);

        HomeOriginalRecyclerView.setPullRefreshEnabled(true);
        HomeOriginalRecyclerView.displayLastRefreshTime(true);
        HomeOriginalRecyclerView.setLoadingMoreEnabled(false);
        HomeOriginalRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                HomeOriginalRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initView();
                        HomeOriginalRecyclerView.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                HomeOriginalRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HomeOriginalRecyclerView.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
        adapter = new HomeOriginalAdapter(OriginalActivity.this,interactive);
//        Log.e("OriginalActivity", "interactive:" + interactive);
        HomeOriginalRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(OriginalContract.OriginalPresenter originalPresenter) {
        this.originalPresenter = originalPresenter;
    }
}
