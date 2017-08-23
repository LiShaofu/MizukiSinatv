package com.mizuki.sinatv.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mizuki.sinatv.R;
import com.mizuki.sinatv.adapter.FunctionsAvatarAdapter;
import com.mizuki.sinatv.adapter.FunctionsMessageAdapter;
import com.mizuki.sinatv.adapter.GridViewAdapter;
import com.mizuki.sinatv.adapter.ViewPagerAdapter;
import com.mizuki.sinatv.bean.Gift;
import com.mizuki.sinatv.fragment.base.BaseFragment;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Fragment
 * sinatv的功能页面
 * 有发送礼物，发送消息功能
 */

public class LiveFunctionsFragment extends BaseFragment {
    @BindView(R.id.functions_sinatv_avatar)
    CircleImageView functionsSinatvAvatar;
    @BindView(R.id.functions_sinatv_name)
    TextView functionsSinatvName;
    @BindView(R.id.functions_sinatv_user_name)
    TextView functionsSinatvUserName;
    @BindView(R.id.functions_ll)
    RelativeLayout functionsLl2;
    @BindView(R.id.functions_rv)
    RecyclerView functionsRv;
    @BindView(R.id.functions_sinatv_ticket_title)
    TextView functionsSinatvTicketTitle;
    @BindView(R.id.functions_sinatv_ticket)
    TextView functionsSinatvTicket;
    @BindView(R.id.functions_time)
    TextView functionsTime;
    @BindView(R.id.functions_data)
    TextView functionsData;
    @BindView(R.id.functions_message_rl)
    RecyclerView functionsMessageRl;
    @BindView(R.id.room_down_publicchat)
    ImageView roomDownPublicchat;
    @BindView(R.id.room_down_gift)
    ImageView roomDownGift;
    @BindView(R.id.room_down_music)
    ImageView roomDownMusic;
    @BindView(R.id.shortvideo_button_close)
    ImageView shortvideoButtonClose;
    @BindView(R.id.functions_ll_ico)
    LinearLayout functionsLlIco;
    @BindView(R.id.functions_et_message)
    EditText functionsEtMessage;
    @BindView(R.id.functions_btn_message_send)
    Button functionsBtnMessageSend;
    @BindView(R.id.functions_ll_message)
    LinearLayout functionsLlMessage;
    @BindView(R.id.functions_ll_)
    LinearLayout functionsLl;
    private Unbinder unbinder;
    private List<String> list;
    private FunctionsMessageAdapter functionsMessageAdapter;
    private List<Gift.GiftListBean> mDatas;
    private int pageSize = 9;//页数据
    private List<Gift.GiftListBean> giftList;

    @Override
    protected int getContentResId() {
        return R.layout.fragment_live_functions;
    }

    public Fragment getFragment() {
        return new LiveFunctionsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
        showAvatar();//好多头像
        showDate();//日期
        showTime();//时间
        showMessage();//好多消息
    }

    private void showMessage() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        functionsMessageRl.setLayoutManager(manager);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("这是消息！");
        }
        functionsMessageAdapter = new FunctionsMessageAdapter(getActivity(), list);
        functionsMessageRl.setAdapter(functionsMessageAdapter);
    }

    private void showAvatar() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滑动
        functionsRv.setLayoutManager(manager);

        FunctionsAvatarAdapter functionsAvatarAdapter = new FunctionsAvatarAdapter(getActivity());
        functionsRv.setAdapter(functionsAvatarAdapter);
    }

    private void showTime() {
        final int[] second = {0};//秒
        final int[] minute = {0}; // 分钟数
        final int[] houre = {0};//小时
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    second[0]++;
                    if (second[0] >= 60) {
                        second[0] = 0;
                        minute[0]++;
                        if (minute[0] >= 60) {
                            second[0] = 0;
                            minute[0]++;
                            houre[0]++;
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String houreStr = "";
                            String minuteStr = "";
                            String secondStr = "";
                            houreStr = houre[0] < 10 ? "0" + houre[0] : houre[0] + "";
                            minuteStr = minute[0] < 10 ? "0" + minute[0] : minute[0] + "";
                            secondStr = second[0] < 10 ? "0" + second[0] : second[0] + "";
                            functionsTime.setText(houreStr + ":" + minuteStr + ":" + secondStr);
                        }
                    });
                }
            }
        }).start();
    }

    private void showDate() {
        // 获得日历对象
        Calendar c = Calendar.getInstance();
        // 获取当前年份
        int year = c.get(Calendar.YEAR);
        // 获取当前月份(从0开始计算)
        int monthOfYear = c.get(Calendar.MONTH) + 1;
        // 获取当前月份的天数
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        // 获取当前的小时数
        int houre = c.get(Calendar.HOUR_OF_DAY);
        // 获取当前的分钟数
        int minute = c.get(Calendar.MINUTE);
        // 时间显示的文本对象
        // 显示时间的文本控件
        // 时间显示的控件
        functionsData.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.room_down_publicchat, R.id.functions_btn_message_send, R.id.room_down_gift})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.room_down_publicchat://发消息图标的监听事件
//                //图标一列隐藏,发消息显示
//                functionsLlIco.setVisibility(View.GONE);
//                functionsLlMessage.setVisibility(View.VISIBLE);
//                break;
//            case R.id.functions_btn_message_send://发送消息
//                String message = functionsEtMessage.getText().toString();
//                //刷新,滚动到相应条目
//                functionsMessageAdapter.setData(message);
//                functionsMessageRl.smoothScrollToPosition(functionsMessageAdapter.getData().size());
//                break;
            case R.id.room_down_gift:
                Toast.makeText(getActivity(), "发礼物图标的监听事件", Toast.LENGTH_SHORT).show();
//                recycleView_talk.setVisibility(View.INVISIBLE);
                View view2 = View.inflate(getActivity(), R.layout.livegift, null);
                ViewPager mPager = view2.findViewById(R.id.vp_livegift);
                LinearLayout mLlDot = view2.findViewById(R.id.ll_dot);

                LayoutInflater inflater = LayoutInflater.from(getActivity());
                //总的页数=总数/每页数量，并取整
                int pageCount = (int) Math.ceil(mDatas.size() * 1.0 / pageSize);
                List<View> mPagerList = new ArrayList<>();
                for (int i = 0; i < pageCount; i++) {
                    // 每个页面都是inflate出一个新实例
                    GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
                    gridView.setNumColumns(3);
                    gridView.setAdapter(new GridViewAdapter(getActivity(), mDatas, i, pageSize));
                    mPagerList.add(gridView);

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            int pos = position + curIndex * pageSize;
                        }
                    });
                }

                //设置适配器
                mPager.setAdapter(new ViewPagerAdapter(mPagerList));
                //setOvalLayout(); //设置圆点
                PopupWindow popupWindow1 = new PopupWindow(view2, RelativeLayout.LayoutParams.MATCH_PARENT, 900);

                //设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
                popupWindow1.setFocusable(true);
                //这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
                popupWindow1.setBackgroundDrawable(new BitmapDrawable());

                popupWindow1.setAnimationStyle(R.style.PopupAnimation);
                //在底部显示
                popupWindow1.showAtLocation(view2, Gravity.BOTTOM, 0, 0);
                break;

        }
    }

    private void initDatas() {
        Log.d("bbb", "gson::我也走了");
        mDatas = new ArrayList<>();
        try {
            InputStream inputStream = getActivity().getAssets().open("gift.json");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Gson gson = new Gson();

            Gift gift = gson.fromJson(inputStreamReader, Gift.class);
            giftList = gift.getGiftList();
            Log.d("aaa", "giftList::" + giftList.size());
            Toast.makeText(getActivity(), "giftList::" + giftList.size(), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < giftList.size(); i++) {
                mDatas.add(new Gift.GiftListBean(giftList.get(i).getGiftName(), giftList.get(i).getGiftPic(), giftList.get(i).getGiftPrice()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("aaa", "e");
        }

    }
}
