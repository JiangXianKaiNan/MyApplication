package com.example.myapplication.config;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.global.MyApp;


/**
 * Created by LENOVO on 2017/5/9.
 */

public class FragmentBuilder {

    private static FragmentBuilder fragmentBuilder;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BaseFragment lastFragment;
    private BaseFragment fragment;
    private String simpleName;
    private boolean isDefault = true;
    private int containerViewId;

    private FragmentBuilder() {
        init();
    }

    public synchronized static FragmentBuilder getInstance() {
        if (fragmentBuilder == null) {
            fragmentBuilder = new FragmentBuilder();
            return fragmentBuilder;
        }
        return fragmentBuilder;
    }

    public FragmentBuilder init() {
        fragmentManager = MyApp.mContext.getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        return this;
    }

    public FragmentBuilder start(Class<? extends BaseFragment> fragmentClass) {


        //使用fragment类名做Tag
        simpleName = fragmentClass.getSimpleName();

//        根据tag查找fragment   如果能查找到就代表fragment已经实例化了，是否去动态实例化
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
//         判断fragment是否为空  不为空就自动创建fragment对象
        if (fragment == null) {
            try {
                //java动态代理
                fragment = fragmentClass.newInstance();
                //判断是否添加过，没有就添加
                transaction.add(R.id.Home_ComtentGroup, fragment, simpleName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        //隐藏上一个fragment
        if (MyApp.lastfragment != null) {
            transaction.hide(MyApp.lastfragment);
        }

        Log.e("FragmentBuilder", simpleName);
        //已经添加调用该方法
        transaction.show(fragment);
        transaction.addToBackStack(simpleName);
        return this;
    }


    public FragmentBuilder params(Bundle params) {
        if (params != null) {
            fragment.setParams(params);
        }
        return this;
    }

    public FragmentBuilder replace() {
        isDefault = false;
        transaction.replace(containerViewId, fragment, fragment.getClass().getSimpleName());
        return this;
    }

    public FragmentBuilder isBack(boolean isBack) {
        if (isBack)
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        return this;
    }

    public BaseFragment build() {
        transaction.addToBackStack(simpleName);
        MyApp.lastfragment = fragment;

        transaction.commit();
        return fragment;
    }


}
