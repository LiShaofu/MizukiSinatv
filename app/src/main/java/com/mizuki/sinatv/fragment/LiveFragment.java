package com.mizuki.sinatv.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.fragment.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/16.
 */

public class LiveFragment extends BaseFragment {
    @BindView(R.id.live_tl)
    TabLayout liveTl;
    @BindView(R.id.live_vp)
    ViewPager liveVp;
    Unbinder unbinder;

    ArrayList<Fragment> fragments;

    @Override
    protected int getContentResId() {
        return R.layout.fragment_live;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragments = new ArrayList<>();
        fragments.add(0, new SiftFragment());
        fragments.add(1, new HotFragment());
        //viewpager加载adapter
        liveVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            //tab名的列表
            String[] item = new String[]{"精选", "热门"};

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return fragments.get(0);
                    case 1:
                        return fragments.get(1);
                }
                return fragments.get(0);
            }

            @Override
            public int getCount() {
                return item.length;
            }

            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {
                return item[position];
            }
        });
        //关联，？//TabLayout加载viewpager
        liveTl.setupWithViewPager(liveVp);
//        liveTl.getTabAt(0).setText("精选");
//        liveTl.getTabAt(0).setText("热门");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
