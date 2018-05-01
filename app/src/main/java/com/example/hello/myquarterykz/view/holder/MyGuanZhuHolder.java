package com.example.hello.myquarterykz.view.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/4/13.
 */

public class MyGuanZhuHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView sdv_guan;
    public TextView text_title_guan;
    public TextView text_time_guan;
    public TextView text_cont_guan;

    public MyGuanZhuHolder(View itemView) {
        super(itemView);
        sdv_guan = itemView.findViewById(R.id.sdv_guan);
        text_title_guan = itemView.findViewById(R.id.text_title_guan);
        text_time_guan = itemView.findViewById(R.id.text_time_guan);
        text_cont_guan = itemView.findViewById(R.id.text_cont_guan);


    }
}
