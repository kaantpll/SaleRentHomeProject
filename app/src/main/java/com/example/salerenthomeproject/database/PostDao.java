package com.example.salerenthomeproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.salerenthomeproject.models.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     Completable insert(Post post);

    @Delete
    Completable delete(Post post);
/*
    @Query("select * from posts where attribute")
    Post findByName(String s);
*/
    @Query("Select * from posts")
    Flowable<List<Post>> getAllPost();


}
