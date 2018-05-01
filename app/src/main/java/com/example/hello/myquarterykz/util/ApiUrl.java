package com.example.hello.myquarterykz.util;

/**
 * Created by 韦作铭 on 2018/4/11.
 */

public class ApiUrl {
    //公共
    public static final String BASE_URL = "https://www.zhaoapi.cn/";
    //轮播
    public static final String HOME_URL ="quarter/getAd";
    //热门
    public static final String REMEN_URL ="quarter/getHotVideos";
    //关注
//    970CD20FEE089D8EE245065DC0BCDA97
    public static final String GUANZHU_URL ="quarter/follow";
    //关注
    public static final String GUANZHUYONGHU_URL = "quarter/getFollowUsers";

    //上传头像
    public static final String SHANGCHUANTOUXIANG_URL=BASE_URL+"file/upload";
    //收藏
    public static final String SHOUCANGYONGHU_URL = "quarter/getFavorites";
    //登录
    public static final String LOGIN_URL = "user/login";
    //注册
    public static final String ZHUCE_URL = "user/reg";
    //修改密码
    public static final String XIUGAI_URL = "quarter/resetPass";
    //忘记密码
    public static final String WANGJI_URL = "quarter/getPass";
    //段子
    public static final String DUANZI_URL = "quarter/getJokes";
//     ?source=android&appVersion=101
    public static final String SHIPINREMEN_URL="quarter/getHotVideos";
    public static final String SHIPINREMENXIANGQING_URL="quarter/getVideoDetail";
    public static final String SHIPINFUJIN_url="quarter/getNearVideos";
//    https://www.zhaoapi.cn/user/getUserInfo
//    获取用户信息
    public static final String USERINFO_URL="user/getUserInfo";
    public static final String USERINFO_URL2=BASE_URL+"user/getUserInfo";
    //推荐搜索好友
    public static final String TUIJIANHAOYOU="quarter/randomFriends";
    //搜索好友
    public static final String SOUSUOHAOYOU="quarter/searchFriends";
}
