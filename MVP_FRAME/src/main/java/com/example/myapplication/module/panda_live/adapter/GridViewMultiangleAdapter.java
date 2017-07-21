package com.example.myapplication.module.panda_live.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.MultiBean;

import java.util.List;

/**
 * Created by ASUS on 2017/7/20.
 */

public class GridViewMultiangleAdapter extends BaseAdapter {
    private Context context;
    private List<MultiBean.ListBean> liveBeen;
    public GridViewMultiangleAdapter(Context context, List<MultiBean.ListBean> liveBeen) {
        this.context = context;
        this.liveBeen = liveBeen;
    }

    @Override
    public int getCount() {
        return liveBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return liveBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    ViewHorlder viewHorlder;
    if (convertView==null){
        viewHorlder = new ViewHorlder();
        convertView = View.inflate(context, R.layout.pandalive_itme,null);
        viewHorlder.imageView = (ImageView) convertView.findViewById(R.id.item_img);
        viewHorlder.textView = (TextView) convertView.findViewById(R.id.item_text);
        convertView.setTag(viewHorlder);
    }else {
        viewHorlder = (ViewHorlder) convertView.getTag();
    }
    Glide.with(context).load(liveBeen.get(position).getImage()).into( viewHorlder.imageView);
    viewHorlder.textView.setText(liveBeen.get(position).getTitle());

    return convertView;
               }
    class ViewHorlder{
        ImageView imageView;
        TextView textView;

    }
}
