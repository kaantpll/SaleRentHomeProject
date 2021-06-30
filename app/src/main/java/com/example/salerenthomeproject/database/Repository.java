package com.example.salerenthomeproject.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.salerenthomeproject.models.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class Repository implements RepositoryService{

    PostDao postDao;

    public Repository(Application application){
        DatabaseHelper db = DatabaseHelper.getInstance(application);
        postDao = db.postDao();
    }


    @Override
    public LiveData<List<Post>> getAll() {
        return postDao.getAllPost();
    }

    @Override
    public void insert(Post post) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                postDao.insert(post);

            }
        }).start();
    }

    @Override
    public void delete(Post post) {
        postDao.insert(post);
    }

    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    @Override
    public LiveData<List<Post>> search(String query) {
        return postDao.search(query);

    }

}

