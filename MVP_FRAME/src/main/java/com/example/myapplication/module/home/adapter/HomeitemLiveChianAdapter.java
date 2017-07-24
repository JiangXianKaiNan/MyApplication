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
import com.example.myapplication.model.bean.HomeDataBean;

import java.util.List;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-20 17:26
 * 修改人:
 * 修改内容:
 */

public class HomeitemLiveChianAdapter extends BaseAdapter {
    private List<HomeDataBean.DataBean.ChinaliveBean.ListBeanX>mlist;
    private LayoutInflater inflater;
    private Context context;

    public HomeitemLiveChianAdapter(List<HomeDataBean.DataBean.ChinaliveBean.ListBeanX> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
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
        if (convertView == null){
            vie = new ViewHodel();
            convertView = inflater.inflate(R.layout.home_item_live_item,null);
            vie.mIvimage = (ImageView) convertView.findViewById(R.id.Home_item_liveshow_Image);
            vie.mTvbody = (TextView) convertView.findViewById(R.id.Home_item_liveshow_body);
            convertView.setTag(vie);
        }else {
            vie = (ViewHodel) convertView.getTag();
        }
        HomeDataBean.DataBean.ChinaliveBean.ListBeanX listBean = mlist.get(position);
//        Log.e("HomeitemLiveShowAdapter", "listBean:===" + listBean);
        vie.mTvbody.setText(listBean.getTitle());
//        vie.mIvimage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(listBean.getImage()).into(vie.mIvimage);
        return convertView;
    }
    class ViewHodel{
        TextView mTvbody;
        ImageView mIvimage;
    }
}
