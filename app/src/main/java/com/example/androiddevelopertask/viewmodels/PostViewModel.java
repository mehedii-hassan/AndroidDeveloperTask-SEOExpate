package com.example.androiddevelopertask.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androiddevelopertask.models.PostResponseModel;
import com.example.androiddevelopertask.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    private MutableLiveData<List<PostResponseModel>> postResponseLiveData = new MutableLiveData<>();

    public LiveData<List<PostResponseModel>> getPostResponseLiveDate() {
        return postResponseLiveData;

    }

    public void loadPostData() {
        RetrofitService.getService().getPostResponse().enqueue(new Callback<List<PostResponseModel>>() {
            @Override
            public void onResponse(Call<List<PostResponseModel>> call, Response<List<PostResponseModel>> response) {
                if (response.code() == 200) {
                    postResponseLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PostResponseModel>> call, Throwable t) {
                Log.d("TAG", "error message " + t.getLocalizedMessage());

            }
        });

    }
}
