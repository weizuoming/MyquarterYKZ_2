package com.example.hello.myquarterykz.model;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/9.
 */

public interface ModelPort {
    void getUrl(Observable<ResponseBody> responseBodyObservable);
    void setJieYue();
}
