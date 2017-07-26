package com.example.myapplication.module.livechina;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.LiveChinaContentBean;
import com.example.myapplication.view.BaseAdapters;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/20
 * 修改人:
 * 修改内容:
 */
public class LiveChinaAdapter extends BaseAdapters<LiveChinaContentBean.LiveBean> {
    int s=0;
    OkHttpClient client = new OkHttpClient();
    private LiveSLV slv;
    private VideoView videoview_top;
    private JCVideoPlayer jCVideoPlayer;//节操视频
    private VideoView mVideoView;
private Context mContext;
    public LiveChinaAdapter(Context context, int layoutId, List<LiveChinaContentBean.LiveBean> datas) {
        super(context, R.layout.livechina_item, datas);
    }

    @Override
    public void convert(final ViewHolder holder, final LiveChinaContentBean.LiveBean liveBean) {
         //直播地址
        String u = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+liveBean.getId()+"&client=androidapp";
        Log.e("LiveChinaAdapter---", u);
        holder.setText(R.id.livechina_item_title,liveBean.getTitle());
        holder.setText(R.id.livechina_item_titles,"简介");
        holder.setText(R.id.livechina_item_body,liveBean.getBrief());

        //jiantou
        final CheckBox checkBox= holder.getView(R.id.live_checkbox);
        final TextView body = holder.getView(R.id.livechina_item_body);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    body.setVisibility(View.VISIBLE);
                } else {
                    body.setVisibility(View.GONE);
                }
            }
        });
//        final TextView tv_titlt = holder.getView(R.id.livechina_item_title);
//       final TextView tv_body= holder.getView(R.id.livechina_item_body);
//       final ImageView iv=  holder.setImageResource(R.id.livechina_item_img,R.mipmap.ic_launcher).getView(R.id.livechina_item_img);
//        Glide.with(context).load(liveBean.getImage()).into(iv);
//
//        jCVideoPlayer = holder.getView(R.id.videocontroller1);
//        jCVideoPlayer.setUp("http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8",
//                liveBean.getImage());
        videoview_top = holder.getView(R.id.lc_videoview);
        final ImageView bo = holder.getView(R.id.lc_fi_bo);
        final ImageView imageView=holder.getView(R.id.lc_fi_image);

        Glide.with(context).load(liveBean.getImage()).asBitmap()
                .thumbnail(0.05f)//降低分辨率
                .placeholder(R.drawable._no_img)//未加载是背景图
                .error(R.color.colorAccent)//图片加载错误是背景图
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        final Request request = new Request.Builder().url(u).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                slv = gson.fromJson(s, LiveSLV.class);

            }
        });
        holder.setOnclickListener(R.id.lc_fi_image, new View.OnClickListener() {

            private MediaController controller = new MediaController(context);


            @Override
            public void onClick(View v) {
                if (videoview_top.isPlaying()) {
                    videoview_top.stopPlayback();
                    imageView.setVisibility(View.VISIBLE);
                    bo.setVisibility(View.VISIBLE);
                }else {
//                    videoview_top.stopPlayback();
//                    notifyDataSetChanged();
                    imageView.setVisibility(View.GONE);
                    bo.setVisibility(View.GONE);
                    Toast.makeText(context, "播放", Toast.LENGTH_SHORT).show();
//                    controller.show();
//                    videoview_top.setMediaController(controller);//绑定控制器
//                    videoview_top.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);//设置播放画质 高画质
//                    videoview_top.requestFocus();//取得焦点
//                    videoview_top.setVideoPath(slv.getFlv_url().getFlv2());//设置播放地址















                    videoview_top.setVideoURI(Uri.parse(slv.getFlv_url().getFlv2()));
                    videoview_top.setMediaController(controller);
                    controller.setMediaPlayer(videoview_top);
                    controller.setVisibility(View.INVISIBLE);
                    videoview_top.setMediaController(controller);
                    videoview_top.requestFocus();
                    videoview_top.start();   //开始播放
                }

            }
        });

    }

}
