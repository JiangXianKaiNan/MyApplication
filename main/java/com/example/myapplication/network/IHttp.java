package com.example.myapplication.network;

import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:47
 * 作 者：T
 * 微信：704003376
 */
public interface IHttp {
    <T> void get(String url, Map<String, String> params, MyCallBack<T> callBack);
    <T> void post(String url, Map<String, String> params, MyCallBack<T> callBack);
}

