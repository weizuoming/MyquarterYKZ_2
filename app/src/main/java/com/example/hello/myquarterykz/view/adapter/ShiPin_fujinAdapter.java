package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.Shipin_Fujin_Bean;
import com.example.hello.myquarterykz.view.activity.ShiPinActivity;
import com.example.hello.myquarterykz.view.holder.ShiPin_fujinHolder;


/**
 * Created by admin on 2018/4/13.
 */

public class ShiPin_fujinAdapter extends RecyclerView.Adapter<ShiPin_fujinHolder> {


    private final Context context;
    private final Shipin_Fujin_Bean shipin_fujin_bean;

    public ShiPin_fujinAdapter(Context context, Shipin_Fujin_Bean shipin_fujin_bean) {

        this.context = context;
        this.shipin_fujin_bean = shipin_fujin_bean;
    }


    @Override
    public ShiPin_fujinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .item_shipinliebiao, parent, false);
        ShiPin_fujinHolder holder = new ShiPin_fujinHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShiPin_fujinHolder holder, int position) {
        final Shipin_Fujin_Bean.DataBean dataBean = shipin_fujin_bean
                .getData().get(position);
        if (dataBean.getCover()==null){
            holder.sdv_shipinf.setImageURI("http://p3.so.qhmsg" +
                    ".com/bdr/_240_/t0128ad386036905648.jpg");
        }else {
            holder.sdv_shipinf.setImageURI(dataBean.getCover());
        }
        holder.sdv_shipinf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShiPinActivity.class);
                intent.putExtra("url",dataBean.getWid()+"");
                context.startActivity(intent);
            }

        });
    }



    @Override
    public int getItemCount() {
        return shipin_fujin_bean.getData().size();
    }
}
