package com.example.androiddevelopertask.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_Comments")
public class CommentModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int post_id;
    private String comment;
    private String name;
    private String email;
    private String body;

    public CommentModel(int post_id, String comment, String name, String email, String body) {
        this.post_id = post_id;
        this.comment = comment;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
