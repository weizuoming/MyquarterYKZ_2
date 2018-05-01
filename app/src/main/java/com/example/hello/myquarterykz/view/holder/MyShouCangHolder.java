package com.example.hello.myquarterykz.view.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hello.myquarterykz.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by admin on 2018/4/13.
 */

public class MyShouCangHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView sdv_shoucang;
    public TextView text_title_shoucang;
    public TextView text_time_shoucang;
    public TextView text_cont_shoucang;
    public TextView text_cont1_shoucang;
    public TextView text_cont2_shoucang;
    public ImageView shoucangtupian;
    public FloatingActionsMenu floating_actionsMenu_shoucang;

    public MyShouCangHolder(View itemView) {
        super(itemView);
        sdv_shoucang = itemView.findViewById(R.id.sdv_shoucang);
        text_title_shoucang = itemView.findViewById(R.id.text_title_shoucang);
        text_time_shoucang = itemView.findViewById(R.id.text_time_shoucang);
        text_cont_shoucang = itemView.findViewById(R.id.text_cont_shoucang);
        text_cont1_shoucang = itemView.findViewById(R.id.text_cont1_shoucang);
        text_cont2_shoucang = itemView.findViewById(R.id.text_cont2_shoucang);
        shoucangtupian = itemView.findViewById(R.id.shoucangtupian);
        floating_actionsMenu_shoucang = itemView.findViewById(R.id.floating_ActionsMenu_shoucang);


    }
}
