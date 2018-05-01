package com.example.hello.myquarterykz.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;

/**
 * Created by 韦作铭 on 2018/4/10.
 */

public class CoFollowFragment extends Fragment {

//    @BindView(R.id.gbanner)
//    Banner banner;
//    Unbinder unbinder;
//    @BindView(R.id.grecycler_view)
//    RecyclerView recyclerView;
//    private Presenter presenter;
//    private List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cofollow
                , container, false);
//        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        presenter = new Presenter(this);
//        presenter.attachView(this);
//        Map<String, String> map = new HashMap<>();
//        presenter.getUrl(RetrofitUtil.setService().doGet(ApiUrl.HOME_URL, map));
//        presenter.getUrlBean(RetrofitUtil.setService().doGet(ApiUrl.REMEN_URL, map));

    }

//    @Override
//    public void getResponse(ResponseBody responseBody) {
//        //截至做
//        try {
//            TuiJianLunBoTuBean lunBoTuBean = new Gson().fromJson(responseBody
//                    .string(), TuiJianLunBoTuBean.class);
//            List<TuiJianLunBoTuBean.DataBean> data = lunBoTuBean.getData();
//            for (TuiJianLunBoTuBean.DataBean d : data) {
//                list.add(d.getIcon());
//            }
//
//            banner.setBannerStyle(Banner.AUTOFILL_TYPE_LIST);//设置图片的样式
//            banner.setIndicatorGravity(Banner.CENTER); //设置指示器位置
//            banner.setDelayTime(2000);//间隔时间
//            banner.isAutoPlay(true);//设置自动轮播
//            banner.setImages(list);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void getResponseBodyBean(ResponseBody responseBody) {
//
//        try {
//            //Log.d("+++++++", responseBody.string());
//            ReMenShiPinBean reMenShiPinBean = new Gson().fromJson(responseBody
//                    .string(), ReMenShiPinBean.class);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
//                    , LinearLayoutManager.VERTICAL, false));
//
//            ReMenAdapter adapter = new ReMenAdapter(getActivity(), reMenShiPinBean);
//            recyclerView.setAdapter(adapter);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void getError(Throwable throwable) {
//
//    }
//    public void initData(ResponseBody responseBody) {
//        //判断是否登录...没有,则显示登录按钮....已经登录显示购物车数据
//        if (CommonUtils.getBoolean("isLogin")) {
//            try {
//                //Log.d("+++++++", responseBody.string());
//                ReMenShiPinBean reMenShiPinBean = new Gson().fromJson(responseBody
//                        .string(), ReMenShiPinBean.class);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()
//                        , LinearLayoutManager.VERTICAL, false));
//
//                ReMenAdapter adapter = new ReMenAdapter(getActivity(), reMenShiPinBean);
//                recyclerView.setAdapter(adapter);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            //请求购物车的数据
//
//
//
//        }
//
//    }
//
//
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        presenter.setJieYue();
//        if (presenter != null) {
//            presenter.detachView();
//        }
//        unbinder.unbind();
//
//    }
}
