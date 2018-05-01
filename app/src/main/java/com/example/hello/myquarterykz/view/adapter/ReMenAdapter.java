package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ReMenShiPinBean;
import com.example.hello.myquarterykz.view.holder.ReMenHolder;

/**
 * Created by Administrator on 2018/03/21.
 */

public class ReMenAdapter extends RecyclerView.Adapter<ReMenHolder> {
    private final Context context;
    private final ReMenShiPinBean reMenShiPinBean;
    public ReMenAdapter(Context context, ReMenShiPinBean reMenShiPinBean) {

        this.context = context;
        this.reMenShiPinBean = reMenShiPinBean;
    }



    @Override
    public ReMenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_remen,parent,false);
        ReMenHolder reMenHolder=new ReMenHolder(view);

        return reMenHolder;
    }

    @Override
    public void onBindViewHolder(ReMenHolder holder, int position) {
        ReMenShiPinBean.DataBean bean = reMenShiPinBean.getData().get(position);
        holder.sdv_yuan.setImageURI(bean.getUser().getIcon());
        holder.text_title.setText(bean.getUser().getNickname());

        Glide.with(context).load(bean.getCover()).into(holder.jzvideoPlayerStandard.thumbImageView);

        holder.text_time.setText(bean.getCreateTime());
        holder.text_cont.setText(bean.getComments().get(0).getContent());
        holder.text_cont1.setText(bean.getWorkDesc());
        holder.text_cont2.setText(bean.getWorkDesc());
        holder.jzvideoPlayerStandard.setUp(bean.getVideoUrl()
                , holder.jzvideoPlayerStandard.SCREEN_WINDOW_NORMAL, bean.getWorkDesc()+"");
        String cover = bean.getCover();
        holder.jzvideoPlayerStandard.thumbImageView.setImageURI(Uri.parse(cover));


    }

    @Override
    public int getItemCount() {
        return reMenShiPinBean.getData().size();
    }




}
