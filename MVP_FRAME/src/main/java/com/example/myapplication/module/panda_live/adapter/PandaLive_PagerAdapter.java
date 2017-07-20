package com.example.myapplication.module.panda_live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ASUS on 2017/7/19.
 */

public class PandaLive_PagerAdapter extends FragmentPagerAdapter{
    String[] strings = new String[]{"直播","精彩时刻","当熊不让","超萌滚滚秀","熊猫档案","熊猫TOP榜","熊猫那些事","特别节目","原创新闻"};
    private List<Fragment> list;

    public PandaLive_PagerAdapter(FragmentManager fm, List<Fragment> list) {
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
