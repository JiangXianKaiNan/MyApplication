package com.example.myapplication.module.livechina;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名称:
 * 类描述:
 * 创建人:lenovo
 * 创建时间:2017/7/24
 * 修改人:
 * 修改内容:
 */
public class LiveSLV {

    /**
     * ack : yes
     * lc : {"isp_code":"1","city_code":"","provice_code":"BJ","country_code":"CN","ip":"115.171.131.71"}
     * client_sid : a7ff6136-7107-11e7-ab40-00505689bbd9
     * flv_cdn_info : {"cdn_code":"LIVE-FLV-CDN-CNC","cdn_name":"3rdFLV网宿"}
     * flv_url : {"flv1":"","flv2":"http://3811.liveplay.myqcloud.com/live/flv/3811_channel1069.flv?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==","flv3":"","flv4":"","flv5":"http://cctv1.vtime.cntv.cloudcdn.net/cache/14_/channel.pub?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==","flv6":""}
     * hls_cdn_info : {"cdn_code":"LIVE-HLS-CDN-CNC","cdn_name":"3rdHLS网宿"}
     * hls_url : {"hls1":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==","hls2":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==","hls3":"","hls4":"http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==","hls5":"","hls6":""}
     * public : 1
     */

    private String ack;
    private LcBean lc;
    private String client_sid;
    private FlvCdnInfoBean flv_cdn_info;
    private FlvUrlBean flv_url;
    private HlsCdnInfoBean hls_cdn_info;
    private HlsUrlBean hls_url;
    @SerializedName("public")
    private String publicX;

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public FlvCdnInfoBean getFlv_cdn_info() {
        return flv_cdn_info;
    }

    public void setFlv_cdn_info(FlvCdnInfoBean flv_cdn_info) {
        this.flv_cdn_info = flv_cdn_info;
    }

    public FlvUrlBean getFlv_url() {
        return flv_url;
    }

    public void setFlv_url(FlvUrlBean flv_url) {
        this.flv_url = flv_url;
    }

    public HlsCdnInfoBean getHls_cdn_info() {
        return hls_cdn_info;
    }

    public void setHls_cdn_info(HlsCdnInfoBean hls_cdn_info) {
        this.hls_cdn_info = hls_cdn_info;
    }

    public HlsUrlBean getHls_url() {
        return hls_url;
    }

    public void setHls_url(HlsUrlBean hls_url) {
        this.hls_url = hls_url;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public static class LcBean {
        /**
         * isp_code : 1
         * city_code :
         * provice_code : BJ
         * country_code : CN
         * ip : 115.171.131.71
         */

        private String isp_code;
        private String city_code;
        private String provice_code;
        private String country_code;
        private String ip;

        public String getIsp_code() {
            return isp_code;
        }

        public void setIsp_code(String isp_code) {
            this.isp_code = isp_code;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getProvice_code() {
            return provice_code;
        }

        public void setProvice_code(String provice_code) {
            this.provice_code = provice_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }

    public static class FlvCdnInfoBean {
        /**
         * cdn_code : LIVE-FLV-CDN-CNC
         * cdn_name : 3rdFLV网宿
         */

        private String cdn_code;
        private String cdn_name;

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class FlvUrlBean {
        /**
         * flv1 :
         * flv2 : http://3811.liveplay.myqcloud.com/live/flv/3811_channel1069.flv?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==
         * flv3 :
         * flv4 :
         * flv5 : http://cctv1.vtime.cntv.cloudcdn.net/cache/14_/channel.pub?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==
         * flv6 :
         */

        private String flv1;
        private String flv2;
        private String flv3;
        private String flv4;
        private String flv5;
        private String flv6;

        public String getFlv1() {
            return flv1;
        }

        public void setFlv1(String flv1) {
            this.flv1 = flv1;
        }

        public String getFlv2() {
            return flv2;
        }

        public void setFlv2(String flv2) {
            this.flv2 = flv2;
        }

        public String getFlv3() {
            return flv3;
        }

        public void setFlv3(String flv3) {
            this.flv3 = flv3;
        }

        public String getFlv4() {
            return flv4;
        }

        public void setFlv4(String flv4) {
            this.flv4 = flv4;
        }

        public String getFlv5() {
            return flv5;
        }

        public void setFlv5(String flv5) {
            this.flv5 = flv5;
        }

        public String getFlv6() {
            return flv6;
        }

        public void setFlv6(String flv6) {
            this.flv6 = flv6;
        }
    }

    public static class HlsCdnInfoBean {
        /**
         * cdn_code : LIVE-HLS-CDN-CNC
         * cdn_name : 3rdHLS网宿
         */

        private String cdn_code;
        private String cdn_name;

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HlsUrlBean {
        /**
         * hls1 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==
         * hls2 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==
         * hls3 :
         * hls4 : http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1069.m3u8?AUTH=7yPkEYnSqsRrrKbJOLm9mQYtVszwVBKt/gGkfFiy2lYug1iNVsAK4tGgBzlPYC9vX5b70dl3EIPvHMmjCRb+PA==
         * hls5 :
         * hls6 :
         */

        private String hls1;
        private String hls2;
        private String hls3;
        private String hls4;
        private String hls5;
        private String hls6;

        public String getHls1() {
            return hls1;
        }

        public void setHls1(String hls1) {
            this.hls1 = hls1;
        }

        public String getHls2() {
            return hls2;
        }

        public void setHls2(String hls2) {
            this.hls2 = hls2;
        }

        public String getHls3() {
            return hls3;
        }

        public void setHls3(String hls3) {
            this.hls3 = hls3;
        }

        public String getHls4() {
            return hls4;
        }

        public void setHls4(String hls4) {
            this.hls4 = hls4;
        }

        public String getHls5() {
            return hls5;
        }

        public void setHls5(String hls5) {
            this.hls5 = hls5;
        }

        public String getHls6() {
            return hls6;
        }

        public void setHls6(String hls6) {
            this.hls6 = hls6;
        }
    }
}
