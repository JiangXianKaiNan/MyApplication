package com.example.myapplication.model.bean;

import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 10:59
 * 作 者：T
 * 微信：704003376
 */

public class RollRollVideoBean {

    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean {
        /**
         * url : http://live.ipanda.com/2017/07/17/VIDEOAFXsqji02xgv2Xc6Ulk170717.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/7/18/1500342933188_360.jpg
         * title : 《熊猫TOP榜》有这样的奶爸奶妈，欢乐一夏
         * id : TITE1500342911689862
         * type : 2
         * stype :
         * pid : 3d92fae34dc14b2492de15d5dd122ac8
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String id;
        private String type;
        private String stype;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/07/10/VIDE0PA7dznZ8LEvzD9Dy5DP170710.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/07/10/2017071016490696726.jpg
         * title : 《熊猫TOP榜》
         * brief : 第二季第五期：煤炭兄妹的日常之你抢我抢
         * type : 2
         * videoLength : 04:55
         * id : VSET100284428835
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String brief;
        private String type;
        private String videoLength;
        private String id;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
