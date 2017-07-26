package com.example.myapplication.module.home;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.global.MyApp;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.example.myapplication.model.bean.HomeDataBean;
import com.example.myapplication.module.home.adapter.HomeAdapter;
import com.example.myapplication.utils.GlideImage;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {
    @BindView(R.id.Home_XRecyclerView)
    XRecyclerView HomeXRecyclerView;
    @BindView(R.id.Home_progtessBer)
    ProgressBar HomeProgtessBer;


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
//        Log.e("请求到的数据", "bean:" + bean);
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

//        mHomePresenter.setAmazingData(data.getList().get(0).getListUrl());

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
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //设置横向
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomeXRecyclerView.setLayoutManager(linearLayoutManager);
        HomeXRecyclerView.setLoadingMoreEnabled(true);
        HomeXRecyclerView.setPullRefreshEnabled(true);
        HomeXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                final ProgressDialog dialog = new ProgressDialog(getActivity());
                /** 窗口背景变暗*/
                dimBackground(1.0f, 0.5f);
                HomeProgtessBer.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dimBackground(0.5f, 1.0f);
//                        HomeXRecyclerView.loadMoreComplete();
                        HomeProgtessBer.setVisibility(View.GONE);
                        HomeXRecyclerView.refreshComplete();
                        HomeXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
                        dialog.dismiss();

                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                HomeXRecyclerView.setNoMore(true);
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

    /**
     * 调整窗口的透明度
     *
     * @param from>=0&&from<=1.0f
     * @param to>=0&&to<=1.0f
     */
    private void dimBackground(final float from, final float to) {
        final Window window = getActivity().getWindow();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.alpha = (Float) animation.getAnimatedValue();
                window.setAttributes(params);
            }
        });

        valueAnimator.start();
    }


}
