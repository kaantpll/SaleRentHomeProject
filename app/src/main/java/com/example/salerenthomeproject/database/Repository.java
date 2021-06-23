package com.example.salerenthomeproject.database;

import com.example.salerenthomeproject.models.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class Repository implements RepositoryService{

    PostDao postDao;
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
