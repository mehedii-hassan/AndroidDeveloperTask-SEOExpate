package com.example.androiddevelopertask.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androiddevelopertask.daos.CommentPostDao;
import com.example.androiddevelopertask.models.CommentModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CommentModel.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {


    private static MyDatabase db;
    public static ExecutorService backgroundService = Executors.newFixedThreadPool(5);

    public abstract CommentPostDao getCommentPostDao();

    public static MyDatabase getDb(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "TourEventsDb")
                    .allowMainThreadQueries().build();
        }
        return db;
    }
}
