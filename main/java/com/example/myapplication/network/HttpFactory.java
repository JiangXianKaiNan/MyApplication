package com.example.myapplication.network;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 10:44
 * 作 者：T
 * 微信：704003376
 */

public class HttpFactory {
    /**
     * @return获取HttpUtils对象
     */
    public static HttpUtils create()
    {
        return HttpUtils.getInstance();
    }

}
