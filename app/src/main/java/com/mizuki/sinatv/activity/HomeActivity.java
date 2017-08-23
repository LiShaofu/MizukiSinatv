package com.mizuki.sinatv.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;
import com.mizuki.sinatv.adapter.HomeAdapter;
import com.mizuki.sinatv.fragment.LiveFragment;
import com.mizuki.sinatv.fragment.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    @BindView(R.id.home_rb_live)
    RadioButton homeRbLive;
    @BindView(R.id.home_iv_room)
    ImageView homeIvRoom;
    @BindView(R.id.home_rb_me)
    RadioButton homeRbMe;
    @BindView(R.id.home_rg)
    RadioGroup homeRg;

    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_home;
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(0, new LiveFragment());
        fragmentList.add(1, new MeFragment());
        //适配
        homeVp.setAdapter(new HomeAdapter(getSupportFragmentManager(), fragmentList));
        //默认选中
        homeRg.check(R.id.home_rb_live);

        //RadioGroup的监听事件
        homeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.home_rb_live:
                        homeVp.setCurrentItem(0);
                        break;
                    case R.id.home_rb_me:
                        homeVp.setCurrentItem(1);
                        break;
                }
            }
        });
        //
        homeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        homeRg.check(R.id.home_rb_live);
                        break;
                    case 1:
                        homeRg.check(R.id.home_rb_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
