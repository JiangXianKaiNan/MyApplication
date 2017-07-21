package com.example.myapplication.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.PandaBroadTwoBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Horder> implements View.OnClickListener {
    private OnItem onItem;
    public void setOnItem(OnItem onItem) {
        this.onItem = onItem;
    }
    private final ArrayList<PandaBroadTwoBean.ListBean> list;
    Context context;

    public MyAdapter(Context context, ArrayList<PandaBroadTwoBean.ListBean> liveBeen) {
         this.context=context;
        this.list=liveBeen;


    }

    @Override
    public MyAdapter.Horder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.panda_broadtwo, parent, false);
         inflate.setOnClickListener(this) ;
          Horder horder=new Horder(inflate);
        return horder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.Horder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPicurl()).into(holder.imageView);
            holder.shijian.setText(list.get(position).getFocus_date()+"");
        holder.itemView.setTag(position);
    }




    @Override
    public int getItemCount() {
        return list.size();


    }

    public class Horder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;
        private final TextView shijian;

        public Horder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.images);
            shijian = (TextView) itemView.findViewById(R.id.shijian);
        }
    }
    public interface OnItem {
        public void onItemClick(int integer);
    }
    @Override
    public void onClick(View v) {
        if(onItem!=null){
            Integer inte= (Integer) v.getTag();

            onItem.onItemClick(inte);


        }
    }

}
