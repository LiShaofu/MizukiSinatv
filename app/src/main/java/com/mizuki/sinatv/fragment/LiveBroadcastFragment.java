package com.mizuki.sinatv.fragment;

import android.os.Bundle;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.fragment.base.BaseFragment;

/**
 * 现场直播
 */

public class LiveBroadcastFragment extends BaseFragment{

    @Override
    protected int getContentResId() {
        return R.layout.fragment_live_broadcast;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
