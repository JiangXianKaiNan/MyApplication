package com.example.myapplication.module.home.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.example.myapplication.R;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.activity.PlayVideoActivity;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.constants.Urls;
import com.example.myapplication.global.MyApp;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.example.myapplication.model.bean.HomeDataBean;
import com.example.myapplication.model.bean.HomeDetailBean;
import com.example.myapplication.model.bean.HomeRollingBean;
import com.example.myapplication.model.bean.RollRollVideoBean;
import com.example.myapplication.module.home.activity.HoneLiveVideoActivity;
import com.example.myapplication.module.home.activity.HoneVideoActivity;
import com.example.myapplication.network.HttpUtils;
import com.example.myapplication.network.MyCallBack;
import com.example.myapplication.view.CommonPopupWindow;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.umeng.qq.handler.a.p;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-20 11:31
 * 修改人:
 * 修改内容:
 */

public class HomeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private List<Object> objectlist;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE1 = 0, TYPE2 = 1, TYPE3 = 2, TYPE4 = 3, TYPE5 = 4;


    public HomeAdapter(List<Object> objList, BaseActivity mContext) {
        this.objectlist = objList;
        this.context = mContext;
        inflater = LayoutInflater.from(context);
    }


    //判断type
    @Override
    public int getItemViewType(int position) {
//        Object obj = objectlist.get(position);
        if (position == 0) {
//            Log.e("HomeAdapter", "TYPE1:" + TYPE1);
            return TYPE1;
        }
        if (position == 1) {
//            Log.e("HomeAdapter", "TYPE2:" + TYPE2);
            return TYPE2;
        }
        if (position == 2) {
//            Log.e("HomeAdapter", "TYPE3:" + TYPE3);
            return TYPE3;
        }
        if (position == 3) {
//            Log.e("HomeAdapter", "TYPE4:" + TYPE4);
            return TYPE4;
        }
        if (position == 4) {
//            Log.e("HomeAdapter", "TYPE5:" + TYPE5);
            return TYPE5;
        }
        return 0;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        XRecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE1:// 熊猫播报
                View inflate = inflater.inflate(R.layout.home_item_pandareport, parent, false);
                viewHolder = new PanDareport(inflate);
                break;
            case TYPE2:// 直播秀场
                View inflate1 = inflater.inflate(R.layout.home_item_liveshow, parent, false);
                viewHolder = new liveShow(inflate1);
                break;
            case TYPE3:// 精彩一刻
                View inflate2 = inflater.inflate(R.layout.home_item_amazing, parent, false);
                viewHolder = new Amazing(inflate2);
                break;
            case TYPE4:// 滚滚视频
                View inflate3 = inflater.inflate(R.layout.home_item_rollingvideo, parent, false);
                viewHolder = new RollingVideo(inflate3);
                break;
            case TYPE5:// 直播中国
                View inflate4 = inflater.inflate(R.layout.home_item_livechian, parent, false);
                viewHolder = new LiveChian(inflate4);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final XRecyclerView.ViewHolder holder, int position) {
        Object o = objectlist.get(position);
        int itemViewType = holder.getItemViewType();
        switch (itemViewType) {
            case TYPE1:
                PanDareport panDareport = new PanDareport(holder.itemView);
                panDareport.setReport((HomeDataBean.DataBean.PandaeyeBean) o);
                break;
            case TYPE2:
                liveShow liveShow = new liveShow(holder.itemView);
                liveShow.setLiveShow((HomeDataBean.DataBean.PandaliveBean) o);
                break;
            case TYPE3:
                final Amazing amazing = new Amazing(holder.itemView);
                final HomeDataBean.DataBean.CctvBean cctvBean = (HomeDataBean.DataBean.CctvBean) o;
                HttpUtils.getInstance().get(cctvBean.getListurl(), null, new MyCallBack<HomeCCTVBean>() {
                    @Override
                    public void onSuccess(final HomeCCTVBean listBean) {
                        Log.e("精彩一刻", "listBean:" + cctvBean.getListurl());
                        HomeAmazingAdapter adapter = new HomeAmazingAdapter(listBean.getList(), MyApp.mContext);
                        amazing.mGridView.setAdapter(adapter);
                        amazing.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(context, "精彩一刻", Toast.LENGTH_SHORT).show();
                                String pid = listBean.getList().get(position).getPid();
                                if ("".equals(pid)){
                                    Toast.makeText(context, "没有视频", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                Log.e("精彩一刻pid:", pid);
                                String amazingurl[] = {Urls.JINGCAI1, Urls.JINGCAI2, Urls.JINGCAI3, Urls.JINGCAI4};
                                Intent intent = new Intent(context, HoneVideoActivity.class);
                                intent.putExtra("homeurl", amazingurl[position]);
                                intent.putExtra("homepid", pid);
                                context.startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onFaile(String msg) {

                    }
                });

                break;
            case TYPE4:
                final RollingVideo rollingVideo = new RollingVideo(holder.itemView);
                String url = "http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json";
                HttpUtils.getInstance().get(url, null, new MyCallBack<HomeRollingBean>() {
                    @Override
                    public void onSuccess(final HomeRollingBean homeRollingBean) {
                        if (homeRollingBean.getList().get(0).getPid().length() != 0) {
                            HomeRollingAdapter adapter = new HomeRollingAdapter(homeRollingBean.getList(), context);
                            rollingVideo.mListView.setAdapter(adapter);
                            rollingVideo.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(context, "滚滚视频", Toast.LENGTH_SHORT).show();
                                    String pid = homeRollingBean.getList().get(position).getPid();
                                    Log.e("滚滚视频pid:", pid);
                                    if ("".equals(pid)){
                                        Toast.makeText(context, "没有视频", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                    String rollingurl[] = {Urls.GUNGUN1, Urls.GUNGUN2, Urls.GUNGUN3, Urls.GUNGUN4, Urls.GUNGUN5};
                                    Intent intent = new Intent(context, HoneVideoActivity.class);
                                    intent.putExtra("homeurl", rollingurl[position]);
                                    intent.putExtra("homepid", pid);
                                    context.startActivity(intent);
                                }
                            });
                        } else {
                            Toast.makeText(context, "滚滚视频数据异常", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFaile(String msg) {

                    }
                });

                break;
            case TYPE5:
                LiveChian liveChian = new LiveChian(holder.itemView);
                liveChian.setLiveShow((HomeDataBean.DataBean.ChinaliveBean) o);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return objectlist.size();
    }


    /**
     * 熊猫播报
     */
    class PanDareport extends XRecyclerView.ViewHolder {
        ImageView homeimage;
        TextView mHometvReport;
        TextView mHometvxiari, mHometvxiaribody;
        TextView mHometvsheng, mHometvshengbody;

        public PanDareport(View itemView) {
            super(itemView);
            homeimage = (ImageView) itemView.findViewById(R.id.Home_item_Iv_image);// 图片
            mHometvReport = (TextView) itemView.findViewById(R.id.Home_item_Tv_Report);// 标题
            mHometvxiari = (TextView) itemView.findViewById(R.id.Home_item_Tv_xiari);// 小标题1
            mHometvxiaribody = (TextView) itemView.findViewById(R.id.Home_item_Tv_xiaribody);// 内容1
            mHometvsheng = (TextView) itemView.findViewById(R.id.Home_item_Tv_shengkuai);//小标题2
            mHometvshengbody = (TextView) itemView.findViewById(R.id.Home_item_Tv_shengkuaibody);//内容2
        }

        public void setReport(final HomeDataBean.DataBean.PandaeyeBean pandaeyeBean) {
//            Log.e("熊猫播报:", "pandaeyeBean.getItems():" + pandaeyeBean.getItems());
            Glide.with(context).load(pandaeyeBean.getPandaeyelogo()).into(homeimage);
            mHometvReport.setText(pandaeyeBean.getTitle());
            mHometvxiari.setText(pandaeyeBean.getItems().get(0).getBrief());
            mHometvxiaribody.setText(pandaeyeBean.getItems().get(0).getTitle());
            mHometvsheng.setText(pandaeyeBean.getItems().get(1).getBrief());
            mHometvshengbody.setText(pandaeyeBean.getItems().get(1).getTitle());
            final String pid = pandaeyeBean.getItems().get(0).getPid();
            final String pid2 = pandaeyeBean.getItems().get(1).getPid();
            mHometvxiaribody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("".equals(pid)){
                        Toast.makeText(context, "没有视频", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(context, HoneVideoActivity.class);
                    intent.putExtra("homepid", pid);
                    intent.putExtra("homeurl", Urls.HOMEDETALI);
                    context.startActivity(intent);
                }
            });
            mHometvshengbody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("".equals(pid2)){
                        Toast.makeText(context, "没有视频", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(context, HoneVideoActivity.class);
                    intent.putExtra("homepid", pid2);
                    intent.putExtra("homeurl", Urls.HOMEDETALI);
                    context.startActivity(intent);

                }
            });
        }
    }

    /**
     * 直播秀场
     */
    class liveShow extends XRecyclerView.ViewHolder {
        TextView mHometvlive;
        GridView mGridView;


        public liveShow(View itemView) {
            super(itemView);
            mHometvlive = (TextView) itemView.findViewById(R.id.Home_item_liveshow);
            mGridView = (GridView) itemView.findViewById(R.id.Home_item_GridView);

        }


        public void setLiveShow(final HomeDataBean.DataBean.PandaliveBean liveShowbean) {
            mHometvlive.setText(liveShowbean.getTitle());
            HomeitemLiveShowAdapter adapter = new HomeitemLiveShowAdapter(liveShowbean.getList(), context);
            mGridView.setAdapter(adapter);
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "直播秀场", Toast.LENGTH_SHORT).show();
                    String liveshowurl[] = {Urls.ZHIBO1,
                            Urls.ZHIBO2,
                            Urls.ZHIBO3,
                            Urls.ZHIBO4,
                            Urls.ZHIBO5,
                            Urls.ZHIBO6,
                            Urls.ZHIBO7,
                            Urls.ZHIBO8,
                            Urls.ZHIBO9};
                    Intent intent = new Intent(context, HoneLiveVideoActivity.class);
                    intent.putExtra("zhobo", liveshowurl[position]);
                    context.startActivity(intent);

                }
            });

        }
    }


    /**
     * 精彩一刻
     */
    public class Amazing extends XRecyclerView.ViewHolder {

        TextView mHometvlive;
        GridView mGridView;
//        List<HomeCCTVBean.ListBean> mHomeList;

        public Amazing(View itemView) {
            super(itemView);
            mHometvlive = (TextView) itemView.findViewById(R.id.Home_item_Amazing_jingcai);
            mGridView = (GridView) itemView.findViewById(R.id.Home_GridView_Amazing);

        }

    }

    /**
     * 滚滚视频
     */
    class RollingVideo extends XRecyclerView.ViewHolder {
        TextView mTvRolling;
        ListView mListView;

        public RollingVideo(View itemView) {
            super(itemView);
            mTvRolling = (TextView) itemView.findViewById(R.id.Home_item_Rolling_title);
            mListView = (ListView) itemView.findViewById(R.id.Home_item_RollongVideo_ListView);
        }


    }

    /**
     * 直播中国
     */
    class LiveChian extends XRecyclerView.ViewHolder {
        TextView mTvlive;
        GridView mGrid;

        public LiveChian(View itemView) {
            super(itemView);
            mTvlive = (TextView) itemView.findViewById(R.id.Home_item_Livechian_title);
            mGrid = (GridView) itemView.findViewById(R.id.Home_item_GridView);
        }

        public void setLiveShow(final HomeDataBean.DataBean.ChinaliveBean chinaliveBean) {
            mTvlive.setText(chinaliveBean.getTitle());
            HomeitemLiveChianAdapter adapter = new HomeitemLiveChianAdapter(chinaliveBean.getList(), context);
            mGrid.setAdapter(adapter);
            mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "直播中国", Toast.LENGTH_SHORT).show();

                    String liveshowurl[] = {Urls.CHINA1,
                            Urls.CHINA2,
                            Urls.CHINA3,
                            Urls.CHINA4,
                            Urls.CHINA5,
                            Urls.CHINA6,
                            Urls.CHINA7,
                            Urls.CHINA8,
                            Urls.CHINA9};
                    Intent intent = new Intent(context, HoneLiveVideoActivity.class);
                    intent.putExtra("zhobo", liveshowurl[position]);
                    context.startActivity(intent);

                }
            });
        }
    }


}
