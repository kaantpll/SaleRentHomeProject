package com.example.salerenthomeproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.salerenthomeproject.models.Post;

@Database(entities = {Post.class},version = 2,exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract PostDao postDao();

   private static final String DB_NAME = "postDb";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DatabaseHelper.class,DB_NAME
                    ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }


}
