package com.example.hello.myquarterykz.application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by 韦作铭 on 2018/4/27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 默认设置为日间模式
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }
}
