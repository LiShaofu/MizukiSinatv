package com.muzuki.sinatv.activity.base;

import android.os.Bundle;

import com.muzuki.sinatv.R;
import com.muzuki.sinatv.listener.OnRefreshListener;
import com.muzuki.sinatv.view.PublicLoadLayout;


/**
 * date: Created xiaoyuan on 16/11/05.
 */
public abstract class BaseLoadActivity extends ToolBarActivity implements OnRefreshListener {

    private PublicLoadLayout mPublicLoadLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRootContent();
    }

    private void setRootContent(){
        addContent(R.layout.activity_base_load);
        mPublicLoadLayout = getViewById(R.id.public_load_layout);
        mPublicLoadLayout.addContent(getContentResId());
    }

    public void goneLoading(){
        mPublicLoadLayout.goneLoading();
    }

    public void showNoData(){
        mPublicLoadLayout.showNoData();
    }

    public void showNetError(){
        mPublicLoadLayout.showNetError();
    }

    public void showLoading(){
        mPublicLoadLayout.showLoading();
    }

    protected abstract int getContentResId();

}
