package com.example.hello.myquarterykz.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ShouCangLieBiaoBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.adapter.MyShouCangAdapter;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class ShouCangActivity extends AppCompatActivity implements MyView,View.OnClickListener{

    @BindView(R.id.fanhui_shou)
    LinearLayout fanhuiShou;
    @BindView(R.id.recycler_shoucang)
    RecyclerView recyclerShoucang;
    private Map<String, String> map;
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
        if(savedInstanceState != null){
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_shou_cang);
        ButterKnife.bind(this);
        SharedPreferences namepwd = LoginActivity.namepwd;
        if (namepwd != null) {
            String uid = namepwd.getString("uid", "");
            presenter = new Presenter(this);
            map = new HashMap<>();
            map.put("uid", uid);
        }
        fanhuiShou.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fanhui_shou:

                finish();
                break;


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.getUrl(RetrofitUtil
                .setService().doGet(ApiUrl.SHOUCANGYONGHU_URL, map));
    }

    @Override
    public void getResponse(ResponseBody responseBody) {

        try {
//            Log.d("TAG", "--------------------------数据"+responseBody.string());
            ShouCangLieBiaoBean shouCangLieBiaoBean = new Gson().fromJson(responseBody
                    .string(), ShouCangLieBiaoBean.class);
            recyclerShoucang.setLayoutManager(new LinearLayoutManager(this
                    , LinearLayoutManager.VERTICAL, false));
            MyShouCangAdapter adapter = new MyShouCangAdapter(this
                    , shouCangLieBiaoBean);
            recyclerShoucang.setAdapter(adapter);


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
    protected void onDestroy() {
        super.onDestroy();
        presenter.setJieYue();
        if (presenter != null) {
            presenter.detachView();
        }
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
