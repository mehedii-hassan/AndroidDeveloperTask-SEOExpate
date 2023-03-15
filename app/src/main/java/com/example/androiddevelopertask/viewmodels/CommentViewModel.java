package com.example.androiddevelopertask.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddevelopertask.daos.CommentPostDao;
import com.example.androiddevelopertask.db.MyDatabase;
import com.example.androiddevelopertask.models.CommentModel;
import com.example.androiddevelopertask.models.CommentResponseModel;
import com.example.androiddevelopertask.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentViewModel extends ViewModel {

    private MutableLiveData<List<CommentResponseModel>> commentResponseLiveData = new MutableLiveData<>();

    public LiveData<List<CommentResponseModel>> getPostResponseLiveDate() {
        return commentResponseLiveData;

    }


    public void loadCommentData(int postId) {

        RetrofitService.getService().getCommentsOfPost(postId).enqueue(new Callback<List<CommentResponseModel>>() {
            @Override
            public void onResponse(Call<List<CommentResponseModel>> call, Response<List<CommentResponseModel>> response) {
                if (response.code() == 200) {
                    commentResponseLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CommentResponseModel>> call, Throwable t) {

                Log.d("TAG", "error message " + t.getLocalizedMessage());

            }
        });


    }
}
