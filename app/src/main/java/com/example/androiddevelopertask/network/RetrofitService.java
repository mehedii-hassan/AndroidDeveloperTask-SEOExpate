package com.example.androiddevelopertask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static PostServiceApi getService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PostServiceApi.class);
    }
}
