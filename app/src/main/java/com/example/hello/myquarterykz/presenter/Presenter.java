package com.example.hello.myquarterykz.presenter;


import com.example.hello.myquarterykz.model.Model;
import com.example.hello.myquarterykz.presenter.inter.PresenterPort;
import com.example.hello.myquarterykz.view.iview.MyView;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/9.
 */

public class Presenter extends BasePresenter implements PresenterPort {
    private MyView myView;
    private final Model model;

    public Presenter(MyView myView) {
        model = new Model(this);
        this.myView = myView;
    }



    @Override
    public void getResponse(ResponseBody responseBody) {
        myView.getResponse(responseBody);
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {
        myView.getResponseBodyBean(responseBody);
    }

    @Override
    public void getError(Throwable throwable) {
        myView.getError(throwable);
    }
    @Override
    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        model.getUrl(responseBodyObservable);
    }



    @Override
    public void setJieYue() {
        model.setJieYue();
    }

    public void getUrlBean(Observable<ResponseBody> responseBodyObservable) {
        model.getUrlBean(responseBodyObservable);
    }
}
