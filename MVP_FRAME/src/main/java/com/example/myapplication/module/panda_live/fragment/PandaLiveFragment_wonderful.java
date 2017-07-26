package com.example.myapplication.module.panda_live.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.PlayVideoActivity;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.PandaFragmentlistData;
import com.example.myapplication.module.panda_live.PandaDataListPresenter;
import com.example.myapplication.module.panda_live.PandaFragmentDataContract;
import com.example.myapplication.module.panda_live.adapter.XRecyclerViewAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class PandaLiveFragment_wonderful extends BaseFragment implements PandaFragmentDataContract.PandaLiveView {


    XRecyclerView pandaliveWonderfulListview;
    private PandaFragmentDataContract.PandaLivePresenter mPandaLivPresenter;
    private XRecyclerViewAdapter adapter;
    private List<PandaFragmentlistData.VideoBean> videosetBeen = new ArrayList<>();
    int P = 1;
    private String id;
    private String url;

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        id = bundle.getString("id", "");
        mPandaLivPresenter = new PandaDataListPresenter(this, id, P);
        mPandaLivPresenter.start();

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    protected void initView(View view) {
        pandaliveWonderfulListview = (XRecyclerView) view.findViewById(R.id.pandalive_wonderful_listview);
        adapter = new XRecyclerViewAdapter(getActivity(), videosetBeen);
        pandaliveWonderfulListview.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        pandaliveWonderfulListview.setAdapter(adapter);

        pandaliveWonderfulListview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                pandaliveWonderfulListview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pandaliveWonderfulListview.loadMoreComplete();
                P++;
                initData();
                pandaliveWonderfulListview.refreshComplete();
            }
        });
        adapter.setItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                String substring = videosetBeen.get(position).getPtime().substring(0, 10).replace("-", "/");
                if (id.equals("VSET100340574858")) {
                    url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + videosetBeen.get(position).getVid() + "_h264418000nero_aac32-1.mp4";
                } else {

                    if (id.equals("VSET100272959126")) {
                        url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video59/TMS/" + substring + "/" + videosetBeen.get(position).getVid() + "_h264418000nero_aac32.mp4";
                    } else {
                        if (id.equals("VSET100237714751")) {
                            url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + videosetBeen.get(position).getVid() + "_h264418000nero_aac32.mp4";
                        } else {
                            if (id.equals("VSET100167308855")) {
                                url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + videosetBeen.get(position).getVid() + "_h264418000nero_aac32-1.mp4";

                            } else {

                                url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + videosetBeen.get(position).getVid() + "_h264418000nero_aac32.mp4";
                            }

                        }
                    }
                }


//                http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/07/08/241dff898424469e98196f8b38fad15a_h264418000nero_aac32-1.mp4
//                http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/07/05/51adae6767aa43ff8dee0a93dcbdd117_h264418000nero_aac32.mp4
//                http://cntv.vod.cdn.myqcloud.com/flash/mp4video59/TMS/2017/04/09/00362cdfea104d7298feacfbe8b40549_h264418000nero_aac32.mp4
//                http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/07/20/03ddbe69099441b09961bd37d8a8f782_h264418000nero_aac32-1.mp4
//                http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/04/09/00362cdfea104d7298feacfbe8b40549_h264418000nero_aac32-1.mp4


//                http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/07/20/03ddbe69099441b09961bd37d8a8f782_h264418000nero_aac32-1.mp4
//                http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/07/21/01180afca0f04fff881d3eec9fd1d96a_h264418000nero_aac32.mp4
                Intent intent = new Intent(getActivity(), PlayVideoActivity.class);
                intent.putExtra("url", url);
                Log.e("url＝＝＝＝＝", url);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.pandalive_wonderful;
    }

    @Override
    public void setPresenter(PandaDataListPresenter pandaDataListPresenter) {

    }


    @Override
    public void setPandaFragmentlistData(PandaFragmentlistData pandaFragmentlistData) {
        if (pandaFragmentlistData.getVideo() != null) {
            videosetBeen.addAll(pandaFragmentlistData.getVideo());
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getActivity(), "别刷了哥,没数据了", Toast.LENGTH_SHORT).show();
        }

    }

}
