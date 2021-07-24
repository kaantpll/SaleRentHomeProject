package com.example.salerenthomeproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.salerenthomeproject.database.Repository;
import com.example.salerenthomeproject.models.Post;

import java.util.List;


public class HomeFragmentViewModel extends AndroidViewModel {


    private Repository repo;
    private MutableLiveData<List<Post>> postList;

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


   public  LiveData<List<Post>> search(String q){
        return  repo.search(q);
   }

}

