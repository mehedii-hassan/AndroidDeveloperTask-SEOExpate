package com.example.androiddevelopertask.network;

import com.example.androiddevelopertask.models.CommentModel;
import com.example.androiddevelopertask.models.CommentResponseModel;
import com.example.androiddevelopertask.models.PostResponseModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
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

    @POST("posts/{postId}/comments")
    Call<CommentModel> postComment(
            @HeaderMap Map<String, String> headersMap,
            @Body CommentModel comment,
            @Path("postId") int postId
    );

}
