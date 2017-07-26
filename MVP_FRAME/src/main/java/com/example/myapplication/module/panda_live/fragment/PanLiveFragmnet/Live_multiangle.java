package com.example.myapplication.module.panda_live.fragment.PanLiveFragmnet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.LiveListBean;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.module.panda_live.PandaFragmentPresenter;
import com.example.myapplication.module.panda_live.PandaLiveContract;
import com.example.myapplication.module.panda_live.adapter.GridViewMultiangleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class Live_multiangle extends BaseFragment implements PandaLiveContract.PandaLiveView {

//    @BindView(R.id.multiangle_grid)
    GridView multiangleGrid;
    private GridViewMultiangleAdapter adapter;
    private List<MultiBean.ListBean>  liveBeen = new ArrayList<>();
    private PandaLiveContract.PandaLivePresenter mPandaLivPresenter;
    public String ids = "ipanda";
    private String url;

    @Override
    public int getFragmentLayoutId() {
        Log.e("TAG","getFragmentLayoutId");
        return R.layout.live_multiangle;
    }

    @Override
    protected void initView(View view) {
        Log.e("TAG","initView");
        multiangleGrid = (GridView) view.findViewById(R.id.multiangle_grid);

    }

    @Override
    protected void initData() {
        Log.e("TAG","initData");

        mPandaLivPresenter = new PandaFragmentPresenter(this,ids);
        mPandaLivPresenter.start();

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {

    }

    @Override
    public void setResultData(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void setResultData(MultiBean multiBean) {
        Log.e("TAG","setResultData");
        if(multiBean.getList()!=null){

            liveBeen.addAll(multiBean.getList());
        }
        Log.e("TAG","setResultData2");
        adapter = new GridViewMultiangleAdapter(getActivity(),liveBeen);
        multiangleGrid.setAdapter(adapter);
        multiangleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ids = liveBeen.get(position).getId();
                Log.e("ididididid====",ids);
                initData();
                Intent intent = new Intent();
                intent.putExtra("title",liveBeen.get(position).getTitle());
                intent.putExtra("url",url);
                intent.setAction("zhibo");
                getActivity().sendBroadcast(intent);
            }
        });
    }

    @Override
    public void setPandatablelist(TableListBaen listBaen) {

    }

    @Override
    public void setLiveListData(LiveListBean liveListBean) {
    if(liveListBean!=null){
    url = liveListBean.getFlv_url().getFlv2();
    Log.e("ididididid",liveListBean.toString());

//    Toast.makeText(getActivity(), liveListBean.getFlv_url().getFlv2(), Toast.LENGTH_SHORT).show();

}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("TAG","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","onDestroy");
        super.onDestroy();
    }
}
