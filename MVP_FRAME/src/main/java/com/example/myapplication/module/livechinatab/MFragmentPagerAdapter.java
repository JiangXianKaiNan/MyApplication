package com.example.myapplication.module.livechinatab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myapplication.base.BaseFragment;

import java.util.List;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class MFragmentPagerAdapter extends FragmentPagerAdapter {
    List<String> listname;
    List<BaseFragment> listfragment;

    public MFragmentPagerAdapter(FragmentManager fm, List<String> listname, List<BaseFragment> listfragment) {
        super(fm);
        this.listname = listname;
        this.listfragment = listfragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.isEmpty()?0:listfragment.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return listname.get(position);
    }
}
