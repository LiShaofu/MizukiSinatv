package com.mizuki.sinatv.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.activity.base.BaseActivity;
import com.mizuki.sinatv.api.SignInApi;
import com.mizuki.sinatv.bean.SignInBean;
import com.mizuki.sinatv.network.RetrofitManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mizuki.sinatv.utils.ToastUtils.showToastNull;

public class SigninActivity extends BaseActivity {
    @BindView(R.id.et_signin_phone)
    EditText etSigninPhone;
    @BindView(R.id.et_signin_pwd)
    EditText etSigninPwd;
    private String phone = "";
    private String password = "";

    @Override
    protected int getContentResId() {
        return R.layout.activity_signin;
    }

    @Override
    protected void initTitleBar(HeaderBuilder builder) {
        builder.goneToolbar();
    }

    //sign in的业务逻辑处理
    private void signin() {
        // 1 获取输入的用户名和密码
        final String signinPhone = etSigninPhone.getText().toString().trim();
        final String signinPwd = etSigninPwd.getText().toString().trim();
        // 2 校验输入的用户名和密码不为空
        showToastNull(SigninActivity.this, signinPhone, "输入的电话号码不能为空！");
        showToastNull(SigninActivity.this, signinPwd, "输入的密码不能为空！");
        // 3 登录逻辑处理
        Toast.makeText(SigninActivity.this, "开始登录！", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "号码：" + signinPhone + "\t" + "密码：" + signinPwd);
        SignInApi signInApi = RetrofitManager.getTestRetrofit().create(SignInApi.class);
        FormBody formBody = new FormBody.Builder()//用户注册参数
                .add("phone", signinPhone)//手机号
                .add("password", signinPwd)// 密码
                .build();
        Call<SignInBean> signInBeanCall = signInApi.postSignIn(formBody);
        signInBeanCall.enqueue(new Callback<SignInBean>() {
            @Override
            public void onResponse(Call<SignInBean> call, Response<SignInBean> response) {
                Log.e("TAG", "error_code:" + response.body().getError_code());
                Log.e("TAG", "id:" + response.body().getResult().getId());
                if (response.body().getError_code() == 0) {
                    Toast.makeText(SigninActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(SigninActivity.this, HomeActivity.class);

                    //将登录信息保存在本地，方式为无密，（不标准）
                    SharedPreferencesSave(response.body().getResult().getId()+"");
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<SignInBean> call, Throwable t) {
                Toast.makeText(SigninActivity.this, "网络连接失败或参数错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //将登录信息:id,保存在本地
    private void SharedPreferencesSave(String id) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_id", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.e("TAG", id);
        editor.putString("userId", id);
        editor.commit();
    }

    //跳转sign up页面,销毁登录页面
    private void signup() {
        Intent intent = new Intent();
        intent.setClass(SigninActivity.this, SignupActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(SigninActivity.this, "跳转注册页面！", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //得到注册页面传来的数据
        Intent intent = getIntent();
        if (intent != null) {
            phone = intent.getStringExtra("phone");
            password = intent.getStringExtra("password");
        }
        etSigninPhone.setText(phone);
        etSigninPwd.setText(password);


//        //通过id得到User信息，进行登录
//        UserInfoApi userInfoApi = RetrofitManager.getTestRetrofit().create(UserInfoApi.class);
//        FormBody formBody = new FormBody.Builder()//用户信息参数
//                .add("uid", id+"")//userID
//                .build();
//        Call<UserInfoBean> userInfoBeanCall = userInfoApi.postUserInfo(formBody);
//        userInfoBeanCall.enqueue(new Callback<UserInfoBean>() {
//            @Override
//            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
//                Log.e("TAG003", "response.body():" + response.body().getResult().getList().size());
//            }
//
//            @Override
//            public void onFailure(Call<UserInfoBean> call, Throwable t) {
//                Toast.makeText(SigninActivity.this, "网络连接失败或参数错误", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    //sign in或new sign up
    @OnClick({R.id.bt_signin, R.id.tx_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_signin://sign in
                signin();
                break;
            case R.id.tx_signup://new Sign in
                signup();//跳转sign up页面,销毁登录页面
                break;
        }
    }
}



