package com.mizuki.sinatv.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mizuki.sinatv.R;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        init();
    }

    /**
     * 这是gst请求方法
     */
    private void init() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://v.juhe.cn/toutiao/")
                .build();
        MyNews myNews = retrofit.create(MyNews.class);

        Call<TopNews> top = myNews.getNew("top", "562402375cb93590c7eec9ade024dffe");
        top.enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                Log.e("Test1Activity", "response.body():" + response.body().getResult().getData().get(0)
                        .getAuthor_name());
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {
                Toast.makeText(Test1Activity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 这个api不支持post
     * 这是post请求方法
     */
    private void init1() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://v.juhe.cn/toutiao/")
                .build();
        MyNews myNews = retrofit.create(MyNews.class);

        FormBody formBody = new FormBody.Builder()
                .add("type", "top")
                .add("key", "562402375cb93590c7eec9ade024dffe")
                .build();
        Call<TopNews> topNewsCall = myNews.postNew(formBody);

        topNewsCall.enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                Log.e("Test1Activity", "response.body():" + response.body().getResult().getData().get(0)
                        .getAuthor_name());
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {
                Toast.makeText(Test1Activity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
