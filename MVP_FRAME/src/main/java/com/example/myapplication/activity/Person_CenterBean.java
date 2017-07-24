package com.example.myapplication.activity;

/**
 * Created by Pang on 2017/7/24.
 */

public class Person_CenterBean {

    /**
     * code : 0
     * content : {"nickname":"假斯文x","userface":"http://userface.img.cctvpic.com/80x80/161/593/43941176.jpg"}
     */

    private int code;
    private ContentBean content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * nickname : 假斯文x
         * userface : http://userface.img.cctvpic.com/80x80/161/593/43941176.jpg
         */

        private String nickname;
        private String userface;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserface() {
            return userface;
        }

        public void setUserface(String userface) {
            this.userface = userface;
        }
    }
}
