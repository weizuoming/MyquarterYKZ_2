package com.example.hello.myquarterykz.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ReMenBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.adapter.ShiPinAdapter;
import com.example.hello.myquarterykz.view.iview.MyView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/4/13.
 */

public class ShiPinReMenFragment extends Fragment implements MyView {
    @BindView(R.id.recycler_shipin)
    RecyclerView recyclerShipin;
    Unbinder unbinder;
    private Presenter presenter;
    private Map<String, String> map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipinremen
                , container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new Presenter(this);
        presenter.attachView(this);
        map = new HashMap<>();

        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.SHIPINREMEN_URL, map));

    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            ReMenBean reMenBean = new Gson()
                    .fromJson(responseBody.string(), ReMenBean.class);
            recyclerShipin.setLayoutManager(new StaggeredGridLayoutManager
                    (2, StaggeredGridLayoutManager.VERTICAL));
            ShiPinAdapter adapter = new ShiPinAdapter(getActivity()
                    , reMenBean);
            recyclerShipin.setAdapter(adapter);
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
    public void onDestroyView() {
        super.onDestroyView();
        presenter.setJieYue();
        if (presenter != null) {
            presenter.detachView();
        }
        unbinder.unbind();

    }
}
