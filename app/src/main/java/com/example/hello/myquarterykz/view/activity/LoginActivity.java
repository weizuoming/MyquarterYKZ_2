package com.example.hello.myquarterykz.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.myquarterykz.MainActivity;
import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.LoginBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class LoginActivity extends AppCompatActivity implements MyView, View.OnClickListener {

    @BindView(R.id.reg_back)
    ImageView regBack;
    @BindView(R.id.reg_or)
    TextView regOr;
    @BindView(R.id.reg_black)
    ImageView regBlack;
    @BindView(R.id.reg_name)
    EditText reg_name;
    @BindView(R.id.reg_pwd)
    EditText reg_Pwd;
    @BindView(R.id.reg_start)
    Button regStart;
    @BindView(R.id.reg_youke)
    TextView regYouke;


    @BindView(R.id.reg_wangji)
    TextView regWangji;
    public static SharedPreferences namepwd;
    private Presenter presenter;
    private int theme = R.style.AppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);

        namepwd = getSharedPreferences("namepwd", 0);
        presenter = new Presenter(this);
        presenter.attachView(this);
        regBack.setOnClickListener(this);
        regStart.setOnClickListener(this);
        regBack.setOnClickListener(this);
        regWangji.setOnClickListener(this);
        regOr.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg_back:
                //跳转返回
//                Intent intent = new Intent(LoginActivity.this, DengLuActivity.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.reg_or:
                //跳转返回
                Intent intent = new Intent(LoginActivity.this, ZhuCeActivity.class);
                startActivity(intent);

                break;
            case R.id.reg_start:
                String regname = reg_name.getText().toString();
                String regPwd = this.reg_Pwd.getText().toString();

                if (regname != null && regname != "" & this.reg_Pwd != null & regPwd != "") {
                    Map<String, String> map = new HashMap<>();
                    map.put("mobile", regname);
                    map.put("password", regPwd);
                    presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.LOGIN_URL, map));
                }

                break;
            case R.id.reg_wangji:
                //跳转返回

                startActivity(new Intent(LoginActivity.this, WangJiActivity.class));
                break;
        }
    }


    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            LoginBean loginBean = new Gson().fromJson(responseBody
                    .string(), LoginBean.class);
            if (loginBean.getCode().equals("0")) {
                Toast.makeText(LoginActivity
                        .this, loginBean.getMsg(), Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edit = namepwd.edit();
                edit.putString("uid", String.valueOf(loginBean.getData().getUid()));
                edit.putString("name", loginBean.getData().getMobile());
                edit.putString("pwd", loginBean.getData().getPassword());
                edit.putString("token", loginBean.getData().getToken());
                //Log.d("TAG", "--------------------------token"+loginBean.getData().getToken());
                edit.commit();

                Intent intent2 = new Intent(LoginActivity
                        .this, MainActivity.class);
                startActivity(intent2);
                finish();

            } else {
                Toast.makeText(LoginActivity
                        .this, loginBean.getMsg(), Toast.LENGTH_LONG).show();
            }
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
