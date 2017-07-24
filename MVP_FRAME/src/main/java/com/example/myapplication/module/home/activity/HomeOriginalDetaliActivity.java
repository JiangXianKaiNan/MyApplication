package com.example.myapplication.module.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-22 11:54
 * 修改人:
 * 修改内容:
 */

public class HomeOriginalDetaliActivity extends BaseActivity {
    @BindView(R.id.Original_Detali_back)
    ImageView OriginalDetaliBack;
    @BindView(R.id.Original_Detali_fenxiang)
    ImageView OriginalDetaliFenxiang;
    @BindView(R.id.Original_Detali_WebView)
    WebView OriginalDetaliWebView;

    private String url;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_homewebview;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        Intent intent = getIntent();
        url = intent.getStringExtra("Url");
        Log.e("原创·互动", url);

    }

    @Override
    protected void loadData() {
        if (url != null) {
            OriginalDetaliWebView.loadUrl(url);
        }

                   /*
                    *Webview 在自己的APP中加载的方法：
                    */
        OriginalDetaliWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }



    @OnClick({R.id.Original_Detali_back, R.id.Original_Detali_fenxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Original_Detali_back:
                finish();
                break;
            case R.id.Original_Detali_fenxiang://分享
                break;
        }
    }
}
