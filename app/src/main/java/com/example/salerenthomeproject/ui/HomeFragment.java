package com.example.salerenthomeproject.ui;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.adapters.HomeFragmentAdapter;
import com.example.salerenthomeproject.models.Post;
import com.example.salerenthomeproject.viewmodel.HomeFragmentViewModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment {

    private FirebaseFirestore db;
    private HomeFragmentAdapter adapter;
    private ArrayList<Post> posts;
    private RecyclerView rv;
    private HomeFragmentViewModel homeFragmentViewModel;
    private TextView result;

    public HomeFragment(){}

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_home, container, false);

        result = view.findViewById(R.id.result_count);
        db = FirebaseFirestore.getInstance();

        homeFragmentViewModel= new ViewModelProvider((ViewModelStoreOwner) requireContext()).get(HomeFragmentViewModel.class);

        posts = new ArrayList<>();



        getDataFromFirebase();
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new HomeFragmentAdapter(posts,requireContext());

        rv.setAdapter(adapter);



        return  view;
    }

    public void getDataFromFirebase(){
        CollectionReference collectionReference = db.collection("Post");

        collectionReference.orderBy("price", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    if(value != null){
                        for (DocumentSnapshot snapshot : value.getDocuments()){
                            Map<String,Object> data = snapshot.getData();

                            String price = data.get("price").toString();
                            String imageUrl = data.get("imageUrl").toString();
                            String attribute = data.get("attribute").toString();
                            String phone = data.get("phone").toString();
                            String bathCount = data.get("bathCount").toString();
                            String bedCount = data.get("bedCount").toString();
                            String description = data.get("description").toString();
                            String rentOrSale = data.get("rentOrSale").toString();
                            String sq = data.get("sq").toString();
                            String location = data.get("location").toString();
                            String latitude = data.get("latitude").toString();
                            String longitude = data.get("longitude").toString();
                            Post p = new Post(phone,description,attribute,sq,bedCount,rentOrSale,bathCount,imageUrl,price,location,latitude,longitude);

                            posts.add(p);
                            adapter.notifyDataSetChanged();

                            result.setText(posts.size()+" post found.");
                            Log.d("size", String.valueOf(posts.size()));

                        }
                    }
            }
        });
    }
}