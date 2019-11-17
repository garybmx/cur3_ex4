package com.example.cur3_ex4;

import android.util.Log;

import com.example.cur3_ex4.models.Api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkService {

    private static NetworkService mInstance;
    private static final String BASE_URL = "https://api.github.com";
    private Retrofit mRetrofit;

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Api getJSONApi() {
        return mRetrofit.create(Api.class);
    }
}
