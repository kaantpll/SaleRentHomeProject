package com.example.salerenthomeproject.database;

import androidx.lifecycle.LiveData;

import com.example.salerenthomeproject.models.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

public interface RepositoryService {

    LiveData<List<Post>> getAll();
    void insert(Post post);
    void delete(Post post);

}
