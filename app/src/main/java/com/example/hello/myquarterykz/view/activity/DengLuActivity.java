package com.example.hello.myquarterykz.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.myquarterykz.MainActivity;
import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.LoginBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class DengLuActivity extends AppCompatActivity implements MyView,View.OnClickListener {
    @BindView(R.id.login_qq)
    LinearLayout login_by_qq;

    @BindView(R.id.login_weixin)
    LinearLayout login_by_wechat;

    @BindView(R.id.login_back)
    ImageView login_back;

    @BindView(R.id.login_other)
    TextView loginOther;

    public static SharedPreferences namepwd;
    private Presenter presenter;
    private Map<String, String> map;
    private LoginBean loginBean;
    private int theme = R.style.AppTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if(savedInstanceState != null){
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_deng_lu);
        namepwd = getSharedPreferences("namepwd", 0);
        presenter = new Presenter(this);
        presenter.attachView(this);
        ButterKnife.bind(this);
        loginBean = new LoginBean();
        login_back.setOnClickListener(this);
        loginOther.setOnClickListener(this);
        login_by_qq.setOnClickListener(this);
        if ("0".equals(loginBean.getCode())) {
            //登录成功
            //结束当前界面
            finish();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_other:
                //跳转其他登录
                Intent intent = new Intent(DengLuActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.login_weixin://微信登录
                break;
            case R.id.login_qq://qq登录
                UMShareAPI.get(this).getPlatformInfo(DengLuActivity.this
                        , SHARE_MEDIA.QQ, new UMAuthListener() {
                            /**
                             * @desc 授权开始的回调
                             * @param platform 平台名称
                             */
                            @Override
                            public void onStart(SHARE_MEDIA platform) {
                            }
                            /**
                             * @desc 授权成功的回调
                             * @param platform 平台名称
                             * @param action 行为序号，开发者用不上
                             * @param data 用户资料返回
                             */
                            @Override
                            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                                Toast.makeText(DengLuActivity.this, "成功了"
                                        , Toast.LENGTH_LONG).show();
                                Log.d("++++++++++++","id:"+data.get("uid")+",昵称:"+data
                                        .get("name")+",性别："+data.get("gender")
                                        +",头像:"+data.get("iconurl"));
                                Intent intent2 = new Intent(DengLuActivity.this, MainActivity.class);
                                startActivity(intent2);
                            }
                            /**
                             * @desc 授权失败的回调
                             * @param platform 平台名称
                             * @param action 行为序号，开发者用不上
                             * @param t 错误原因
                             */
                            @Override
                            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                                Toast.makeText(DengLuActivity.this
                                        , "失败：" + t.getMessage(),Toast.LENGTH_LONG).show();
                            }
                            /**
                             * @desc 授权取消的回调
                             * @param platform 平台名称
                             * @param action 行为序号，开发者用不上
                             */
                            @Override
                            public void onCancel(SHARE_MEDIA platform, int action) {
                                Toast.makeText(DengLuActivity.this, "取消了"
                                        , Toast.LENGTH_LONG).show();
                            }
                        });


                break;
            case R.id.login_back://返回

                Intent intent2 = new Intent(DengLuActivity.this, MainActivity.class);
                startActivity(intent2);
                break;

        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }

    @Override
    public void getResponse(ResponseBody responseBody) {

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
