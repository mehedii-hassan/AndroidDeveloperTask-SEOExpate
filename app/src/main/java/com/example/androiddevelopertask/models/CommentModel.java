package com.example.androiddevelopertask.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_Comments")
public class CommentModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String comment;

    public CommentModel(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
