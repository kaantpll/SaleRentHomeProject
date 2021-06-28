package com.example.salerenthomeproject.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.salerenthomeproject.adapters.HomeFragmentAdapter;
import com.example.salerenthomeproject.database.Repository;
import com.example.salerenthomeproject.models.Post;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import kotlinx.coroutines.flow.Flow;


public class HomeFragmentViewModel extends AndroidViewModel {



    private Repository repo;


    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
        repo = new Repository(application);
    }


    public void insert(Post post){
        repo.insert(post);
    }
    public void delete(Post post){
        repo.delete(post);
    }

    public LiveData<List<Post>> getAll(){
        return repo.getAll();
    }
    public LiveData<List<Post>> search(String query){
        return  repo.search(query);
    }


}

