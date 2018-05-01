package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.DuanZiBean;
import com.example.hello.myquarterykz.view.holder.MyDuanZiHolder;


/**
 * Created by admin on 2018/4/13.
 */

public class MyDuanZiAdapter extends RecyclerView.Adapter<MyDuanZiHolder> {
    private final Context context;
    private final DuanZiBean duanZiBean;

    public MyDuanZiAdapter(Context context, DuanZiBean duanZiBean) {

        this.context = context;
        this.duanZiBean = duanZiBean;
    }

    @Override
    public MyDuanZiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .item_duanzi, parent, false);

        MyDuanZiHolder holder = new MyDuanZiHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyDuanZiHolder holder, int position) {
        DuanZiBean.DataBean bean = duanZiBean.getData().get(position);
        holder.sdv_yuan.setImageURI(bean.getUser().getIcon());
        holder.text_title.setText(bean.getUser().getNickname());
        holder.text_time.setText(bean.getCreateTime());
        holder.text_cont.setText(bean.getContent());

    }

    @Override
    public int getItemCount() {
        return duanZiBean.getData().size();
    }
}
