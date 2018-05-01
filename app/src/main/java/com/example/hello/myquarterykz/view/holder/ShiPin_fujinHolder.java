package com.example.hello.myquarterykz.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/4/13.
 */

public class ShiPin_fujinHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_shipinf;

    public ShiPin_fujinHolder(View itemView) {
        super(itemView);
        sdv_shipinf = itemView.findViewById(R.id.sdv_shipinf);
    }
}
