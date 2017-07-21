package com.example.myapplication.model.bean;

import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 12:00
 * 作 者：T
 * 微信：704003376
 */

public class PandaBroadTwoBean {

    /**
     * total : 76
     * list : [{"num":1,"datatype":"article","id":"ARTI83fVetdV7IE3UOUTG8ia170720","title":"台北市立动物园宣布大熊猫\u201c圆圆\u201d未能怀孕","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/20/2017072009441044835.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/20/ARTI83fVetdV7IE3UOUTG8ia170720.shtml","focus_date":1500515268000},{"num":2,"datatype":"article","id":"ARTItcuzO0uR0X63OTQTvtZP170719","title":"中国最北熊猫馆周年记：大熊猫花式避暑有\u201c凉方\u201d","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/19/2017071909505876635.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/19/ARTItcuzO0uR0X63OTQTvtZP170719.shtml","focus_date":1500429527000},{"num":3,"datatype":"article","id":"ARTIWJU0kiFFtYrygQ6Onfbm170717","title":"萌翻了！深圳大熊猫\u201c圆舟\u201d过7岁生日，蛋糕独具特色","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/17/2017071709553015104.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/17/ARTIWJU0kiFFtYrygQ6Onfbm170717.shtml","focus_date":1500256580000},{"num":4,"datatype":"article","id":"ARTIbRWtn0sfxCStUMmD9Zbc170715","title":"大熊猫\u201c奇珍\u201d顺利产仔 第六次做妈妈经验十足","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/15/2017071523555282849.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/15/ARTIbRWtn0sfxCStUMmD9Zbc170715.shtml","focus_date":1500134438000},{"num":5,"datatype":"article","id":"ARTI8a0HRkR0LCQP1XRscI1N170714","title":"熊猫宝贝韩国庆生 \u201c帅哥\u201d\u201c淑女\u201d星范儿十足","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/14/2017071410143576479.gif","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/14/ARTI8a0HRkR0LCQP1XRscI1N170714.shtml","focus_date":1499998765000},{"num":6,"datatype":"article","id":"ARTIzo2LgEOKJxoz6USLIdXa170713","title":"大熊猫\u201c娇庆\u201d、\u201c梦梦\u201d在德一切安好","videolength":"","guid":"","picurl":"http://p1.img.cctvpic.com/photoworkspace/2017/07/13/2017071318031746118.jpg","picurl2":"","picurl3":"","url":"http://news.ipanda.com/2017/07/13/ARTIzo2LgEOKJxoz6USLIdXa170713.shtml","focus_date":1499940243000}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * num : 1
         * datatype : article
         * id : ARTI83fVetdV7IE3UOUTG8ia170720
         * title : 台北市立动物园宣布大熊猫“圆圆”未能怀孕
         * videolength :
         * guid :
         * picurl : http://p1.img.cctvpic.com/photoworkspace/2017/07/20/2017072009441044835.jpg
         * picurl2 :
         * picurl3 :
         * url : http://news.ipanda.com/2017/07/20/ARTI83fVetdV7IE3UOUTG8ia170720.shtml
         * focus_date : 1500515268000
         */

        private int num;
        private String datatype;
        private String id;
        private String title;
        private String videolength;
        private String guid;
        private String picurl;
        private String picurl2;
        private String picurl3;
        private String url;
        private long focus_date;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getDatatype() {
            return datatype;
        }

        public void setDatatype(String datatype) {
            this.datatype = datatype;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideolength() {
            return videolength;
        }

        public void setVideolength(String videolength) {
            this.videolength = videolength;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getPicurl2() {
            return picurl2;
        }

        public void setPicurl2(String picurl2) {
            this.picurl2 = picurl2;
        }

        public String getPicurl3() {
            return picurl3;
        }

        public void setPicurl3(String picurl3) {
            this.picurl3 = picurl3;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getFocus_date() {
            return focus_date;
        }

        public void setFocus_date(long focus_date) {
            this.focus_date = focus_date;
        }
    }
}