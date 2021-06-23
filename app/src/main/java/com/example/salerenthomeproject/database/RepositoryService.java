package com.example.salerenthomeproject.database;

import com.example.salerenthomeproject.models.Post;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

public interface RepositoryService {

    Flowable getAll();
    Completable insert(Post post);
    Completable delete(Post post);

}
