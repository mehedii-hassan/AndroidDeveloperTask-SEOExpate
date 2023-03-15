package com.example.androiddevelopertask.network;

import com.example.androiddevelopertask.models.CommentResponseModel;
import com.example.androiddevelopertask.models.PostResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostServiceApi {

    @GET("posts")
    Call<List<PostResponseModel>> getPostResponse(

    );

    @GET("posts/{postId}/comments")
    Call<List<CommentResponseModel>> getCommentsOfPost(
            @Path("postId") int postId
    );

}
