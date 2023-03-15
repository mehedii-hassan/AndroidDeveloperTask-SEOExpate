package com.example.androiddevelopertask.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddevelopertask.models.CommentModel;
import com.example.androiddevelopertask.network.RetrofitService;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentPostViewModel extends ViewModel {


    private MutableLiveData<CommentModel> commentPost = new MutableLiveData<>();

    public LiveData<CommentModel> postComment() {
        return commentPost;

    }


    public void postCommentData(Map<String, String> headers, CommentModel model, int postId) {
        RetrofitService.getService().postComment(headers, model, postId).enqueue(new Callback<CommentModel>() {
            @Override
            public void onResponse(Call<CommentModel> call, Response<CommentModel> response) {
                if (response.isSuccessful()) {
                    commentPost.postValue(response.body());
                    Log.d("TAG", "postSuccess");
                }
            }

            @Override
            public void onFailure(Call<CommentModel> call, Throwable t) {
                Log.d("TAG", "" + t.getLocalizedMessage());
            }
        });


    }
}
