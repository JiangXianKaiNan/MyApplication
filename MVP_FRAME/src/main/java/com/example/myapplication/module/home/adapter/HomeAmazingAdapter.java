package com.example.myapplication.module.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-20 20:49
 * 修改人:
 * 修改内容:
 */

public class HomeAmazingAdapter extends BaseAdapter {

    private List<HomeCCTVBean.ListBean> mlist;
    private LayoutInflater inflater;
    private Context context;

    public HomeAmazingAdapter(List<HomeCCTVBean.ListBean> list,  Context context) {
        this.mlist = list;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodel vie = null;
        if (convertView ==null){
            vie = new ViewHodel();
            convertView = inflater.inflate(R.layout.home_item_amazing_item, null);
            vie.mImag = (ImageView) convertView.findViewById(R.id.Home_item_Amazing_image);
            vie.mTvTime = (TextView) convertView.findViewById(R.id.Home_item_Amazing_timeLength);
            vie.mTvTitle = (TextView) convertView.findViewById(R.id.Home_item_Amazing_Title);
            vie.mTvTimeBody = (TextView) convertView.findViewById(R.id.Home_item_Amazing_bodytime);
            convertView.setTag(vie);
        }else {
            vie = (ViewHodel) convertView.getTag();
        }
        HomeCCTVBean.ListBean listBean = mlist.get(position);
        vie.mTvTitle.setText(listBean.getTitle());
        vie.mTvTime.setText(listBean.getVideoLength());
        vie.mTvTimeBody.setText(listBean.getDaytime());
        Picasso.with(context).load(listBean.getImage()).into(vie.mImag);

        return convertView;
    }

    class ViewHodel{
        private ImageView mImag;
        private TextView mTvTime,mTvTitle,mTvTimeBody;
    }

}
