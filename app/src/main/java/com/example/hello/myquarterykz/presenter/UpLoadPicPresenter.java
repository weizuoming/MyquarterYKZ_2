package com.example.hello.myquarterykz.presenter;


import com.example.hello.myquarterykz.model.UpLoadPicModel;
import com.example.hello.myquarterykz.model.bean.UpLoadPicBean;
import com.example.hello.myquarterykz.presenter.inter.UpLoadPicPresenterInter;
import com.example.hello.myquarterykz.view.iview.UpLoadActivityInter;

import java.io.File;

/**
 * Created by Dash on 2018/2/23.
 */
public class UpLoadPicPresenter implements UpLoadPicPresenterInter {

    private UpLoadPicModel upLoadPicModel;
    private UpLoadActivityInter upLoadActivityInter;

    public UpLoadPicPresenter(UpLoadActivityInter upLoadActivityInter) {
        this.upLoadActivityInter = upLoadActivityInter;
        upLoadPicModel = new UpLoadPicModel(this);
    }

    public void uploadPic(String uploadIconUrl, File saveIconFile, String uid, String fileName) {

        upLoadPicModel.uploadPic(uploadIconUrl,saveIconFile,uid,fileName);

    }



    @Override
    public void uploadPicSuccess(UpLoadPicBean upLoadPicBean) {
        upLoadActivityInter.uploadPicSuccess(upLoadPicBean);
    }
}
