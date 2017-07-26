package com.example.myapplication.module.roll_video.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.RollRollVideoBean;
import com.example.myapplication.module.roll_video.activity.PanderDetails;


import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class RallVideo_AD extends RecyclerView.Adapter{
    private Context context;
    private List<RollRollVideoBean.ListBean> list;
    private RollRollVideoBean.ListBean listBean;
    private List<RollRollVideoBean.BigImgBean> bigImg;
    private View view;

    public RallVideo_AD(Context context, List<RollRollVideoBean.ListBean> list){
        this.context=context;
        this.list=list;
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        private ImageView mimage;
        private TextView mtitle;
        private TextView mcontent;
        private TextView mtime;
        public MyHolder(View itemView) {
            super(itemView);
            mimage= (ImageView) itemView.findViewById(R.id.mimage);
            mtitle= (TextView) itemView.findViewById(R.id.mtitle);
            mcontent= (TextView) itemView.findViewById(R.id.mcontent);
            mtime= (TextView) itemView.findViewById(R.id.mtime);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewTyp) {
        view = View.inflate(context, R.layout.rall_item,null);


        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1= (MyHolder) holder;
        listBean = list.get(position);
        Glide.with(context).load(listBean.getImage()).into(holder1.mimage);
        holder1.mtitle.setText(listBean.getTitle());
        holder1.mcontent.setText(listBean.getBrief());
        holder1.mtime.setText(listBean.getVideoLength());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, PanderDetails.class);
                intent.putExtra("tit",list.get(position).getTitle());
                intent.putExtra("id", list.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
