package com.example.salerenthomeproject.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.salerenthomeproject.adapters.HomeFragmentAdapter;

import java.util.Collections;

import io.reactivex.disposables.CompositeDisposable;



public class HomeFragmentViewModel extends ViewModel {


    private CompositeDisposable disposable = new CompositeDisposable();
    private HomeFragmentAdapter adapter  = new HomeFragmentAdapter(Collections.emptyList());




}
