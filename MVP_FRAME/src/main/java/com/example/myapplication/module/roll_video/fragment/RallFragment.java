package com.example.myapplication.module.roll_video.fragment;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.RollRollVideoBean;
import com.example.myapplication.module.roll_video.activity.PanderDetails;
import com.example.myapplication.module.roll_video.activity.PanderVideo;
import com.example.myapplication.module.roll_video.adapter.MoveXqAd;
import com.example.myapplication.module.roll_video.adapter.RallVideo_AD;
import com.example.myapplication.module.roll_video.base.RollContract;
import com.example.myapplication.module.roll_video.base.RollPresenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ASUS on 2017/7/19.
 */

public class RallFragment extends BaseFragment implements RollContract.RollView {
    @BindView(R.id.xrecycler_view)
    XRecyclerView xrecyclerView;
    @BindView(R.id.progtessBer_btn_id2)
    ProgressBar progtessBerBtnId2;
    Unbinder unbinder;
    private RallVideo_AD myRecycler;
    private RollContract.Presenter mRollPresenter;
    private List<RollRollVideoBean.BigImgBean> bigImg;
    private List<RollRollVideoBean.ListBean> listbean;

    @Override
    public int getFragmentLayoutId() {
        return R.layout.rall_fragment;
    }

    @Override
    protected void initView(View view) {
    }

    @Override
    protected void initData() {
        mRollPresenter = new RollPresenter(this);
        xrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRollPresenter.start();
        //xrecyclerView刷新方法
        shuxin();
    }

    //xrecyclerView刷新方法
    private void shuxin() {
        xrecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                final ProgressDialog dialog = new ProgressDialog(getActivity());
                /** 窗口背景变暗*/
                dimBackground(1.0f, 0.5f);
                progtessBerBtnId2.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /** 窗口背景变亮*/
                        dimBackground(0.5f, 1.0f);
                        progtessBerBtnId2.setVisibility(View.GONE);
                        xrecyclerView.refreshComplete();
                        xrecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
                        dialog.dismiss();
                    }
                }, 1500);
            }

            @Override
            public void onLoadMore() {
                xrecyclerView.setNoMore(true);
            }
        });
    }

    @Override
    public void setParams(Bundle bundle) {
    }

    @Override
    public void setRollData(RollRollVideoBean dataBean) {
        bigImg = dataBean.getBigImg();
        listbean = dataBean.getList();
        Log.e("TAG", bigImg.get(0).getImage().toString());
        myRecycler = new RallVideo_AD(getActivity(), dataBean.getList());
        xrecyclerView.setAdapter(myRecycler);
        myRecycler.notifyDataSetChanged();
        /*
        * 加载XRecyclerView头部布局
        * 并找到该文字图片ID
        * Glide、Text并加载
        * */
        View view = View.inflate(getActivity(), R.layout.rallvideo_head, null);
        ImageView headimg = (ImageView) view.findViewById(R.id.rallvideo_headimg);
        TextView biaot = (TextView) view.findViewById(R.id.biao_ti);
        Glide.with(getActivity()).load(bigImg.get(0).getImage().toString())
                .into(headimg);
        Log.e("TAGGG", bigImg.get(0).getImage().toString());
        biaot.setText(bigImg.get(0).getTitle());
        xrecyclerView.addHeaderView(view);
        //图片点击事件
        headimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PanderVideo.class);
                //标题传出去
                intent.putExtra("title", bigImg.get(0).getTitle());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void setPresenter(RollContract.Presenter rollPresenter) {
        mRollPresenter = rollPresenter;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
