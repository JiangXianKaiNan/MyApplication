package com.example.myapplication.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 2017/7/20.
 */

public class PandaFragmentlistData {


    /**
     * videoset : {"0":{"vsid":"VSET100340574858","relvsid":"","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""},"count":"10"}
     * video : [{"vsid":"VSET100340574858","order":"3","vid":"b3728776392e4368b7f164d22eb714c6","t":"《熊猫档案》 20170518 成长外挂第一期：一位靠睡觉就能赢得万千宠爱的网红主播","url":"http://tv.cntv.cn/video/VSET100340574858/b3728776392e4368b7f164d22eb714c6","ptime":"2017-05-18 15:07:00","img":"http://p2.img.cctvpic.com/fmspic/2017/05/18/b3728776392e4368b7f164d22eb714c6-129.jpg","len":"00:04:06","em":"CM01"},{"vsid":"VSET100340574858","order":"2","vid":"c41c6a0c10e44644a851eda8fc531711","t":"《熊猫档案》 20170511 认猫插件第一期：\u201c成实\u201d变黑了，我们不怕认不出！","url":"http://tv.cntv.cn/video/VSET100340574858/c41c6a0c10e44644a851eda8fc531711","ptime":"2017-05-11 11:07:47","img":"http://p1.img.cctvpic.com/fmspic/2017/05/11/c41c6a0c10e44644a851eda8fc531711-129.jpg","len":"00:04:20","em":"CM01"},{"vsid":"VSET100340574858","order":"1","vid":"b14fe7bd962b4b0b94da92a3b16beef3","t":"《熊猫档案》 20170504 失传已久的熊猫秘籍","url":"http://tv.cntv.cn/video/VSET100340574858/b14fe7bd962b4b0b94da92a3b16beef3","ptime":"2017-05-04 19:49:33","img":"http://p1.img.cctvpic.com/fmspic/2017/05/04/b14fe7bd962b4b0b94da92a3b16beef3-129.jpg","len":"00:04:30","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100340574858","relvsid":"","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""}
         * count : 10
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100340574858
             * relvsid :
             * name : 熊猫档案
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100340574858
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj :
             * sbpd : 其他
             * desc : 请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100340574858
         * order : 3
         * vid : b3728776392e4368b7f164d22eb714c6
         * t : 《熊猫档案》 20170518 成长外挂第一期：一位靠睡觉就能赢得万千宠爱的网红主播
         * url : http://tv.cntv.cn/video/VSET100340574858/b3728776392e4368b7f164d22eb714c6
         * ptime : 2017-05-18 15:07:00
         * img : http://p2.img.cctvpic.com/fmspic/2017/05/18/b3728776392e4368b7f164d22eb714c6-129.jpg
         * len : 00:04:06
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        @Override
        public String toString() {
            return "VideoBean{" +
                    "vsid='" + vsid + '\'' +
                    ", order='" + order + '\'' +
                    ", vid='" + vid + '\'' +
                    ", t='" + t + '\'' +
                    ", url='" + url + '\'' +
                    ", ptime='" + ptime + '\'' +
                    ", img='" + img + '\'' +
                    ", len='" + len + '\'' +
                    ", em='" + em + '\'' +
                    '}';
        }
    }
}
