package com.example.hello.myquarterykz.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ZhuCeBean;
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

public class ZhuCeActivity extends AppCompatActivity implements MyView,View.OnClickListener{

    @BindView(R.id.reg_zback)
    ImageView regZback;
    @BindView(R.id.reg_zname)
    EditText regZname;
    @BindView(R.id.reg_zpwd)
    EditText regZpwd;
    @BindView(R.id.reg_zstart)
    Button regzStart;
    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        presenter.attachView(this);
        regZback.setOnClickListener(this);
        regzStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_back:
                //跳转返回
//                Intent intent = new Intent(LoginActivity.this, DengLuActivity.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.reg_zstart:
                String regname = regZname.getText().toString();
                String regPwd = this.regZpwd.getText().toString();

                if (regname != null && regname != "" & this.regZpwd != null & regPwd != "") {
                    Map<String, String> map = new HashMap<>();
                    map.put("mobile", regname);
                    map.put("password", regPwd);
                    presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.ZHUCE_URL, map));
                }

                break;

        }
    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            ZhuCeBean zhuCeBean = new Gson().fromJson(responseBody
                    .string(), ZhuCeBean.class);
            if (zhuCeBean.getCode().equals("0")) {
                Toast.makeText(ZhuCeActivity
                        .this, zhuCeBean.getMsg(), Toast.LENGTH_LONG).show();
//                SharedPreferences.Editor edit = namepwd.edit();
//                edit.putString("uid", String.valueOf(loginBean.getData().getUid()));
//                edit.putString("name", loginBean.getData().getMobile());
//                edit.putString("pwd", loginBean.getData().getPassword());
//                edit.putString("token", loginBean.getData().getToken());
//                //Log.d("TAG", "--------------------------token"+loginBean.getData().getToken());
//                edit.commit();

//                Intent intent2 = new Intent(ZhuCeActivity
//                        .this, MainActivity.class);
//                startActivity(intent2);
                finish();

            } else {
                Toast.makeText(ZhuCeActivity
                        .this, zhuCeBean.getMsg(), Toast.LENGTH_LONG).show();
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
}
