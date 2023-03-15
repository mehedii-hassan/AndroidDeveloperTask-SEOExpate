package com.example.androiddevelopertask.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.androiddevelopertask.daos.CommentPostDao;
import com.example.androiddevelopertask.db.MyDatabase;
import com.example.androiddevelopertask.models.CommentModel;

public class CommentViewModelTwo extends AndroidViewModel {
    private final CommentPostDao commentPostDao;


    public CommentViewModelTwo(@NonNull Application application) {
        super(application);
        commentPostDao = MyDatabase.getDb(application).getCommentPostDao();

    }

    public void addPostComment(CommentModel commentModel) {
        MyDatabase.backgroundService.execute(new Runnable() {
            @Override
            public void run() {
                //codes within this block will run on background thread.
                commentPostDao.insertCommentPost(commentModel);
            }
        });
    }
}