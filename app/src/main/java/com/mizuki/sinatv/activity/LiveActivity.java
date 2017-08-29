package com.mizuki.sinatv.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.ksyun.media.streamer.capture.CameraCapture;
import com.ksyun.media.streamer.kit.KSYStreamer;
import com.ksyun.media.streamer.kit.StreamerConstants;
import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;

import butterknife.BindView;

public class LiveActivity extends BaseActivity {
    @BindView(R.id.camera_preview)
    GLSurfaceView mCameraPreview;
    @BindView(R.id.qiehuan)
    Button qiehuan;
    private KSYStreamer mStreamer;

    @Override
    protected int getContentResId() {
        return R.layout.activity_live;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();//        初始化预览View
        initData();//    创建KSYStreamer实例并配置推流相关参数
        initInfo();    // 创建推流事件监听
//        mStreamer.startStream();//5.开始推流
        //6.推流开始前及推流过程中可动态设置的常用方法
//        mStreamer.stopStream();//停止推流
    }

    // 所有回调均运行在KSYStreamer的创建线程，建议在主线程中进行，开发者可以直接在回调中操作 KSYStreamer的相关接口，但不要在这些回调中做任何耗时的操作。
    // 设置Info回调，可以收到相关通知信息
    private void initInfo() {
        mStreamer.setOnInfoListener(new KSYStreamer.OnInfoListener() {
            @Override
            public void onInfo(int what, int msg1, int msg2) {
                // ...
            }
        });
        // 设置错误回调，收到该回调后，一般是发生了严重错误，比如网络断开等，
        // SDK内部会停止推流，APP可以在这里根据回调类型及需求添加重试逻辑。
        mStreamer.setOnErrorListener(new KSYStreamer.OnErrorListener() {
            @Override
            public void onError(int what, int msg1, int msg2) {
                // ...
            }
        });
    }

    private void initData() {
        // 创建KSYStreamer实例
        mStreamer = new KSYStreamer(this);
        mStreamer.switchCamera();//后摄像头


        // 设置预览View
        mStreamer.setDisplayPreview(mCameraPreview);
        // 设置推流url（需要向相关人员申请，测试地址并不稳定！）
//        mStreamer.setUrl("rtmp://test.uplive.ksyun.com/live/{streamName}");
        mStreamer.setUrl("rtmp://test.uplive.ksyun.com/live/{streamName}");
        // 设置预览分辨率, 当一边为0时，SDK会根据另一边及实际预览View的尺寸进行计算
        mStreamer.setPreviewResolution(480, 0);
        // 设置推流分辨率，可以不同于预览分辨率（不应大于预览分辨率，否则推流会有画质损失）
        mStreamer.setTargetResolution(480, 0);
        // 设置预览帧率
        mStreamer.setPreviewFps(15);
        // 设置推流帧率，当预览帧率大于推流帧率时，编码模块会自动丢帧以适应设定的推流帧率
        mStreamer.setTargetFps(15);
        // 设置视频码率，分别为初始平均码率、最高平均码率、最低平均码率，单位为kbps，另有setVideoBitrate接口，单位为bps
        mStreamer.setVideoKBitrate(600, 800, 400);
        // 设置音频采样率
        mStreamer.setAudioSampleRate(44100);
        // 设置音频码率，单位为kbps，另有setAudioBitrate接口，单位为bps
        mStreamer.setAudioKBitrate(48);
        /**
         * 设置编码模式(软编、硬编)，请根据白名单和系统版本来设置软硬编模式，不要全部设成软编或者硬编,白名单可以联系金山云商务:
         * StreamerConstants.ENCODE_METHOD_SOFTWARE
         * StreamerConstants.ENCODE_METHOD_HARDWARE
         */
        mStreamer.setEncodeMethod(StreamerConstants.ENCODE_METHOD_SOFTWARE);
        // 设置屏幕的旋转角度，支持 0, 90, 180, 270
        mStreamer.setRotateDegrees(0);
        // 设置开始预览使用前置还是后置摄像头
        mStreamer.setCameraFacing(CameraCapture.FACING_FRONT);
    }

    private void initView() {
        mCameraPreview = (GLSurfaceView) findViewById(R.id.camera_preview);
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    @Override
    public void onResume() {
        super.onResume();

        // 一般可以在onResume中开启摄像头预览
        mStreamer.startCameraPreview();
        // 调用KSYStreamer的onResume接口
        mStreamer.onResume();
        // 如果onPause中切到了DummyAudio模块，可以在此恢复
        mStreamer.setUseDummyAudioCapture(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        mStreamer.onPause();
        // 一般在这里停止摄像头采集
        mStreamer.stopCameraPreview();
        // 如果希望App切后台后，停止录制主播端的声音，可以在此切换为DummyAudio采集，
        // 该模块会代替mic采集模块产生静音数据，同时释放占用的mic资源
        mStreamer.setUseDummyAudioCapture(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 清理相关资源
        mStreamer.release();
    }

}
