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
import com.example.hello.myquarterykz.model.bean.DuanZiBean;
import com.example.hello.myquarterykz.presenter.Presenter;
import com.example.hello.myquarterykz.util.ApiUrl;
import com.example.hello.myquarterykz.util.RetrofitUtil;
import com.example.hello.myquarterykz.view.adapter.MyDuanZiAdapter;
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
 * 段子的fragment
 * Created by 韦作铭 on 2018/4/9.
 */

public class JokesFragment extends Fragment implements MyView {

    @BindView(R.id.recycler_duanzi)
    RecyclerView recyclerDuanzi;
    Unbinder unbinder;
    private Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jokes
                , container, false);
//        ButterKnife.bind(getActivity());
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //接着
        presenter = new Presenter(this);
        presenter.attachView(this);
        Map<String, String> map = new HashMap<>();
        map.put("token","session");
        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.DUANZI_URL, map));

    }

    @Override
    public void getResponse(ResponseBody responseBody) {
        try {
            DuanZiBean duanZiBean = new Gson().fromJson(responseBody
                    .string(), DuanZiBean.class);
            recyclerDuanzi.setLayoutManager(new LinearLayoutManager(getActivity()
                    ,LinearLayoutManager.VERTICAL,false));
            MyDuanZiAdapter adapter = new MyDuanZiAdapter(getActivity()
                    , duanZiBean);
            recyclerDuanzi.setAdapter(adapter);



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
