package com.mizuki.sinatv.api;

import com.mizuki.sinatv.bean.SignInBean;
import com.mizuki.sinatv.config.UrlConfig;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/8/28.
 */

public interface SignInApi {
    @POST(UrlConfig.API_USER_SIGN_IN)
    Call<SignInBean> postSignIn(@Body FormBody formBody);
}
