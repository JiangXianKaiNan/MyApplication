package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.PandaBroadBean;
import com.example.myapplication.model.bean.PandaBroadTwoBean;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/7/21.
 */

class PandaFragment extends BaseFragment {
    private ArrayList<PandaBroadTwoBean.ListBean> liveBeen;
    private ImageView image;
    int page=2;
    private XRecyclerView xrecyclerView;
    private MyAdapter myAdapter;
    private TextView text;

    public void initdata() {
        new Thread() {
            @Override
            public void run() {
                String path ="http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda&pageSize=20&page="+page;
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(path).build();
                Callback callback = new Callback() {


                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Gson gson = new Gson();
                        PandaBroadTwoBean pandaBroadTwoBean = gson.fromJson(string, PandaBroadTwoBean.class);
                        List<PandaBroadTwoBean.ListBean> live = pandaBroadTwoBean.getList();
                        liveBeen = new ArrayList<PandaBroadTwoBean.ListBean>();
                        liveBeen.addAll(live);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myAdapter = new MyAdapter(getActivity(), liveBeen);
                                xrecyclerView.setAdapter(myAdapter);
                                myAdapter.setOnItem(new MyAdapter.OnItem() {
                                    @Override
                                    public void onItemClick(int integer) {
                                        Intent intent = new Intent(getActivity(), Pandaparticulars.class);
                                        intent.putExtra("id", liveBeen.get(integer).getId());
                                        intent.putExtra("title", liveBeen.get(integer).getTitle());
                                        intent.putExtra("url", liveBeen.get(integer).getUrl());
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                };
                okHttpClient.newCall(request).enqueue(callback);
            }
        }.start();
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.activity_panda;
    }

    @Override
    protected void initView(View view) {
        final View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pandaimages, null);
        image = (ImageView) inflate.findViewById(R.id.imag);
        text = (TextView) inflate.findViewById(R.id.titletext);
        initData();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PandaVideo.class);
                startActivity(intent);
            }
        });
        xrecyclerView = (XRecyclerView) view.findViewById(R.id.xrecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        xrecyclerView.setLayoutManager(manager);
        xrecyclerView.addHeaderView(inflate);
        initdata();

        xrecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page=1;
                        initdata();
                        myAdapter.notifyDataSetChanged();
                        xrecyclerView.refreshComplete();
                    }


                }, 2000);
            }
            @Override
            public void onLoadMore() {
                xrecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page  ++;
                        initdata();
                        myAdapter.notifyDataSetChanged();
                        xrecyclerView.loadMoreComplete();
                    }


                }, 2000);

            }
        });
    }


    @Override
    protected void initData() {
           new Thread(){
               @Override
               public void run() {
                   String path="http://www.ipanda.com/kehuduan/news/index.json";
                   OkHttpClient okHttpClient = new OkHttpClient();
                   Request request=new Request.Builder().url(path).build();
                   Callback callback=new Callback() {
                       @Override
                       public void onFailure(Call call, IOException e) {

                       }

                       @Override
                       public void onResponse(Call call, Response response) throws IOException {
                           String string = response.body().string();
                           Gson gson = new Gson();
                           final PandaBroadBean pandaBroadBean = gson.fromJson(string, PandaBroadBean.class);
                           getActivity().runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   for (int i = 0; i < pandaBroadBean.getData().getBigImg().size(); i++) {
                                       Glide.with(PandaFragment.this).load(pandaBroadBean.getData().getBigImg().get(i).getImage()).into(image);
                                       text.setText(pandaBroadBean.getData().getBigImg().get(i).getTitle());
                                   }

                               }
                           });
                       }
                   };
                   okHttpClient.newCall(request).enqueue(callback);
               }
           }.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }
}


