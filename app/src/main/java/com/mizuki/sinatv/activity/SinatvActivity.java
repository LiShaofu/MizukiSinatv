package com.mizuki.sinatv.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ksyun.media.player.IMediaPlayer;
import com.ksyun.media.player.KSYMediaPlayer;
import com.ksyun.media.player.KSYTextureView;
import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;
import com.mizuki.sinatv.adapter.HomeAdapter;
import com.mizuki.sinatv.bean.Live;
import com.mizuki.sinatv.fragment.LiveBroadcastFragment;
import com.mizuki.sinatv.fragment.LiveFunctionsFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 直播和功能的Activity
 */
public class SinatvActivity extends BaseActivity {
    private static final String TAG = "SinatvActivity";

    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private Context mContext;
    private String mDataSource;

    @BindView(R.id.sinatv_vp)
    ViewPager sinatvVp;

    List<Fragment> fragments;

    @BindView(R.id.texture_view)
    KSYTextureView mVideoView;

    private FragmentManager manager;
    private LiveFunctionsFragment liveFunctionsFragment;
    private LiveBroadcastFragment liveBroadcastFragment;

    public Live.ResultBean.ListBean listBean;

    //得到上个Intent的传参
    public Live.ResultBean.ListBean getlistBean() {
        if (listBean == null) {
            Bundle bundle = getIntent().getExtras();
            listBean = (Live.ResultBean.ListBean) bundle.getSerializable("list");
            Log.e("TAG", "" + listBean.getUser().getUser_data().getSign());
        }
        return listBean;
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_sinatv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mContext = SinatvActivity.this;
        init();
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    private void init() {
        getlistBean();
        fragments = new ArrayList<>();
        liveFunctionsFragment = new LiveFunctionsFragment();
        liveBroadcastFragment = new LiveBroadcastFragment();
        fragments.add(0, liveBroadcastFragment);
        fragments.add(1, liveFunctionsFragment);

        manager = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putSerializable("fragData", listBean);
        fragments.get(1).setArguments(bundle);
        sinatvVp.setAdapter(new HomeAdapter(getSupportFragmentManager(), fragments));
        sinatvVp.setCurrentItem(1); //设置当前页是第二页
        //滑动监听
//        sinatvVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override//在屏幕滚动过程中不断被调用
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override//页面被选中
//            public void onPageSelected(int position) {
//            }
//
//            @Override//手指操作屏幕的时候发生变化
//            public void onPageScrollStateChanged(int state) {
//            }
//        });

        mVideoView.setKeepScreenOn(true);//将屏幕一直保持为开启状态
//        mVideoView.setOnTouchListener(mTouchListener);//是获取某一个控件某一个View的点击监控。

        mVideoView.setOnBufferingUpdateListener(mOnBufferingUpdateListener);
        mVideoView.setOnCompletionListener(mOnCompletionListener);
        mVideoView.setOnPreparedListener(mOnPreparedListener);
        mVideoView.setOnInfoListener(mOnInfoListener);
        mVideoView.setOnVideoSizeChangedListener(mOnVideoSizeChangeListener);
        mVideoView.setOnErrorListener(mOnErrorListener);
        mVideoView.setOnSeekCompleteListener(mOnSeekCompletedListener);
        mVideoView.setOnMessageListener(mOnMessageListener);
        mVideoView.setScreenOnWhilePlaying(true);

        mDataSource = "rtmp://live.hkstv.hk.lxdns.com/live/hks";//香港卫视
        try {
            mVideoView.setDataSource(mDataSource);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(SinatvActivity.this, "地址---", Toast.LENGTH_SHORT).show();
        }
        mVideoView.prepareAsync();
    }

    private IMediaPlayer.OnMessageListener mOnMessageListener = new IMediaPlayer.OnMessageListener() {
        @Override
        public void onMessage(IMediaPlayer iMediaPlayer, String name, String info, double number) {
            Log.e(TAG, "name:" + name + ",info:" + info + ",number:" + number);
        }
    };
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompletedListener = new IMediaPlayer.OnSeekCompleteListener() {
        @Override
        public void onSeekComplete(IMediaPlayer mp) {
            Log.e(TAG, "onSeekComplete...............");
        }
    };
    private IMediaPlayer.OnErrorListener mOnErrorListener = new IMediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(IMediaPlayer mp, int what, int extra) {
            switch (what) {
                //case KSYVideoView.MEDIA_ERROR_UNKNOWN:
                // Log.e(TAG, "OnErrorListener, Error Unknown:" + what + ",extra:" + extra);
                //  break;
                default:
                    Log.e(TAG, "OnErrorListener, Error:" + what + ",extra:" + extra);
            }
            videoPlayEnd();
            return false;
        }
    };

    private void videoPlayEnd() {
        if (mVideoView != null) {
            mVideoView.release();
            mVideoView = null;
        }
        finish();
    }

    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangeListener = new IMediaPlayer.OnVideoSizeChangedListener() {
        @Override
        public void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen) {
            if (mVideoWidth > 0 && mVideoHeight > 0) {
                if (width != mVideoWidth || height != mVideoHeight) {
                    mVideoWidth = mp.getVideoWidth();
                    mVideoHeight = mp.getVideoHeight();

                    if (mVideoView != null)
                        mVideoView.setVideoScalingMode(KSYMediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
                }
            }
        }
    };
    public IMediaPlayer.OnInfoListener mOnInfoListener = new IMediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
            switch (i) {
                case KSYMediaPlayer.MEDIA_INFO_BUFFERING_START:
                    Log.d(TAG, "Buffering Start.");
                    break;
                case KSYMediaPlayer.MEDIA_INFO_BUFFERING_END:
                    Log.d(TAG, "Buffering End.");
                    break;
                case KSYMediaPlayer.MEDIA_INFO_AUDIO_RENDERING_START:
                    Toast.makeText(mContext, "Audio Rendering Start", Toast.LENGTH_SHORT).show();
                    break;
                case KSYMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                    Toast.makeText(mContext, "Video Rendering Start", Toast.LENGTH_SHORT).show();
                    break;
                case KSYMediaPlayer.MEDIA_INFO_RELOADED:
                    Toast.makeText(mContext, "Succeed to reload video.", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Succeed to mPlayerReload video.");
                    return false;
            }
            return false;
        }
    };
    private IMediaPlayer.OnPreparedListener mOnPreparedListener = new IMediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(IMediaPlayer mp) {
            Log.d("VideoPlayer", "OnPrepared");
            mVideoWidth = mVideoView.getVideoWidth();
            mVideoHeight = mVideoView.getVideoHeight();

            // Set Video Scaling Mode
            mVideoView.setVideoScalingMode(KSYMediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);

            //start player
            mVideoView.start();

            //set progress
        }
    };
    private IMediaPlayer.OnCompletionListener mOnCompletionListener = new IMediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(IMediaPlayer mp) {
            Toast.makeText(mContext, "OnCompletionListener, play complete.", Toast.LENGTH_LONG).show();
            videoPlayEnd();
        }
    };
    private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(IMediaPlayer mp, int percent) {
            long duration = mVideoView.getDuration();
            long progress = duration * percent / 100;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            videoPlayEnd();
        }

        return super.onKeyDown(keyCode, event);
    }
}
