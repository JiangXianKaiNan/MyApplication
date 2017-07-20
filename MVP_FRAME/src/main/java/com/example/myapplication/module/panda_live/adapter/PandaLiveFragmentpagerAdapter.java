package com.example.myapplication.module.panda_live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class PandaLiveFragmentpagerAdapter extends FragmentPagerAdapter {
    String[] strings = new String[]{"多视角直播","边看边聊"};
    private List<Fragment> list;

    public PandaLiveFragmentpagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
