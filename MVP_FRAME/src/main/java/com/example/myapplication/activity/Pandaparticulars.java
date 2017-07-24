package com.example.myapplication.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class Pandaparticulars extends BaseActivity implements View.OnClickListener {
    private WebView view;
    private String id;
    private ImageView fx;
    private ImageView sc;
    private ImageView weibo;
    private ImageView fcb;
    private ImageView dingding;
    private ImageView weixin;
    private ImageView pengyouquan;
    private SHARE_MEDIA platform;
    private String title;
    private String url;
    private PopupWindow popupWindow;

    @Override
    protected void initView() {
        view = (WebView) findViewById(R.id.webview);
        fx = (ImageView) findViewById(R.id.fenxiang);
        sc =(ImageView)findViewById(R.id.shouchang);
        Intent intent=getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        Log.e("TTT",title);
        url = intent.getStringExtra("url");
        Log.e("TTT",url);
        fx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenxiang();
            }
        });
        view.loadUrl(url);
        view.getSettings().setUseWideViewPort(true);
        view.getSettings().setLoadWithOverviewMode(true);
        view.getSettings().setSupportZoom(true);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main2;
    }

    private void fenxiang() {
        View inflate = LayoutInflater.from(Pandaparticulars.this).inflate(R.layout.layout_fenxiang, null);
        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
        weibo = (ImageView) inflate.findViewById(R.id.weibo);
        fcb =(ImageView)inflate.findViewById(R.id.fcb);
        dingding =(ImageView)inflate.findViewById(R.id.dingding);
        weixin =(ImageView)inflate.findViewById(R.id.weixin);
        pengyouquan =(ImageView)inflate.findViewById(R.id.pengyouquan);
        Button button= (Button) inflate.findViewById(R.id.button);
        button.setOnClickListener(this);
        weibo.setOnClickListener(this);
        fcb.setOnClickListener(this);
        dingding.setOnClickListener(this);
        weixin.setOnClickListener(this);
        pengyouquan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fcb:
                AlertDialog alertDialog2=new AlertDialog.Builder(Pandaparticulars.this).setNegativeButton("取消",null)
                        .setMessage("熊猫频道想要打开FACEBOOK")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.FACEBOOK;
                                UMImage image = new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );//资源文件
                                UMImage thumb =  new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );
                                image.setThumb(thumb);
                                new ShareAction(Pandaparticulars.this).withText(title+url).setPlatform(SHARE_MEDIA.FACEBOOK)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.dingding:
                AlertDialog alertDialog3=new AlertDialog.Builder(Pandaparticulars.this).setNegativeButton("取消",null)
                        .setMessage("熊猫频道想要打开TWITTER")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.TWITTER;
                                UMImage image = new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );//资源文件
                                UMImage thumb =  new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );
                                image.setThumb(thumb);
                                new ShareAction(Pandaparticulars.this).withText(title+url).setPlatform(SHARE_MEDIA.TENCENT)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.weibo:
                AlertDialog alertDialog=new AlertDialog.Builder(Pandaparticulars.this).setNegativeButton("取消",null)
                        .setMessage("熊猫频道想要打开微博")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.SINA;
                                UMImage image = new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );//资源文件
                                UMImage thumb =  new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );
                                image.setThumb(thumb);
                                new ShareAction(Pandaparticulars.this).withText(title+url).setPlatform(SHARE_MEDIA.SINA)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();

                break;
            case R.id.weixin:
                AlertDialog alertDialog1=new AlertDialog.Builder(Pandaparticulars.this).setNegativeButton("取消",null)
                        .setMessage("熊猫频道想要打开微信")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.WEIXIN;
                                UMImage image = new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );//资源文件
                                UMImage thumb =  new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );
                                image.setThumb(thumb);
                                new ShareAction(Pandaparticulars.this).setPlatform(SHARE_MEDIA.WEIXIN)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.pengyouquan:
                AlertDialog alertDialog5=new AlertDialog.Builder(Pandaparticulars.this).setNegativeButton("取消",null)
                        .setMessage("熊猫频道想要打开微信朋友圈")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.WEIXIN_CIRCLE;
                                UMImage image = new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );//资源文件
                                UMImage thumb =  new UMImage(Pandaparticulars.this,R.drawable.logo_ipnda );
                                image.setThumb(thumb);
                                new ShareAction(Pandaparticulars.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case  R.id.button:
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                break;
        }
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(Pandaparticulars.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(Pandaparticulars.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(Pandaparticulars.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
