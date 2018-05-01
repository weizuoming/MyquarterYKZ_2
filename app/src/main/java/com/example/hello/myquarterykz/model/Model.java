package com.example.hello.myquarterykz.model;


import com.example.hello.myquarterykz.presenter.inter.PresenterPort;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/9.
 */

public class Model implements ModelPort{
    private PresenterPort presenterPort;
    private Disposable d;
    public Model(PresenterPort presenterPort) {

        this.presenterPort = presenterPort;
    }
    @Override
    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                        Model.this.d = d;
                    }

                    @Override
                    public void onNext(ResponseBody value) {

                        presenterPort.getResponse(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void getUrlBean(Observable<ResponseBody> responseBodyObservable) {
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Model.this.d = d;
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        presenterPort.getResponseBodyBean(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void setJieYue() {
        d.dispose();
    }


}
