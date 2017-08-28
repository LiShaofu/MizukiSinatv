package com.mizuki.sinatv.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.SinatvActivity;
import com.mizuki.sinatv.adapter.LiveAdapter;
import com.mizuki.sinatv.api.LiveApi;
import com.mizuki.sinatv.bean.Live;
import com.mizuki.sinatv.fragment.base.BaseNetFragment;
import com.mizuki.sinatv.network.RetrofitManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.FormBody;
import retrofit2.Call;

/**
 * 精选碎片的业务处理
 */

public class SiftFragment extends BaseNetFragment<Live> {
    @BindView(R.id.sift_rv)
    RecyclerView siftRv;
    Unbinder unbinder;

    @BindView(R.id.sift_refresh)
    MaterialRefreshLayout siftRefresh;
    private List<Live.ResultBean.ListBean> list;
    private int page = 1;
    private LiveAdapter liveAdapter;

    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private int STATE = ONE;//状态

    @Override
    protected int getContentResId() {
        return R.layout.fragment_sift;
    }

    @Override
    protected void initViews() {
        siftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        liveAdapter = new LiveAdapter(getActivity()) {
            @Override
            public void clickLiveItem(int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SinatvActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", list.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void loadData() {
        LiveApi liveApi = RetrofitManager.getTestRetrofit().create(LiveApi.class);
        FormBody formBody = new FormBody.Builder()
                .add("type", "0")
                .add("page", page + "")
                .build();
        Call<Live> liveCall = liveApi.postlive(formBody);
        liveCall.enqueue(this);
    }

    @Override
    protected void processData(Live live) {
        goneLoading();
        list = live.getResult().getList();
        if (list.size() == 0) {
            Toast.makeText(getContext(), "数据异常", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (STATE) {
            case ONE:
                liveAdapter.refreshData(list);
                siftRv.setAdapter(liveAdapter);
                break;
            case TWO:
                liveAdapter.refreshData(list);
                siftRefresh.finishRefresh();//刷新完成
                break;
            case THREE:
                liveAdapter.moreData(list);
                siftRefresh.finishRefreshLoadMore();//加载完成
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        siftRefresh.setLoadMore(true);//支持加载
        siftRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override//更新
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                STATE = TWO;
                page = 1;
                loadData();
            }

            @Override//加载跟多
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                STATE = THREE;
                page++;
                loadData();
            }
        });

    }
}
