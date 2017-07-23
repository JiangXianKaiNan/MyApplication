package com.example.myapplication.model.bean;

import java.util.List;

/**
 * 爱生活，爱代码!
 * 项目名称:
 * 类描述:
 * 创建人: LENOVO
 * 创建时间: 2017-7-20 20:22
 * 修改人:
 * 修改内容:
 */

public class HomeCCTVBean {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HomeCCTVBean{" +
                "list=" + list +
                '}';
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/07/19/VIDE76bj4LbusNGTMlOdvKGv170719.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/07/19/2017071911160884970.jpg
         * title : 这自由的感觉
         * videoLength : 00:18
         * id : TITE1500530580653894
         * daytime : 2017-07-20
         * type : 2
         * pid : f31d74a840434da2bd09c86eb33a4b49
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        @Override
        public String toString() {
            return "ListBean{" +
                    "url='" + url + '\'' +
                    ", image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", videoLength='" + videoLength + '\'' +
                    ", id='" + id + '\'' +
                    ", daytime='" + daytime + '\'' +
                    ", type='" + type + '\'' +
                    ", pid='" + pid + '\'' +
                    ", vid='" + vid + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }

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

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
}
