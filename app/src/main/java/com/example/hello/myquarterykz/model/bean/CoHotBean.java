package com.example.hello.myquarterykz.model.bean;

import java.util.List;

/**
 * Created by 韦作铭 on 2018/4/11.
 */

public class CoHotBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523331608204IMG20170403142449.jpg","createTime":"2018-04-10T11:40:08","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15228089129461522808912953.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523331608204recording-1675724830.mp4","wid":330,"workDesc":"222"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523331571813IMG20170403142449.jpg","createTime":"2018-04-10T11:39:31","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15228089129461522808912953.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523331571813recording-1675724830.mp4","wid":329,"workDesc":"222"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15233312599361522808912953.png","createTime":"2018-04-10T11:34:19","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523331259936recording1569121083.mp4","wid":328,"workDesc":"你猜"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523327073532B612Kaji_20180409_103850.jpg","createTime":"2018-04-10T10:24:33","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523327073532recording-1056398344.mp4","wid":327,"workDesc":"你好啊"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523327053000B612Kaji_20180409_103850.jpg","createTime":"2018-04-10T10:24:13","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523327053000recording-786262650.mp4","wid":326,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/152332687943304_06_2018_12_37_39_4387.png..png","createTime":"2018-04-10T10:21:19","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523326879433recording-1701893937.mp4","wid":325,"workDesc":"你猜"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15232726567481522730795274.png","createTime":"2018-04-09T19:17:36","favoriteNum":0,"latitude":"","localUri":null,"longitude":"","playNum":0,"praiseNum":0,"uid":12400,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15228089129461522808912953.png","nickname":"日出东方","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523272656748recording2094632782.mp4","wid":324,"workDesc":"爱生活 爱学习"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523272609420crop_photo.jpg","createTime":"2018-04-09T19:16:49","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523272609420recording-2135803526.mp4","wid":323,"workDesc":"哈哈"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523272408437head.jpg","createTime":"2018-04-09T19:13:28","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":0,"praiseNum":0,"uid":10160,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522846299621crop_photo.jpg","nickname":"大苏打","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523272408437recording242946233.mp4","wid":322,"workDesc":"奋斗奋斗"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1523263424886截屏_20180409_163842.jpg","createTime":"2018-04-09T16:43:44","favoriteNum":0,"latitude":"69.11","localUri":null,"longitude":"107.02","playNum":0,"praiseNum":0,"uid":3881,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517574153932AndroidFightingIphone3.png","nickname":"我不是杨犊子","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1523263424886猫出来.mp4","wid":321,"workDesc":"你瞅啥？瞅你咋地！"}]
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
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/1523331608204IMG20170403142449.jpg
         * createTime : 2018-04-10T11:40:08
         * favoriteNum : 0
         * latitude :
         * localUri : null
         * longitude :
         * playNum : 0
         * praiseNum : 0
         * uid : 12400
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15228089129461522808912953.png","nickname":"日出东方","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1523331608204recording-1675724830.mp4
         * wid : 330
         * workDesc : 222
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15228089129461522808912953.png
             * nickname : 日出东方
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
