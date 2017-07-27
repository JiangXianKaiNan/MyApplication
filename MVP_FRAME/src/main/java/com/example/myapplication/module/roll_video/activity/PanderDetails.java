package com.example.myapplication.module.roll_video.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.PlayVideoActivity;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.constants.Urls;
import com.example.myapplication.model.bean.PandaBroadTwoBean;
import com.example.myapplication.module.roll_video.adapter.MoveXqAd;
import com.example.myapplication.module.roll_video.base.MoveTwoBean;
import com.example.myapplication.module.roll_video.base.Move_bean;
import com.example.myapplication.network.HttpUtils;
import com.example.myapplication.network.MyCallBack;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by ASUS on 2017/7/20.
 */

public class PanderDetails extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;
    @BindView(R.id.radioButton)
    CheckBox radioButton;
    @BindView(R.id.intro_lay)
    LinearLayout introLay;
    @BindView(R.id.xrecycler_view)
    XRecyclerView xrecyclerView;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.return_one)
    ImageView returnOne;
    @BindView(R.id.toobar_tit)
    TextView toobarTit;
    @BindView(R.id.intro)
    TextView intro;
    @BindView(R.id.collect)
    CheckBox collect;
    @BindView(R.id.rrr)
    PercentLinearLayout rrr;
    private ArrayList<Move_bean.VideoBean> list = new ArrayList<>();
    private MoveXqAd moveXqAd;
    private int pageIndex = 1;
    private String url;
    private List<Move_bean.VideoBean> videoo;
    private Move_bean move_bean;
    private String id;
    private String vid;
    private String desc;
    private PopupWindow popupWindow;
    private ImageView fx,sc,weibo,fcb,dingding,weixin,pengyouquan;
    private SHARE_MEDIA platform;
    private ArrayList<PandaBroadTwoBean.ListBean> liveBeen;
    private Handler handler = new Handler(
    ) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 0:
                    vid = (String) msg.obj;
                    break;
                case 1:
                    vid = (String) msg.obj;
                    break;
            }
            String url1 = "http://115.182.9.189/api/getVideoInfoForCBox.do?pid=" + vid;
            HttpUtils.getInstance().get(url1, null, new MyCallBack<MoveTwoBean>() {
                @Override
                public void onSuccess(final MoveTwoBean moveTwoBean) {
                    url = moveTwoBean.getVideo().getChapters().get(0).getUrl();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ConnectivityManager mConnectivityManager = (ConnectivityManager)PanderDetails.this
                                    .getSystemService(Context.CONNECTIVITY_SERVICE);
                            NetworkInfo mNetworkInfo = mConnectivityManager
                                    .getActiveNetworkInfo();
                            if (mNetworkInfo.isAvailable()) {
                                //获取网络类型
                                int netWorkType = mNetworkInfo.getType();
                                //TYPE_WIFI状态  直接播放
                                if (netWorkType == ConnectivityManager.TYPE_WIFI) {
                                    Intent intent1 = new Intent(PanderDetails.this, PlayVideoActivity.class);
                                    intent1.putExtra("url",url);
                                    startActivity(intent1);
                                } else if (netWorkType == ConnectivityManager.TYPE_MOBILE) {
                                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(PanderDetails.this);  //先得到构造器
                                    builder.setTitle("网络提示"); //设置标题
                                    builder.setMessage("你是4G网络是否继续播放? 亲"); //设置内容
                                    builder.setIcon(R.drawable.tab_panda_live_normal);//设置图标
                                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent1 = new Intent(PanderDetails.this, PlayVideoActivity.class);
                                            intent1.putExtra("url",url);
                                            startActivity(intent1);
                                        }
                                    });
                                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            return;
                                        }
                                    });
                                    //参数都设置完成了，创建并显示出来
                                    builder.create().show();
                                } else {
                                    Toast.makeText(PanderDetails.this, "当前无网络", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                @Override
                public void onFaile(String msg) {}
            });
        }
    };
    private JCVideoPlayer jCVideoPlayer;
    @Override
    public int getActivityLayoutId() {
        return R.layout.pander_details;
    }
    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        toobarTit.setText(intent.getStringExtra("tit"));
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);
    }
    @Override
    protected void initListener() {

    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    protected void loadData() {
        //网络请求
        internet();
        //RadioButton展示栏目介绍
        RadioBut();
        //设置适配器
        xrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        moveXqAd = new MoveXqAd(PanderDetails.this, list);
        xrecyclerView.setAdapter(moveXqAd);
        //上拉加载 下拉刷新
        xrecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrecyclerView.refreshComplete();
                list.clear();
                internet();
            }
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageIndex++;
                        internet();
                        moveXqAd.notifyDataSetChanged();
                        xrecyclerView.refreshComplete();
                    }
                }, 1000);
            }
        });
        collect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    compoundButton.setBackgroundResource(R.drawable.collect_yes);
                    Toast.makeText(PanderDetails.this, "收藏成功", Toast.LENGTH_SHORT).show();
                } else {
                    compoundButton.setBackgroundResource(R.drawable.collect_no);
                    Toast.makeText(PanderDetails.this, "取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //点击条目时间
        moveXqAd.setOnItem(new MoveXqAd.OnItem() {
            @Override
            public void onItemClick(int integer) {
                vid = list.get(integer).getVid();
                Message message = new Message();
                message.arg1 = 1;
                message.obj = vid;
                handler.sendMessage(message);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    /*
    * 返回
    * 收藏
    * 分享
    * 点击事件
    * */
    @OnClick({R.id.return_one, R.id.share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.return_one:
                finish();
                break;
            case R.id.share:
                //分享
                fenxiang();
                break;
        }
    }
//网络请求
    private void internet() {
        String url = " http://api.cntv.cn/video/videolistById?p=" + pageIndex + "&serviceId=panda&n=10&vsid=" + id;
        HttpUtils.getInstance().get(url, null, new MyCallBack<Move_bean>() {
            @Override
            public void onSuccess(Move_bean move_bean) {
                desc = move_bean.getVideoset().get_$0().getDesc();
                list.addAll(move_bean.getVideo());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        moveXqAd.notifyDataSetChanged();
                        vid = list.get(0).getVid();
                        Message message = new Message();
                        message.arg1 = 0;
                        message.obj = vid;
                        handler.sendMessage(message);
                    }
                });
            }
            @Override
            public void onFaile(String msg) {

            }
        });
    }
    /*
       * 获取Toobar标题、栏目介绍
       * 并设置
       * */
    private void RadioBut() {
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    introLay.setVisibility(View.VISIBLE);
                    intro.setText(desc);
                    radioButton.setBackgroundResource(R.mipmap.lpanda_off);
                } else {
                    introLay.setVisibility(View.GONE);
                    radioButton.setBackgroundResource(R.mipmap.live_china_detail_down);
                }
            }
        });
    }
    //分享
    private void fenxiang() {
        View inflate = LayoutInflater.from(PanderDetails.this).inflate(R.layout.layout_fenxiang, null);
        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
        weibo = (ImageView) inflate.findViewById(R.id.weibo);
        fcb = (ImageView) inflate.findViewById(R.id.fcb);
        dingding = (ImageView) inflate.findViewById(R.id.dingding);
        weixin = (ImageView) inflate.findViewById(R.id.weixin);
        pengyouquan = (ImageView) inflate.findViewById(R.id.pengyouquan);
        Button button = (Button) inflate.findViewById(R.id.button);
        button.setOnClickListener(this);
        weibo.setOnClickListener(this);
        fcb.setOnClickListener(this);
        dingding.setOnClickListener(this);
        weixin.setOnClickListener(this);
        pengyouquan.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fcb:
                AlertDialog alertDialog2 = new AlertDialog.Builder(PanderDetails.this).setNegativeButton("取消", null)
                        .setMessage("熊猫频道想要打开FACEBOOK")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.FACEBOOK;
                                UMImage image = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);//资源文件
                                UMImage thumb = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);
                                image.setThumb(thumb);
                                new ShareAction(PanderDetails.this).withText(url).setPlatform(SHARE_MEDIA.FACEBOOK)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.dingding:
                AlertDialog alertDialog3 = new AlertDialog.Builder(PanderDetails.this).setNegativeButton("取消", null)
                        .setMessage("熊猫频道想要打开TWITTER")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.TWITTER;
                                UMImage image = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);//资源文件
                                UMImage thumb = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);
                                image.setThumb(thumb);
                                new ShareAction(PanderDetails.this).withText(url).setPlatform(SHARE_MEDIA.TENCENT)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.weibo:
                AlertDialog alertDialog = new AlertDialog.Builder(PanderDetails.this).setNegativeButton("取消", null)
                        .setMessage("熊猫频道想要打开微博")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.SINA;
                                UMImage image = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);//资源文件
                                UMImage thumb = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);
                                image.setThumb(thumb);
                                new ShareAction(PanderDetails.this).withText(url).setPlatform(SHARE_MEDIA.SINA)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.weixin:
                AlertDialog alertDialog1 = new AlertDialog.Builder(PanderDetails.this).setNegativeButton("取消", null)
                        .setMessage("熊猫频道想要打开微信")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.WEIXIN;
                                UMImage image = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);//资源文件
                                UMImage thumb = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);
                                image.setThumb(thumb);
                                new ShareAction(PanderDetails.this).setPlatform(SHARE_MEDIA.WEIXIN)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.pengyouquan:
                AlertDialog alertDialog5 = new AlertDialog.Builder(PanderDetails.this).setNegativeButton("取消", null)
                        .setMessage("熊猫频道想要打开微信朋友圈")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                platform = SHARE_MEDIA.WEIXIN_CIRCLE;
                                UMImage image = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);//资源文件
                                UMImage thumb = new UMImage(PanderDetails.this, R.drawable.logo_ipnda);
                                image.setThumb(thumb);
                                new ShareAction(PanderDetails.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                                        .withMedia(image)
                                        .setCallback(umShareListener)
                                        .share();
                            }
                        })
                        .show();
                break;
            case R.id.button:
                popupWindow.dismiss();
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
            Log.d("plat", "platform" + platform);
            Toast.makeText(PanderDetails.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(PanderDetails.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(PanderDetails.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();}
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);}
}
