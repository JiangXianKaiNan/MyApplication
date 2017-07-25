package com.example.myapplication.module.livechinatab;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.util.ArraySet;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.model.bean.LiveChinaBean;
import com.example.myapplication.module.livechina.LiveChinaFragment;
import com.example.myapplication.view.MyGridLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class LiveChinaTabFragment extends BaseFragment implements LiveChinaTabContract.LiveChinaTabView,View.OnClickListener {
    @BindView(R.id.livechina_tab)
    TabLayout livechinaTab;
    @BindView(R.id.livechina_Add)
    ImageView livechinaAdd;
    @BindView(R.id.livechina_vp)
    ViewPager livechinaVp;
    Unbinder unbinder;
    List<BaseFragment> fragmentList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    private CFragmentPagerAdapter adapter;
    private LiveChinaTabContract.LiveChinaTabPresenter mliveChinaTabPresenter;
    private PopupWindow mPopupWindow;
    ImageView cha;
    TextView bianji;
    private View viewById;
    MyGridLayout grid1, grid2;
    private List<String> list3;
    private ArrayList<String> list;
    private List<LiveChinaBean.AlllistBean> chinaBeanList;
    boolean sss = false;
    private List<String> list2;


    @Override
    public int getFragmentLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void initView(View view) {
        viewById = view.findViewById(R.id.view_view);
        View popupview = View.inflate(getContext(), R.layout.fragment_livechina_add, null);
        cha = (ImageView) popupview.findViewById(R.id.lc_add_cha);
        bianji = (TextView) popupview.findViewById(R.id.lc_add_bianji);
        grid1 = (MyGridLayout) popupview.findViewById(R.id.grid_one);
        grid2 = (MyGridLayout) popupview.findViewById(R.id.grid_two);
        mPopupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.PopupAnimation);

        list = new ArrayList<>();
        list2 = new ArrayList<>();

        initlistener();
    }
    private void initlistener() {
//        livechinaAdd.setOnClickListener(this);
        cha.setOnClickListener(this);
        bianji.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mliveChinaTabPresenter = new LiveChinaTabPresenter(this);
        mliveChinaTabPresenter.start();

    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setPresenter(LiveChinaTabContract.LiveChinaTabPresenter liveChinaTabPresenter) {
    mliveChinaTabPresenter =  liveChinaTabPresenter;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.livechina_tab, R.id.livechina_Add, R.id.livechina_vp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.livechina_tab:

                break;
            case R.id.livechina_Add:
                mPopupWindow.showAsDropDown(viewById, 0, 0);
                initpopup();
                break;
            case R.id.livechina_vp:
                break;
        }
    }

    private void initpopup() {
        //上Gridview 添加item
        grid1.setGridLayoutItemDrageAble(true);

        list.addAll(titleList);
        grid1.addItems(list);

        //下Gridview 添加item
        grid2.setGridLayoutItemDrageAble(false);
        for(String str1 : list3){
            if(!list.contains(str1)){
                // 打印出list2没有b,d
                list2.add(str1);
            }
        }
        grid2.addItems(list2);

        grid1.setOnItemSelectListener(new MyGridLayout.OnItemSelectListener() {
            @Override
            public void onItemSelect(String indexString) {
                list.remove(indexString);
                if (!list2.contains(indexString)){
                    list2.add(indexString);
                    grid2.addTvItem(indexString);
                }
            }
        });
        grid2.setOnItemSelectListener(new MyGridLayout.OnItemSelectListener() {
            @Override
            public void onItemSelect(String indexString) {

                list2.remove(indexString);
                if (!list.contains(indexString)){
                    list.add(indexString);
//                    grid1.addItems(list);
                    grid1.addTvItem(indexString);

                }



            }


        });
    }

    @Override
    public void setResultData(LiveChinaBean liveChinaBean) {
//        fragmentList = new ArrayList<>();
//        titleList = new ArrayList<>();
//        for (int i = 0; i <liveChinaBean.getTablist().size() ; i++) {
//            titleList.add(liveChinaBean.getTablist().get(i).getTitle());
//            fragmentList.add(new LiveChinaFragment(liveChinaBean.getTablist().get(i).getUrl()));
//        }
//        adapter = new MFragmentPagerAdapter(getChildFragmentManager(),titleList,fragmentList);
//        livechinaVp.setAdapter(adapter);
//        livechinaTab.setupWithViewPager(livechinaVp);
//
// livechinaTab.setTabMode();


//        fragmentList = new ArrayList<>();
//        titleList = new ArrayList<>();

        list3 = new ArrayList<>();
        chinaBeanList = new ArrayList<>();
        if (chinaBeanList!=null){
            chinaBeanList.addAll(liveChinaBean.getAlllist());
        }
        for (int i = 0; i <liveChinaBean.getAlllist().size(); i++) {
            list3.add(liveChinaBean.getAlllist().get(i).getTitle());
        }

        if (getContext().getSharedPreferences("data", Context.MODE_PRIVATE).getString("asd","").equals("")){
            for (int i = 0; i <liveChinaBean.getTablist().size(); i++) {

                fragmentList.add(new LiveChinaFragment(liveChinaBean.getTablist().get(i).getUrl()));
                titleList.add(liveChinaBean.getTablist().get(i).getTitle());
            }

        }else {

            initload();
        }

        adapter = new CFragmentPagerAdapter(getChildFragmentManager(),fragmentList,titleList);
        livechinaVp.setAdapter(adapter);
        livechinaTab.setupWithViewPager(livechinaVp);
        livechinaTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        sss =true;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.lc_add_cha:
                mPopupWindow.dismiss();

                SharedPreferences sp = getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("asd", "2");
                Set<String> set = new ArraySet<String>();
                set.addAll(list);
                editor.putStringSet("slist", set);
                editor.commit();


                if (sss) {
                    if (!getContext().getSharedPreferences("data",Context.MODE_PRIVATE).getString("asd","").equals("")){

                        initload();

                        adapter.notifyDataSetChanged();

                    }
                }
                if (list.size()>0) {
                    list.clear();
                    list2.clear();
                    grid1.removeAllViews();
                    grid2.removeAllViews();
                }

                break;
            case R.id.lc_add_bianji:
                break;
        }
    }
    private void initload() {
        Set<String> setlist = new ArraySet<>();
        setlist.addAll(list3);
        titleList.clear();
        fragmentList.clear();

        Set<String> titleSet = getContext().getSharedPreferences("data", Context.MODE_PRIVATE).getStringSet("slist", setlist);
        titleList.addAll(titleSet);
        for (int i = 0; i < titleList.size(); i++) {
            for (int j = 0; j <chinaBeanList.size(); j++) {
                if (titleList.get(i).equals(chinaBeanList.get(j).getTitle())) {
                    fragmentList.add(new LiveChinaFragment(chinaBeanList.get(j).getUrl()));
                }
            }

        }
    }
}
