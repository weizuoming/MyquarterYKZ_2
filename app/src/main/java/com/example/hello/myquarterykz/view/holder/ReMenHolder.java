package com.example.hello.myquarterykz.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import cn.jzvd.JZVideoPlayerStandard;


/**
 * Created by 韦作铭 on 2018/4/10.
 */

public class ReMenHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_yuan;
    public TextView text_title;
    public TextView text_time;
    public TextView text_cont;
    public TextView text_cont1;
    public TextView text_cont2;
    public JZVideoPlayerStandard jzvideoPlayerStandard;
    public FloatingActionsMenu floating_actionsMenu;

    public ReMenHolder(View itemView) {
        super(itemView);
        sdv_yuan = itemView.findViewById(R.id.sdv_yuan);
        text_title = itemView.findViewById(R.id.text_title);
        text_time = itemView.findViewById(R.id.text_time);
        text_cont = itemView.findViewById(R.id.text_cont);
        text_cont1 = itemView.findViewById(R.id.text_cont1);
        text_cont2 = itemView.findViewById(R.id.text_cont2);
        jzvideoPlayerStandard = itemView.findViewById(R.id.jzvideoPlayerStandard);
        floating_actionsMenu = itemView.findViewById(R.id.floating_ActionsMenu);

    }
}
