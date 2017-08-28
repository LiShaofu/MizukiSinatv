package com.mizuki.sinatv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        automaticSignIn();//得到SP保存的数据,开始自动登录
    }

    //开始自动登录
    private void automaticSignIn() {
        //得到SP保存的数据
        SharedPreferences preferences = getSharedPreferences("user_id", Context.MODE_PRIVATE);
        String id = preferences.getString("userId", "0");
        Log.e("TAG", id);
        if (!id.equals("0")) {
            Toast.makeText(StartActivity.this, "自动登录成功！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(StartActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(StartActivity.this, "自动登录失败，请手动登录！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(StartActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_start;
    }
}
