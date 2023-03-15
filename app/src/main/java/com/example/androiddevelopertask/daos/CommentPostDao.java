package com.example.androiddevelopertask.daos;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.androiddevelopertask.models.CommentModel;

@Dao
public interface CommentPostDao {

    @Insert
    void insertCommentPost(CommentModel commentModel);

}
