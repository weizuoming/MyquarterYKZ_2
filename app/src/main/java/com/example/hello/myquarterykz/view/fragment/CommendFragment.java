package com.example.hello.myquarterykz.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.view.fragment.CoFollowFragment;
import com.example.hello.myquarterykz.view.fragment.HotFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 推荐的fragment
 * Created by 韦作铭 on 2018/4/9.
 */

public class CommendFragment extends Fragment {
    @BindView(R.id.commend_tabl)
    TabLayout commendTabl;
    @BindView(R.id.commend_vp)
    ViewPager commend_vp;
    Unbinder unbinder;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_commend,container
                ,false);
        unbinder=ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Tag", "++++++++++++++++1", null);
        initData();
        initView();
    }

    private void initView() {
        commend_vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                fragment=new HotFragment();
                switch (position){
                    case 0:
                        fragment=new HotFragment();
                        break;
                    case 1:
                        fragment=new CoFollowFragment();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        commendTabl.setupWithViewPager(commend_vp);
    }



    private void initData() {
        list = new ArrayList<>();
        list.add("热门");
        list.add("关注");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
