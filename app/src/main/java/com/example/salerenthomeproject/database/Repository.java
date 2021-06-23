package com.example.salerenthomeproject.database;

import android.app.Application;

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
    public Flowable getAll() {
        return postDao.getAllPost();
    }

    @Override
    public Completable insert(Post post) {
        return postDao.insert(post);
    }

    @Override
    public Completable delete(Post post) {
        return postDao.delete(post);
    }
}
