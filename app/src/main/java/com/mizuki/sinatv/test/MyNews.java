package com.mizuki.sinatv.test;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 接口地址Url = http://v.juhe.cn/toutiao/index
 示例地址：（头条）http://v.juhe.cn/toutiao/index?type=top&key=562402375cb93590c7eec9ade024dffe
 请求方式：Get

 1、Android 常用布局
 2、Android 生命周期
 3、Android onSaveInstanceState() 保存数据
 */
public interface MyNews {
    //http://v.juhe.cn/toutiao/index?type=top&key=562402375cb93590c7eec9ade024dffe
    @GET("index")
    Call<TopNews> getNew(@Query("type")String type,@Query("key")String key);

    //http://v.juhe.cn/toutiao/index/1111111111
    @GET("index/{id}")
    Call<TopNews> getNew(@Path("id")String id);

    @POST("index")
    Call<TopNews> postNew(@Body FormBody formBody);
}
