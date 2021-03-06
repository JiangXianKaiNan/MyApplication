package com.example.myapplication.network;

import android.util.Log;

import com.example.myapplication.global.MyApp;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:54
 * 作 者：T
 * 微信：704003376
 */

public class HttpUtils implements IHttp {
    private static HttpUtils mHttpUtils;
    private OkHttpClient mOkHttpClient;

    private HttpUtils() {
        mOkHttpClient = new OkHttpClient();
    }

    public synchronized static HttpUtils getInstance() {
        if (mHttpUtils == null)
            mHttpUtils = new HttpUtils();
        return mHttpUtils;
    }

    // http://www.qq.com?name=xxx&pwd=xxx;
    @Override
    public <T> void get(String url, Map<String, String> params, final MyCallBack<T> callBack) {
    if (params != null) {
            StringBuffer sb = new StringBuffer(url);
            sb.append("?");
            Set<String> set = params.keySet();
            for (String key : set) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }

            url = sb.deleteCharAt(sb.length() - 1).toString();
        }

        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                MyApp.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFaile(e.getMessage());
                    }
                });
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                MyApp.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(getGeneric(jsonData, callBack));

                    }
                });
            }
        });



    }

    /**
     * Gson解析 获取实体对象
     * 通过反射机制获取当前接口实现类的类型
     * 根据类获取当前类对应的对象
     *
     * @param <T>
     * @param jsonData
     * @param callback
     * @return
     */
    private <T> T getGeneric(String jsonData, MyCallBack<T> callback) {
//        Log.e("请求的数据", jsonData);
        Type[] types = callback.getClass().getGenericInterfaces();
        Type[] parameterTypes = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = parameterTypes[0];
        Gson gson = new Gson();
        T t = gson.fromJson(jsonData, type);
        return t;
    }


    @Override
    public <T> void post(String url, Map<String, String> params, final MyCallBack<T> callBack) {
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> set = params.keySet();
        for (String key : set) {
            builder.add(key, params.get(key));
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                MyApp.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFaile(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                MyApp.mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(getGeneric(jsonData, callBack));
                    }
                });

            }
        });

    }
}
