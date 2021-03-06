package com.example.myapplication.model;

import com.example.myapplication.activity.LoginBean;
import com.example.myapplication.constants.Urls;
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
import com.example.myapplication.network.HttpFactory;
import com.example.myapplication.network.MyCallBack;
import com.umeng.socialize.utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:41
 * 作 者：T
 * 微信：704003376
 */

public class PandaChannelModelImp implements PandaChannelModel {

    /**
     * 首页
     * @param callBack
     */
    @Override
    public void getHomeData(MyCallBack<HomeDataBean> callBack) {
        HttpFactory.create().get(Urls.HOMEURLALL, null, callBack);

    }

    /**
     * 首页-- 精彩一刻
     * @param callBack
     */
    @Override
    public void getWinderfulData(MyCallBack<HomeCCTVBean> callBack) {
        HttpFactory.create().get(Urls.ORIGINALNEWS, null, callBack);
    }



    public void getWinderfulTwo(String url,MyCallBack<HomeCCTVBean> callBack) {
        HttpFactory.create().get(url, null, callBack);
    }




    @Override
    public void getRollVideoData(MyCallBack<RollRollVideoBean> callBack) {
        HttpFactory.create().get(Urls.ROLLVIDEO, null, callBack);

    }

    @Override
    public void getLiveData(MyCallBack<LiveChinaBean> callBack) {
        HttpFactory.create().get(Urls.LIVECHINAURL, null, callBack);
    }


    @Override
    public void getPandaBroadData(String path, String primaryId, String serviceId, MyCallBack<PandaBroadBean> callBack) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("path", path);
        params.put("primaryId", primaryId);
        params.put("serviceId", serviceId);
        HttpFactory.create().get(Urls.PANDAREPORT, params, callBack);
    }

    @Override
    public void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack) {
        HttpFactory.create().get(Urls.PANDAREPORTTWO, null, callBack);
    }


    @Override
    public void getMultiData(MyCallBack<MultiBean> callBack) {
        HttpFactory.create().get(Urls.MULITANGLE, null, callBack);
    }

    @Override
    public void getHomeVideoData(MyCallBack<HomeVideoBean> callBack) {
        HttpFactory.create().get(Urls.HOMEVIDEOURL, null, callBack);
    }

    @Override
    public void getOriginalData(MyCallBack<OriginalBean> callback) {
        HttpFactory.create().get(Urls.ORIGINAL, null, callback);
    }

    @Override
    public void getBaDaLingData(MyCallBack<BaDaLingBean> callBack) {
        HttpFactory.create().get(Urls.BADALING, null, callBack);
    }




    @Override
    public void getPandaLiveData(MyCallBack<PandaLiveBean> callBack) {
        HttpFactory.create().get(Urls.PANDALIVE, null, callBack);
    }

    @Override
    public void getTablelistData(MyCallBack<TableListBaen> callBack) {
        HttpFactory.create().get(Urls.TABLELIST, null, callBack);
    }

    @Override
    public void getPandaFragmentlistData(Map<String, String> map, MyCallBack<PandaFragmentlistData> callBack) {
        HttpFactory.create().get(Urls.PANDAFRAGMENTDATA, map, callBack);
    }

    @Override
    public void getSidelookSidechattData(Map<String, String> map, MyCallBack<SidelookBean> callBack) {
        HttpFactory.create().get(Urls.SISDELOOK, map, callBack);
    }

    @Override
    public void getLiveListData(Map<String, String> map, MyCallBack<LiveListBean> liveListBean) {
        HttpFactory.create().get(Urls.LIVEURL, map, liveListBean);
    }

    @Override
    public void getLoginData(String username, String password, String service, String from, MyCallBack<LoginBean> myCallBack) {
        Map<String, String> params = new HashMap<>();
        params.put("username",username);
        params.put("password", password);
        params.put("service", service);
        params.put("from", from);
        Log.e( "getLoginData: ",params.toString());
        HttpFactory.create().post(Urls.LOGIN,params,myCallBack);
    }

    @Override
    public void getRollMoveXQ(String from, MyCallBack<LoginBean> myCallBack) {

    }


}
