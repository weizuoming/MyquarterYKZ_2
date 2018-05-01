package com.example.hello.myquarterykz.model.bean;

import java.util.List;

/**
 * Created by 韦作铭 on 2018/4/22.
 */

public class TuiJianHaoYouBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"a5cd1d5f8a9075b5","appsecret":"F11D9DFBD4A97F16355EBF0FB48F5BB2","createtime":"2017-12-06T10:43:04","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18954521564","money":null,"nickname":null,"password":"8599ADBF21B90F09CDCF6C307DE46C9D","praiseNum":null,"token":null,"uid":3512,"userId":null,"username":"18954521564"},{"age":null,"appkey":"e3e5242ba1097ad8","appsecret":"C992C0965B6B97123C85F3D7EAC9FC80","createtime":"2017-12-06T10:43:26","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18101323211","money":null,"nickname":null,"password":"5A5D8D2ED9C080A1DBD82F6FEAE08146","praiseNum":null,"token":null,"uid":3513,"userId":null,"username":"18101323211"},{"age":null,"appkey":"27c8f0e73f4d7f48","appsecret":"C0B68528DDE09AA71A4CCA3CA2C81DD4","createtime":"2017-12-06T10:46:00","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17756564848","money":null,"nickname":null,"password":"6420B3D38CD1434940C20B009039DE12","praiseNum":null,"token":null,"uid":3514,"userId":null,"username":"17756564848"},{"age":null,"appkey":"51dc719c4a9f565a","appsecret":"732C8C71B375E3F593254790960E6028","createtime":"2018-03-09T19:01:18","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/15180787221761518074829587.jpg","latitude":null,"longitude":null,"mobile":"13552663511","money":null,"nickname":"可望不可即","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"A5C6C455395AE3C668E856D2D69B785B","uid":3515,"userId":null,"username":"13552663511"},{"age":null,"appkey":"ba274ae7f413e864","appsecret":"280B9BF3C59BA0C6C35D0FCE99A27E38","createtime":"2017-12-06T10:56:33","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17798984546","money":null,"nickname":null,"password":"DA84B3AB33AF00149B904B5758871BB6","praiseNum":null,"token":null,"uid":3516,"userId":null,"username":"17798984546"},{"age":null,"appkey":"3a77ca4fcf9eca57","appsecret":"D880740D8580BC1DE64AA1DE4B95A77D","createtime":"2017-12-06T14:05:58","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13169133880","money":null,"nickname":null,"password":"F2F8EBB5C08EAECBCE31D11AE15C31E8","praiseNum":null,"token":"8134E0A77498965002BBD430FB523954","uid":3517,"userId":null,"username":"13169133880"},{"age":null,"appkey":"633e6817b508b84d","appsecret":"70A94148C34803F9C107EEE070E65975","createtime":"2017-12-06T10:59:24","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18639386597","money":null,"nickname":null,"password":"2AE68505A1EFB2A8478DADA0C436D154","praiseNum":null,"token":null,"uid":3518,"userId":null,"username":"18639386597"},{"age":null,"appkey":"d3473501d1b771eb","appsecret":"C7487C8B1DEB70E3E4FCDA1E0F70096E","createtime":"2017-12-06T11:00:06","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13552963511","money":null,"nickname":null,"password":"7D419B994DA000A63846A1C5D3F9CF98","praiseNum":null,"token":null,"uid":3519,"userId":null,"username":"13552963511"},{"age":null,"appkey":"2a830a02c0718147","appsecret":"7D395E115B85BF7DE6BD3D928F6CD3A0","createtime":"2017-12-06T11:00:42","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17785854546","money":null,"nickname":null,"password":"76BAAA486335E60FC1562496679C37B5","praiseNum":null,"token":null,"uid":3520,"userId":null,"username":"17785854546"},{"age":null,"appkey":"ebd85daa0f1749c5","appsecret":"EEDD31613D4D88801D56721162C5999B","createtime":"2017-12-06T11:07:37","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13020053498","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3521,"userId":null,"username":"13020053498"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : a5cd1d5f8a9075b5
         * appsecret : F11D9DFBD4A97F16355EBF0FB48F5BB2
         * createtime : 2017-12-06T10:43:04
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 18954521564
         * money : null
         * nickname : null
         * password : 8599ADBF21B90F09CDCF6C307DE46C9D
         * praiseNum : null
         * token : null
         * uid : 3512
         * userId : null
         * username : 18954521564
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

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

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
