package com.example.hello.myquarterykz.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/4/13.
 */

public class ShiPinHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_shipin;

    public ShiPinHolder(View itemView) {
        super(itemView);
        sdv_shipin = itemView.findViewById(R.id.sdv_shipin);
    }
}
