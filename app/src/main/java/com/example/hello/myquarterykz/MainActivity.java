package com.example.hello.myquarterykz;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hello.myquarterykz.model.bean.UserInfoBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.activity.DengLuActivity;
import com.example.hello.myquarterykz.view.activity.GuanZhuActivity;
import com.example.hello.myquarterykz.view.activity.ShouCangActivity;
import com.example.hello.myquarterykz.view.activity.SouSuoActivity;
import com.example.hello.myquarterykz.view.activity.UserInfoActivity;
import com.example.hello.myquarterykz.view.activity.XiaoXiActivity;
import com.example.hello.myquarterykz.view.fragment.CommendFragment;
import com.example.hello.myquarterykz.view.fragment.JokesFragment;
import com.example.hello.myquarterykz.view.fragment.VideoFragment;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements MyView, View.OnClickListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerlayout;
    @BindView(R.id.drawer_relative)
    RelativeLayout relativeLayout;

    @BindView(R.id.title_head)
    SimpleDraweeView roundImageView;
    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.guanzhu)
    LinearLayout guanzhu;
    @BindView(R.id.text_name_c)
    TextView text_name_c;
    @BindView(R.id.shoucang)
    LinearLayout shoucang;
    @BindView(R.id.sousuo)
    LinearLayout sousuo;
    @BindView(R.id.xiaoxi)
    LinearLayout xiaoxi;
    @BindView(R.id.image_touxiangdeng)
    SimpleDraweeView imageTouxiangdeng;
    @BindView(R.id.ye)
    LinearLayout ye;
    private int theme = R.style.AppTheme;
    @BindView(R.id.yejian)
    RadioButton yejian;
    private String uid;
    private String name;
    private String pwd;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    title_tv.setText("推荐");
                    CommendFragment commendFragment = new CommendFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, commendFragment).commit();
//                    Log.d("TAG", "onCreate: ++++++++++++222222+++++++++++++2");
                    return true;
                case R.id.navigation_dashboard:
                    title_tv.setText("段子");
                    JokesFragment jokesFragment = new JokesFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, jokesFragment).commit();

                    return true;
                case R.id.navigation_notifications:
                    title_tv.setText("视频");
                    VideoFragment videoFragment = new VideoFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, videoFragment).commit();

                    return true;
            }
            return false;
        }
    };
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        SharedPreferences namepwd = DengLuActivity.namepwd;
        if (namepwd != null) {
            uid = namepwd.getString("uid", "");
            name = namepwd.getString("name", "");
            pwd = namepwd.getString("pwd", "");
            //Log.d("+11111+++++++++",uid+"");
        }
        if (uid == null || uid == "") {
            imageTouxiangdeng.setImageURI("http://p3.so.qhmsg" +
                    ".com/bdr/_240_/t0128ad386036905648.jpg");
            roundImageView.setImageURI("http://p3.so.qhmsg" +
                    ".com/bdr/_240_/t0128ad386036905648.jpg");
        }

        guanzhu.setOnClickListener(this);
        sousuo.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        xiaoxi.setOnClickListener(this);
        imageTouxiangdeng.setOnClickListener(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CommendFragment commendFragment = new CommendFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, commendFragment).commit();
        roundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(relativeLayout);
            }
        });
        ye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO
                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                recreate();
            }
        });
        drawerlayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            /**
             *
             * @param drawerView
             * @param slideOffset 表示的抽屉拖出来的宽度,,像素值
             */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            /**
             * 抽屉打开了
             * @param drawerView
             */
            @Override
            public void onDrawerOpened(View drawerView) {
            }

            /**
             * 抽屉关闭
             * @param drawerView
             */
            @Override
            public void onDrawerClosed(View drawerView) {

            }

            /**
             * 抽屉的状态改变
             *
             * idle -- 表示与导航视图没有交互,静止
             dragging -- 表示目前有与导航视图的交互,拖拽的状态
             settling -- 表示有与导航视图的交互，并且导航视图正在关闭或打开
             * @param newState
             */
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i("zhaungtai---", newState + "---");
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (uid != null && uid != "") {
            presenter = new Presenter(this);
            presenter.attachView(this);
            Map<String, String> map = new HashMap<>();
            map.put("uid", uid);
            presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.USERINFO_URL, map));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guanzhu:
                startActivity(new Intent(MainActivity.this,
                        GuanZhuActivity.class));
                break;
            case R.id.shoucang:
                startActivity(new Intent(MainActivity.this,
                        ShouCangActivity.class));
                break;
            case R.id.sousuo:
                startActivity(new Intent(MainActivity.this,
                        SouSuoActivity.class));
                break;
            case R.id.xiaoxi:
                startActivity(new Intent(MainActivity.this,
                        XiaoXiActivity.class));
                break;
            case R.id.image_touxiangdeng:
                if (uid == null || uid == "") {
                    startActivity(new Intent(MainActivity.this,
                            DengLuActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this,
                            UserInfoActivity.class));
                }

                break;
//            case R.id.yejian:
//                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
//                getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO
//                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
//                // 同样需要调用recreate方法使之生效
//                recreate();
//
//                break;

        }
    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            UserInfoBean yongHuXinXiBean = new Gson()
                    .fromJson(responseBody.string(), UserInfoBean.class);
            UserInfoBean.DataBean data = yongHuXinXiBean.getData();

            imageTouxiangdeng.setImageURI(String.valueOf(data.getIcon()));
            roundImageView.setImageURI(String.valueOf(data.getIcon()));
            text_name_c.setText(data.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {

    }

    @Override
    public void getError(Throwable throwable) {

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }
}
