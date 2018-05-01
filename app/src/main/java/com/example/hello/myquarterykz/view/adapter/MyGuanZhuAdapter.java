package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.GuanZhuLieBiaoBean;
import com.example.hello.myquarterykz.view.holder.MyGuanZhuHolder;


/**
 * Created by admin on 2018/4/13.
 */

public class MyGuanZhuAdapter extends RecyclerView.Adapter<MyGuanZhuHolder> {
    private final Context context;
    private final GuanZhuLieBiaoBean guanZhuLieBiaoBean;

    public MyGuanZhuAdapter(Context context, GuanZhuLieBiaoBean guanZhuLieBiaoBean) {

        this.context = context;
        this.guanZhuLieBiaoBean = guanZhuLieBiaoBean;
    }


    @Override
    public MyGuanZhuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .item_guanzhu, parent, false);

        MyGuanZhuHolder holder = new MyGuanZhuHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyGuanZhuHolder holder, int position) {
        GuanZhuLieBiaoBean.DataBean bean = guanZhuLieBiaoBean.getData().get(position);
        holder.sdv_guan.setImageURI(bean.getIcon());
        holder.text_title_guan.setText(bean.getNickname());
        holder.text_time_guan.setText(bean.getCreatetime());
        holder.text_cont_guan.setText(bean.getAppkey());
    }

    @Override
    public int getItemCount() {
        return guanZhuLieBiaoBean.getData().size();
    }
}
