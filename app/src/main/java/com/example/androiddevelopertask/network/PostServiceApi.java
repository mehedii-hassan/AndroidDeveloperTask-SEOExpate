package com.example.androiddevelopertask.network;

import com.example.androiddevelopertask.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceApi {
    @GET("/")
    Call<List<PostModel>> getPost(

    );

}
