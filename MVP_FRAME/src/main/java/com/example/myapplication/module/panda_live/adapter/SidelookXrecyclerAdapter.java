package com.example.myapplication.module.panda_live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.SidelookBean;

import java.util.List;

/**
 * Created by ASUS on 2017/7/21.
 */

public class SidelookXrecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SidelookBean.DataBean.ContentBean> dataBeanList;
    public SidelookXrecyclerAdapter(Context context, List<SidelookBean.DataBean.ContentBean> dataBeanList) {
        this.context =context;
        this.dataBeanList = dataBeanList;
    }
    static class MyHolder extends RecyclerView.ViewHolder{
        private TextView sidelook_titler,sidelook_lou;
        public MyHolder(View itemView) {
            super(itemView);
            sidelook_titler= (TextView) itemView.findViewById(R.id.sidelook_titler);
            sidelook_lou= (TextView) itemView.findViewById(R.id.sidelook_lou);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.sidelook_itme,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder holders= (MyHolder) holder;
        holders.sidelook_titler.setText(dataBeanList.get(position).getMessage());
        holders.sidelook_lou.setText("176541楼");
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }
}
