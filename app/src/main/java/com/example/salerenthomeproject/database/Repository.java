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
        new InsertAsyncTask().execute(post);
    }

    @Override
    public void delete(Post post) {
        postDao.insert(post);
    }/*
    static class InsertAsyncTask extends AsyncTask<List<Post>,Void,Void> {
        private PostDao postDao;
        InsertAsyncTask(DatabaseHelper db)
        {
            postDao=db.postDao();
        }
        @Override
        protected Void doInBackground(List<Post>... lists) {
            postDao.insert((Post) lists[0]);
            return null;
        }
    }*/
    static class InsertAsyncTask extends AsyncTask<Post,Void,Void>{
        PostDao postDao;

        @Override
        protected Void doInBackground(Post... posts) {
            postDao.insert(posts[0]);
            return  null;
        }
    }
}

