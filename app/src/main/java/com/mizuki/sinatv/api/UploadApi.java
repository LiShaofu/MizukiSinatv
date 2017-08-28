package com.mizuki.sinatv.api;

import com.mizuki.sinatv.bean.UploadBean;
import com.mizuki.sinatv.config.UrlConfig;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2017/8/25.
 */

public interface UploadApi {
    @Multipart
    @POST(UrlConfig.API_FILE_UPLOAD)
    Call<UploadBean> upload(@Part MultipartBody.Part filepart);
}
