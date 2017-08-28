package com.mizuki.sinatv.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;


public class ToastUtils {
    /**
     * 判断String是否为null
     * true,为null时，Toast一下
     * @param context
     * @param data
     * @param message
     */
    public static void showToastNull(Context context, String data, String message) {
        if (TextUtils.isEmpty(data)) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private static Toast mToast = null;

    private ToastUtils() {
    }

    public static void showShort(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtil.getInstance(), resId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showShort(String message) {
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtil.getInstance(), message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showLong(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtil.getInstance(), resId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(resId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    public static void showLong(String message) {
        if (mToast == null) {
            mToast = Toast.makeText(ContextUtil.getInstance(), message, Toast.LENGTH_LONG);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
}
