package com.example.hello.myquarterykz.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by admin on 2018/4/13.
 */

public class MyDuanZiHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView sdv_yuan;
    public TextView text_title;
    public TextView text_time;
    public TextView text_cont;
    public FloatingActionsMenu floating_actionsMenu;
    public MyDuanZiHolder(View itemView) {
        super(itemView);
        sdv_yuan = itemView.findViewById(R.id.sdv_yuan);
        text_title = itemView.findViewById(R.id.text_title);
        text_time = itemView.findViewById(R.id.text_time);
        text_cont = itemView.findViewById(R.id.text_cont);
        floating_actionsMenu = itemView.findViewById(R.id.floating_ActionsMenu);

    }
}
