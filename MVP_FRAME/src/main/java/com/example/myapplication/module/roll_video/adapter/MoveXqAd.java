package com.example.myapplication.module.roll_video.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.module.roll_video.base.MoveTwoBean;
import com.example.myapplication.module.roll_video.base.Move_bean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by ASUS on 2017/7/21.
 */

public class MoveXqAd extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private List<Move_bean.VideoBean> list;
    private int i;
    private OnItem onItem;
    public MoveXqAd(Context context, List<Move_bean.VideoBean> list){
        this.context=context;
        this.list=list;
    }
    public void setOnItem(OnItem onItem) {
        this.onItem = onItem;
    }

    @Override
    public void onClick(View view) {
        if(onItem!=null){
            Integer inte= (Integer)view.getTag();

            onItem.onItemClick(inte);

        }

    }

    public interface OnItem {
        public void onItemClick(int integer);
    }


    static class MyHolder extends RecyclerView.ViewHolder{
        private ImageView mimage;
        private TextView mcontent;
        private TextView mtime;
        public MyHolder(View itemView) {
            super(itemView);
            mimage= (ImageView) itemView.findViewById(R.id.mimage);
            mcontent= (TextView) itemView.findViewById(R.id.mcontent);
            mtime= (TextView) itemView.findViewById(R.id.mtime);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.rallxq_item,null);
        view.setOnClickListener(this);
        return new MoveXqAd.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        i=position;
        MoveXqAd.MyHolder holder1= (MoveXqAd.MyHolder) holder;
        Move_bean.VideoBean videoBean = list.get(position);
        Glide.with(context).load(videoBean.getImg()).into(holder1.mimage);
        holder1.mcontent.setText(videoBean.getT());
        holder1.mtime.setText(videoBean.getLen());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
