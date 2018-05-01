package com.example.hello.myquarterykz.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.model.bean.ShouCangLieBiaoBean;
import com.example.hello.myquarterykz.view.holder.MyShouCangHolder;


/**
 * Created by admin on 2018/4/13.
 */

public class MyShouCangAdapter extends RecyclerView.Adapter<MyShouCangHolder> {
    private final Context context;
    private final ShouCangLieBiaoBean shouCangLieBiaoBean;

    public MyShouCangAdapter(Context context,
                             ShouCangLieBiaoBean shouCangLieBiaoBean) {

        this.context = context;
        this.shouCangLieBiaoBean = shouCangLieBiaoBean;
    }

    @Override
    public MyShouCangHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout
                .item_shoucang, parent, false);

        MyShouCangHolder holder = new MyShouCangHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyShouCangHolder holder, int position) {
        ShouCangLieBiaoBean.DataBean bean = shouCangLieBiaoBean.getData().get(position);
        if (bean.getUser().getIcon()==null){
            holder.sdv_shoucang.setImageURI("http://img2.imgtn.bdimg.com/it/u=3994633895,563142661&fm=27&gp=0.jpg");
        }
        holder.sdv_shoucang.setImageURI(bean.getUser().getIcon());
        holder.text_title_shoucang.setText(bean.getUser().getNickname());


        holder.text_time_shoucang.setText(bean.getCreateTime());
        holder.text_cont_shoucang.setText(bean.getLongitude());
        holder.text_cont1_shoucang.setText(bean.getWorkDesc());
        holder.text_cont2_shoucang.setText(bean.getWorkDesc());

        holder.shoucangtupian.setImageURI(Uri.parse(bean.getCover()));

    }





    @Override
    public int getItemCount() {
        return shouCangLieBiaoBean.getData().size();
    }
}
