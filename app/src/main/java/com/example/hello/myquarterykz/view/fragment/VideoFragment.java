package com.example.hello.myquarterykz.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hello.myquarterykz.R;
import com.example.hello.myquarterykz.view.fragment.ShiPinFuJinFragment;
import com.example.hello.myquarterykz.view.fragment.ShiPinReMenFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 视频的fragment
 * Created by 韦作铭 on 2018/4/9.
 */

public class VideoFragment extends Fragment {
    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    Unbinder unbinder;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }
    private void initData() {
        list = new ArrayList<>();
        list.add("热门");
        list.add("附近");
    }
    private void initView() {
        vpPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                fragment=new ShiPinReMenFragment();
                switch (position){
                    case 0:
                        fragment=new ShiPinReMenFragment();
                        break;
                    case 1:
                        fragment=new ShiPinFuJinFragment();
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        tlTab.setupWithViewPager(vpPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
