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
import com.example.myapplication.model.bean.HomeRollingBean;

import java.util.List;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-21 15:03
 * 修改人:
 * 修改内容:
 */

public class HomeRollingAdapter extends BaseAdapter {
    List<HomeRollingBean.ListBean> listBeen;
    Context context;

    public HomeRollingAdapter(List<HomeRollingBean.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeen.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.home_item_rollingvideo_item,null);
            vie.mImage = (ImageView) convertView.findViewById(R.id.home_item_Rolling_image);
            vie.mBody = (TextView) convertView.findViewById(R.id.Home_item_Rolling_body);
            vie.mBodyTime = (TextView) convertView.findViewById(R.id.Home_item_Rolling_bodytime);
            vie.mTime = (TextView) convertView.findViewById(R.id.Home_item_Rolling_time);
            convertView.setTag(vie);
        }else {
            vie = (ViewHodel) convertView.getTag();
        }
        HomeRollingBean.ListBean listBean = listBeen.get(position);
        vie.mTime.setText(listBean.getVideoLength());
        vie.mBody.setText(listBean.getTitle());
        vie.mBodyTime.setText(listBean.getDaytime());
        Glide.with(context).load(listBean.getImage()).into(vie.mImage);
        return convertView;
    }

    class ViewHodel{
        ImageView mImage;
        TextView mTime,mBody,mBodyTime;
    }

}
