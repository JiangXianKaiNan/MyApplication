package com.example.myapplication.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.myapplication.model.bean.HomeDataBean;

import java.util.List;


/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-20 11:31
 * 修改人:
 * 修改内容:
 */

public class HomeAdapter extends RecyclerView.Adapter {

    private List<Object> objectlist;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE1 = 1, TYPE2 = 2, TYPE3 = 3, TYPE4 = 4, TYPE5 = 5;

    public HomeAdapter(List<Object> objectlist, Context context) {
        this.objectlist = objectlist;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //判断type
    @Override
    public int getItemViewType(int position) {
        Object obj = objectlist.get(position);
        if (obj instanceof HomeDataBean.DataBean.PandaeyeBean){
            return TYPE1;
        }else if (obj instanceof HomeDataBean.DataBean.PandaliveBean){
            return TYPE2;
        }else if (obj instanceof HomeDataBean.DataBean.AreaBean){
            return TYPE3;
        }else if (obj instanceof  HomeDataBean.DataBean.WallliveBean){
            return TYPE4;
        }else if (obj instanceof  HomeDataBean.DataBean.ChinaliveBean){
            return TYPE5;
        }

        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
