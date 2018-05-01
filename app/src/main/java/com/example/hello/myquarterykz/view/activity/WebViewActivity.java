package com.example.hello.myquarterykz.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hello.myquarterykz.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private int theme = R.style.AppTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.web_view);

        String detailUrl = getIntent().getStringExtra("detailUrl");

        if (detailUrl != null) {
            webView.loadUrl(detailUrl);

            //webview一系列设置
            webView.setWebViewClient(new WebViewClient());//在当前应用打开,而不是去浏览器
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
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
