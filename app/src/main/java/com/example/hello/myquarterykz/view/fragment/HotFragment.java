package com.example.hello.myquarterykz.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ReMenShiPinBean;
import com.example.hello.myquarterykz.model.bean.TuiJianLunBoTuBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.adapter.ReMenAdapter;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * 推荐的热门的界面
 * Created by 韦作铭 on 2018/4/10.
 */

public class HotFragment extends Fragment implements MyView {

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Presenter presenter;
    private List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot
                , container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new Presenter(this);
        presenter.attachView(this);
        Map<String, String> map = new HashMap<>();
        map.put("token","session");


        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.HOME_URL,map));
        presenter.getUrlBean(RetrofitUtil.setService().doGet(ApiUrl.REMEN_URL, map));

    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        //截至做
        try {
            //Log.d("++++++lunbo+", responseBody.string());
            TuiJianLunBoTuBean tuiJianLunBoTuBean = new Gson()
                    .fromJson(responseBody.string()
                            , TuiJianLunBoTuBean.class);

            List<TuiJianLunBoTuBean.DataBean> data = tuiJianLunBoTuBean.getData();
            for (TuiJianLunBoTuBean.DataBean d : data) {
                list.add(d.getIcon());
            }
//            banner.setBannerStyle(Banner.AUTOFILL_TYPE_LIST);//设置图片的样式
//            banner.setIndicatorGravity(Banner.CENTER); //设置指示器位置
//            banner.setDelayTime(2000);//间隔时间
//            banner.isAutoPlay(true);//设置自动轮播
//            banner.setImages(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getResponseBodyBean(ResponseBody responseBody) {

        try {
            //Log.d("+++++++", responseBody.string());
            ReMenShiPinBean reMenShiPinBean = new Gson().fromJson(responseBody
                    .string(), ReMenShiPinBean.class);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
                    ,LinearLayoutManager.VERTICAL,false));

            ReMenAdapter adapter = new ReMenAdapter(getActivity(), reMenShiPinBean);
            recyclerView.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getError(Throwable throwable) {

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.setJieYue();
        if (presenter != null) {
            presenter.detachView();
        }
        unbinder.unbind();

    }
}
