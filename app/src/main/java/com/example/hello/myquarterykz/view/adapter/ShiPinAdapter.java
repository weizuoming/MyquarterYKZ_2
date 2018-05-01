package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ReMenBean;
import com.example.hello.myquarterykz.view.activity.ShiPinActivity;
import com.example.hello.myquarterykz.view.holder.ShiPinHolder;


/**
 * Created by admin on 2018/4/13.
 */

public class ShiPinAdapter extends RecyclerView.Adapter<ShiPinHolder> {


    private final Context context;
    private final ReMenBean reMenBean;

    public ShiPinAdapter(Context context, ReMenBean reMenBean) {

        this.context = context;
        this.reMenBean = reMenBean;
    }

    @Override
    public ShiPinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .item_shipinliebiao, parent, false);
        ShiPinHolder holder = new ShiPinHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShiPinHolder holder, int position) {
        final ReMenBean.DataBean dataBean = reMenBean
                .getData().get(position);
        if (dataBean.getCover()==null){
            holder.sdv_shipin.setImageURI("http://p3.so.qhmsg" +
                    ".com/bdr/_240_/t0128ad386036905648.jpg");
        }else {
            holder.sdv_shipin.setImageURI(dataBean.getCover());
        }
        holder.sdv_shipin.setOnClickListener(new View.OnClickListener() {
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
        return reMenBean.getData().size();
    }
}
