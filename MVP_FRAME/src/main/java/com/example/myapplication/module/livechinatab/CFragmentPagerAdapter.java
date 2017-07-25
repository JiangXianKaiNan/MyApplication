package com.example.myapplication.module.livechinatab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.myapplication.base.BaseFragment;

import java.util.List;

/**
 * Created by 12710 on 2017/7/19.
 */

public class CFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> fragments;
    private List<String> titles;
    public CFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
