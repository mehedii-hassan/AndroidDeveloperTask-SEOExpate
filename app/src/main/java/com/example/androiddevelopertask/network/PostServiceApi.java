package com.example.androiddevelopertask.network;

import com.example.androiddevelopertask.models.PostResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceApi {

    @GET("posts")
    Call<List<PostResponseModel>> getPostResponse(

    );

}
