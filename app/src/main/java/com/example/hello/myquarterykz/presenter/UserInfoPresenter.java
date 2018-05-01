package com.example.hello.myquarterykz.presenter;


import com.example.hello.myquarterykz.model.UserInfoModel;
import com.example.hello.myquarterykz.model.bean.UserInfoBean;
import com.example.hello.myquarterykz.presenter.inter.UserInfoPresenterInter;
import com.example.hello.myquarterykz.view.iview.UserInforInter;

/**
 * Created by Dash on 2018/2/23.
 */
public class UserInfoPresenter implements UserInfoPresenterInter {

    private final UserInfoModel userInfoModel;
    private final UserInforInter userInforInter;

    public UserInfoPresenter(UserInforInter userInforInter) {
        this.userInforInter = userInforInter;
        userInfoModel = new UserInfoModel(this);
    }

    public void getUserInfo(String userInfoUrl, String uid) {

        userInfoModel.getUserInfo(userInfoUrl,uid);

    }

    @Override
    public void onUserInfoSUccess(UserInfoBean userInfoBean) {
        userInforInter.onUserInforSuccess(userInfoBean);
    }
}
