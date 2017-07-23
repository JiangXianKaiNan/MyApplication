package com.example.myapplication.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.OriginalBean;
import com.example.myapplication.module.home.activity.HomeOriginalDetaliActivity;

import java.util.List;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-22 11:01
 * 修改人:
 * 修改内容:
 */

public class HomeOriginalAdapter extends BaseAdapter<OriginalBean.InteractiveBean> {

    public HomeOriginalAdapter(Context context,  List<OriginalBean.InteractiveBean> datas) {
        super(context, R.layout.activity_original_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final OriginalBean.InteractiveBean interactiveBean) {
        holder.setText(R.id.Original_title,interactiveBean.getTitle());
//        Log.e("HomeOriginalAdapter", interactiveBean.getTitle());
        ImageView view = holder.getView(R.id.Original_image);
        Glide.with(context).load(interactiveBean.getImage()).into(view);
        holder.setOnclickListener(R.id.Activity_original, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "详情", Toast.LENGTH_SHORT).show();
                String url = interactiveBean.getUrl();
                Intent intent = new Intent(context, HomeOriginalDetaliActivity.class);
                intent.putExtra("Url",url);
                context.startActivity(intent);

            }
        });
    }
}
