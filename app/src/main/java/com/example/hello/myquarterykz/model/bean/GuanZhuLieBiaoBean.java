package com.example.hello.myquarterykz.model.bean;

import java.util.List;

/**
 * Created by 韦作铭 on 2018/4/11.
 */

public class GuanZhuLieBiaoBean {


    /**
     * code : 0
     * data : [{"appkey":"fa1bbff38973841c","appsecret":
     * "84FF7867610DD5A445F6FF12FEF6A614","createtime":"
     * 2018-01-08T20:46:02","mobile":"15915901230","password"
     * :"D2E9147BAB5C31A2EEAE227DCD791F26","token":"50CF523D92C
     * 4C5E968EBAE32A3A78F9B","uid":11200,"username":"15915901230"},{"createtime":"2018-02-07T14:19:22","gender":0,"icon":"https://www.zhaoapi.cn/images/15180898848441518089884704.png","mobile":"13775854299","money":0,"nickname":"我是你爸爸","password":"123123","token":"2169FEE6F3AC42D662EFF44250A0BD87","uid":100,"username":"13775854299"},{"createtime":"2017-10-08T16:42:35","gender":0,"mobile":"13846613941","money":0,"password":"123456","uid":111,"username":"13846613941"},{"createtime":"2017-10-08T16:41:23","gender":0,"mobile":"13846609630","money":0,"nickname":"213","password":"123456","uid":110,"username":"13846609630"},{"createtime":"2017-10-10T08:44:35","gender":0,"mobile":"15678945236","money":0,"password":"123569","uid":116,"username":"15678945236"},{"createtime":"2017-10-10T09:04:38","gender":0,"mobile":"17888888888","money":0,"password":"777777","uid":120,"username":"17888888888"},{"createtime":"2017-09-29T10:28:02","gender":0,"mobile":"18610463511","money":0,"password":"123456","uid":78,"username":"18610463511"},{"createtime":"2018-01-25T16:25:22","gender":0,"icon":"https://www.zhaoapi.cn/images/88.jpg","mobile":"13716792264","money":0,"nickname":"解杰 ","password":"111111","token":"80228EFBFC03F309AF88913FDD074A2B","uid":88,"username":"13716792264"}]
     * msg : 获取关注用户列表成功
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appkey : fa1bbff38973841c
         * appsecret : 84FF7867610DD5A445F6FF12FEF6A614
         * createtime : 2018-01-08T20:46:02
         * mobile : 15915901230
         * password : D2E9147BAB5C31A2EEAE227DCD791F26
         * token : 50CF523D92C4C5E968EBAE32A3A78F9B
         * uid : 11200
         * username : 15915901230
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/15180898848441518089884704.png
         * money : 0
         * nickname : 我是你爸爸
         */

        private String appkey;
        private String appsecret;
        private String createtime;
        private String mobile;
        private String password;
        private String token;
        private int uid;
        private String username;
        private int gender;
        private String icon;
        private int money;
        private String nickname;

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
