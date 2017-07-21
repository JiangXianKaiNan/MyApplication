package com.example.myapplication.module.panda_live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.PandaFragmentlistData;

import java.util.List;

/**
 * Created by ASUS on 2017/7/21.
 */

public class XRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<PandaFragmentlistData.VideoBean> videosetBeen;
    public XRecyclerViewAdapter(Context context, List<PandaFragmentlistData.VideoBean> videosetBeen) {
        this.context = context;
        this.videosetBeen = videosetBeen;
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        private TextView Home_item_Rolling_body,Home_item_Rolling_bodytime,Home_item_Rolling_time;
        private ImageView home_item_Rolling_image;
        public MyHolder(View itemView) {
            super(itemView);
            home_item_Rolling_image = (ImageView) itemView.findViewById(R.id.home_item_Rolling_image);
            Home_item_Rolling_bodytime= (TextView) itemView.findViewById(R.id.Home_item_Rolling_bodytime);
            Home_item_Rolling_body= (TextView) itemView.findViewById(R.id.Home_item_Rolling_body);
            Home_item_Rolling_time= (TextView) itemView.findViewById(R.id.Home_item_Rolling_time);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.pandalive_recycler_itme,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder holders= (MyHolder) holder;
        holders.Home_item_Rolling_body.setText(videosetBeen.get(position).getT());
        holders.Home_item_Rolling_bodytime.setText(videosetBeen.get(position).getPtime());
        holders.Home_item_Rolling_time.setText(videosetBeen.get(position).getLen());
        Glide.with(context).load(videosetBeen.get(position).getImg()).into(holders.home_item_Rolling_image);

    }

    @Override
    public int getItemCount() {
        return videosetBeen.size();
    }
}
