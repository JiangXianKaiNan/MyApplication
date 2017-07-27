package com.example.myapplication.module.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.global.MyApp;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.example.myapplication.model.bean.HomeDataBean;
import com.example.myapplication.module.home.adapter.HomeAdapter;
import com.example.myapplication.module.home.adapter.HomeAmazingAdapter;
import com.example.myapplication.utils.GlideImage;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.R.id.list;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {
    @BindView(R.id.Home_XRecyclerView)
    XRecyclerView HomeXRecyclerView;

    private HomeContract.HomePresenter mHomePresenter;
    private List<Object> objList;
    private HomeAdapter homeAdapter;
    private List<HomeCCTVBean.ListBean> list;
    private Banner banner;
    private List<String> imageList;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.home_fragment;
    }


    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {
        mHomePresenter = presenter;

    }

    /**
     * 首页其他的
     *
     * @param bean
     */
    @Override
    public void setResultData(HomeDataBean bean) {
//        Log.e("HomeFragment请求数据===", "bean:" + bean.getData().getPandaeye().getTitle());
        imageList = new ArrayList<>();
        objList = new ArrayList<>();
        HomeDataBean.DataBean data = bean.getData();
        objList.add(data.getPandaeye());
        objList.add(data.getPandalive());
        objList.add(data.getCctv());
        objList.add(data.getList());
        objList.add(data.getChinalive());
        homeAdapter = new HomeAdapter(objList, MyApp.mContext);
        HomeXRecyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

        mHomePresenter.setAmazingData(data.getList().get(0).getListUrl());

        List<HomeDataBean.DataBean.BigImgBean> bigImg = bean.getData().getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            String image = bigImg.get(i).getImage();
            imageList.add(image);
        }
        Log.e("HomeFragment", "轮播图:" + imageList);
        banner.setImages(imageList)
                .setDelayTime(3000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImage())
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }

    @Override
    public void setXX(HomeCCTVBean bean) {
        list = bean.getList();
//        HomeAmazingAdapter adapter = new HomeAmazingAdapter(list, MyApp.mContext);
    }


    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //设置横向
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeXRecyclerView.setLayoutManager(linearLayoutManager);
        HomeXRecyclerView.setLoadingMoreEnabled(false);
        HomeXRecyclerView.setPullRefreshEnabled(true);
        HomeXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                HomeXRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HomeXRecyclerView.loadMoreComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

            }
        });

        View inflate = LayoutInflater.from(MyApp.mContext).inflate(R.layout.home_item_banner, null);
        banner = (Banner) inflate.findViewById(R.id.frag_marker_banner);
        HomeXRecyclerView.addHeaderView(inflate);

        mHomePresenter = new HomePresenter(this);
        //通过P层处理相关业务逻辑
        mHomePresenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {

    }


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
}
