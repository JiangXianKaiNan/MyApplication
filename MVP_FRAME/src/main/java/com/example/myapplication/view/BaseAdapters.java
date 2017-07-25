package com.example.myapplication.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/6/26.
 */

/**
 * Created by Kun on 2016/12/14.
 * GitHub: https://github.com/AndroidKun
 * CSDN: http://blog.csdn.net/a1533588867
 * Description: 通用Adapter基类
 * recyclerview的Adapter 通用
 */

public abstract class BaseAdapters<T> extends RecyclerView.Adapter<BaseAdapters.ViewHolder> {

    protected Context context;
    protected  int layoutId;
    protected List<T> datas;
    protected LayoutInflater inflater;

    protected final static int GET = 1;
    protected final static int POST = 2;
    /**
     * 设置是否显示EmptyView
     */
    protected boolean showEmptyView = false;
    /**
     * 标识是否显示EmptyView
     */
    protected boolean isShowEmptyView = false;
    /**
     * 全部加载完毕是否显示底部View
     */
    protected boolean isShowEndView = false;
    /**
     * 是否添加了显示底部View的数据
     */
    protected boolean isAddShowEndViewData = false;

    public BaseAdapters(Context context, int layoutId, List<T> datas) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.datas = datas;
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.get(context,parent,layoutId);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        convert(holder,datas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public List<T> getDatas(){
        return datas;
    }

    public void setDatas(List<T> datas){
        this.datas = datas;
        if(this.datas == null){
            this.datas = new ArrayList<>();
            isShowEmptyView = true;
        }else{
            isShowEmptyView = false;
        }
        notifyDataSetChanged();
    }

    public void insertDataAtTop(T newData){
        if(datas!=null){
            datas.add(0,newData);
        }else{
            datas =  new ArrayList<>();
            datas.add(newData);
        }
        notifyDataSetChanged();
    }

    public void addDatas(List<T> newDatas){
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
        int last = datas.size();
        this.datas.addAll(newDatas);
        notifyItemInserted(last + 1);
    }
    public void addData(T newData){
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
        this.datas.add(newData);
        notifyDataSetChanged();
    }
    public void addData(T newData,int index){
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
        this.datas.add(index,newData);
        notifyDataSetChanged();
    }

    public void setShowEmptyView(boolean showEmptyView) {
        this.showEmptyView = showEmptyView;
    }

    public void setIsShowEmptyView(boolean show) {
        if(!showEmptyView) return;
        isShowEmptyView = show;
        if(isShowEmptyView){
            this.datas.clear();
            insertDataAtTop((T) new Object());
        }

    }

    public boolean isShowEndView() {
        return isShowEndView;
    }

    public void setShowEndView(boolean showEndView) {
        isShowEndView = showEndView;
    }

    public void addEndViewData(){
        if(isAddShowEndViewData || !isShowEndView) return;
        isAddShowEndViewData = true;
        if(datas==null){
            datas = new ArrayList<>();
        }
        datas.add((T) new Object());
    }

    public void removeEndViewData(){
        if(!isAddShowEndViewData || !isShowEndView) return;
        isAddShowEndViewData = false;
        if(datas!=null && datas.size()>0){
            datas.remove(datas.size()-1);
        }
    }


    public void removeItem(int position){
        if(datas != null && datas.size() > position){
            datas.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clearDatas(){
        this.datas.clear();
        notifyDataSetChanged();
    }



    /**
     * Created by Kun on 2016/12/14.
     * GitHub: https://github.com/AndroidKun
     * CSDN: http://blog.csdn.net/a1533588867
     * Description:通用ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private SparseArray<View> views;
        private View convertView;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            convertView = itemView;
            views = new SparseArray<>();
        }

        public static ViewHolder get(Context context, ViewGroup viewGroup, int layoutId) {
            View itemView = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
            return new ViewHolder(context, itemView);
        }

        public <T extends View> T getView(int viewId) {
            View view = views.get(viewId);
            if (view == null) {
                view = convertView.findViewById(viewId);
                views.put(viewId, view);
            }
            return (T) view;
        }

        public ViewHolder setText(int viewId, String text) {
            TextView tv = getView(viewId);
            tv.setText(text);
            return this;
        }

        public String getText(int viewId) {
            TextView tv = getView(viewId);
            return tv.getText().toString();
        }

        public ViewHolder setTextColor(int viewId, int color) {
            TextView tv = getView(viewId);
            tv.setTextColor(color);
            return this;
        }

        public ViewHolder setImageResource(int viewId, int resId) {
            ImageView view = getView(viewId);
            view.setImageResource(resId);
            return this;
        }




        public ViewHolder setViewVisiable(int viewId, int visibility) {
            getView(viewId).setVisibility(visibility);
            return this;
        }

        public ViewHolder setViewBackgroundResource(int viewId, int resId) {
            getView(viewId).setBackgroundResource(resId);
            return this;
        }

        public ViewHolder setOnclickListener(int viewId, View.OnClickListener listener) {
            View view = getView(viewId);
            view.setOnClickListener(listener);
            return this;
        }
    }


}

