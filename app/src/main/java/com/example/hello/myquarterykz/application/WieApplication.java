package com.example.hello.myquarterykz.application;


import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


public class WieApplication extends Application {
    private static int myTid;
    private static Handler handler;
    private static Context context;
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac"
                ,"5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468"
                , "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954"
                , "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
    }
    private static int width;
    private static int height;
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        Fresco.initialize(this);
        MobSDK.init(this);
        getDeviceHeightAndWidth();
        myTid = Process.myTid();
        handler = new Handler();
        context = getApplicationContext();

        UMShareAPI.get(this);
    }

    public void getDeviceHeightAndWidth() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        // 屏幕宽度（像素）
        width = dm.widthPixels;
        // 屏幕高度（像素）
        height = dm.heightPixels;

    }

    public static int getDeviceWidth(){
        return width;
    }

    public static int getDeviceHeight(){
        return height;
    }
    //获取主线程的id
    public static int getMainThreadId() {

        return myTid;
    }

    //获取handler
    public static Handler getAppHanler() {
        return handler;
    }

    public static Context getAppContext() {
        return context;
    }

}
