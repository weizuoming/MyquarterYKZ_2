package com.example.hello.myquarterykz.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.WangJiMiMaBean;
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
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import okhttp3.ResponseBody;

public class WangJiActivity extends AppCompatActivity implements MyView, View.OnClickListener {

    @BindView(R.id.newreg_back)
    ImageView newregBack;

    @BindView(R.id.newxreg_name)
    EditText newxregName;
    @BindView(R.id.newxreg_pwd)
    EditText newxregPwd;
    @BindView(R.id.newxreg_start)
    Button newxregStart;

    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_wang_ji);
        ButterKnife.bind(this);
        sendCode(this);
        presenter = new Presenter(this);
        presenter.attachView(this);
        newregBack.setOnClickListener(this);
        newxregStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newreg_back:
                //跳转返回
//                Intent intent = new Intent(LoginActivity.this, DengLuActivity.class);
//                startActivity(intent);
                finish();
                break;

            case R.id.newxreg_start:
                String regname = newxregName.getText().toString();
                String regPwd = this.newxregPwd.getText().toString();

                if (regname != null && regname != "" & this.newxregPwd != null & regPwd != "") {
                    Map<String, String> map = new HashMap<>();
                    map.put("mobile", regname);
                    map.put("newPass", regPwd);
                    presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.WANGJI_URL, map));
                }

                break;

        }

    }
    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country"); // 国家代码，如“86”
                    String phone = (String) phoneMap.get("phone"); // 手机号码，如“13800138000”
                    // TODO 利用国家代码和手机号码进行后续的操作
                } else {
                    // TODO 处理错误的结果
                }
            }
        });
        page.show(context);
    }
    // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
    public void sendCode(String country, String phone) {
        // 注册一个事件回调，用于处理发送验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                } else {
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.getVerificationCode(country, phone);
    }

    // 提交验证码，其中的code表示验证码，如“1357”
    public void submitCode(String country, String phone, final String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证成功的结果
                } else {
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露
        SMSSDK.unregisterAllEventHandler();
    }
    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            WangJiMiMaBean wangJiMiMaBean = new Gson().fromJson(responseBody
                    .string(), WangJiMiMaBean.class);
            if (wangJiMiMaBean.getCode().equals("0")) {
                Toast.makeText(WangJiActivity
                        .this, wangJiMiMaBean.getMsg(), Toast.LENGTH_LONG).show();
                finish();

            } else {
                Toast.makeText(WangJiActivity
                        .this, wangJiMiMaBean.getMsg(), Toast.LENGTH_LONG).show();
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
