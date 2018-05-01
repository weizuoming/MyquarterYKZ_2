package com.example.hello.myquarterykz.view.iview;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/9.
 */

public interface MyView {
    void getResponse(ResponseBody responseBody);
    void getResponseBodyBean(ResponseBody responseBody);
    void getError(Throwable throwable);
   // void initData(ResponseBody responseBody);

}
