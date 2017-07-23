package com.example.myapplication.model;

import com.example.myapplication.model.bean.BaDaLingBean;
import com.example.myapplication.model.bean.HomeCCTVBean;
import com.example.myapplication.model.bean.HomeDataBean;
import com.example.myapplication.model.bean.HomeVideoBean;
import com.example.myapplication.model.bean.LiveChinaBean;
import com.example.myapplication.model.bean.LiveListBean;
import com.example.myapplication.model.bean.MultiBean;
import com.example.myapplication.model.bean.OriginalBean;
import com.example.myapplication.model.bean.PandaBroadBean;
import com.example.myapplication.model.bean.PandaBroadTwoBean;
import com.example.myapplication.model.bean.PandaFragmentlistData;
import com.example.myapplication.model.bean.PandaLiveBean;
import com.example.myapplication.model.bean.RollRollVideoBean;
import com.example.myapplication.model.bean.SidelookBean;
import com.example.myapplication.model.bean.TableListBaen;
import com.example.myapplication.model.bean.WinderfulBean;
import com.example.myapplication.network.MyCallBack;

import java.util.Map;

import okhttp3.Callback;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:27
 * 作 者：T
 * 微信：704003376
 *
 * 请求各个模块数据
 */

public interface PandaChannelModel {

    /**
     * 首页数据
     * @param callBack
     */
    void getHomeData(MyCallBack<HomeDataBean> callBack);

    /**
     * 获取精彩一刻数据
     * @param callBack
     */
    void getWinderfulData(MyCallBack<HomeCCTVBean> callBack);


    /**
     * 滚滚视频数据
     *
     * @param callBack
     */
    void getRollVideoData(MyCallBack<RollRollVideoBean> callBack);


    /**
     * 获取直播中国数据
     *
     * @param callBack
     */
    void getLiveData(MyCallBack<LiveChinaBean> callBack);


    /**
     * 熊猫播报1(请求URL中有参数的)
     * @param path
     * @param primaryId
     * @param serviceId
     * @param callBack
     */
    void getPandaBroadData(String path, String primaryId,
                           String serviceId, MyCallBack<PandaBroadBean> callBack);

    /**
     * 熊猫播报2（请求URL中没有参数）
     * @param callBack
     */
    void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack);


    /**
     * 获取多角度数据
     * @param callBack
     */
    void getMultiData(MyCallBack<MultiBean> callBack);


    /**
     * 获取首页视频
     * @param callBack
     */
    void getHomeVideoData(MyCallBack<HomeVideoBean> callBack);


    /**
     * 获取原创互动
     * @param callback
     */
    void getOriginalData(MyCallBack<OriginalBean> callback);


    /**
     * 获取八达岭数据
     * @param callBack
     */
    void getBaDaLingData(MyCallBack<BaDaLingBean> callBack);



    /**
     * 熊猫直播
     * @param callBack
     */
    void getPandaLiveData(MyCallBack<PandaLiveBean> callBack);

    /**
     * 熊猫直播列表
     * @param callBack
     */
    void getTablelistData(MyCallBack<TableListBaen> callBack);

    /**
     * 熊猫直播faragmentdata
     * @param callBack
     */
    void getPandaFragmentlistData(Map<String,String> map, MyCallBack<PandaFragmentlistData> callBack);

    /**
     * 熊猫直播边看边聊
     * prepage=20&nature=1&app=ipandaApp&page=1&itemid=zhiboye_chat
     * @param callBack
     */
    void getSidelookSidechattData(Map<String,String> map, MyCallBack<SidelookBean> callBack);

    void getLiveListData(Map<String,String> map, MyCallBack<LiveListBean> liveListBean);

}
