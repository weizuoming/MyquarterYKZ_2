package com.example.hello.myquarterykz.presenter.inter;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/9.
 */

public interface PresenterPort {
    void getResponse(ResponseBody responseBody);
    void getResponseBodyBean(ResponseBody responseBody);
    void getError(Throwable throwable);

    void getUrl(Observable<ResponseBody> responseBodyObservable);
    void setJieYue();
}
