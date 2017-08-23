package com.mizuki.sinatv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {

    private List<Fragment> alist;
    public HomeAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        alist = list;
    }

    @Override
    public Fragment getItem(int position) {

        return alist.get(position);
    }

    @Override
    public int getCount() {
        return alist.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return t;
//    }
}
