package com.example.salerenthomeproject.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.adapters.FavoriteFragmentAdapter;
import com.example.salerenthomeproject.models.Post;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class FavoriteFragment extends Fragment {

    private RecyclerView rv;
    private FavoriteFragmentAdapter favoriteFragmentAdapter;
    private ArrayList<Post> favList;
    private FirebaseFirestore db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_favorite, container, false);

       db= FirebaseFirestore.getInstance();
       favList = new ArrayList<>();

        getDataFavoriteDatabase();

        rv = view.findViewById(R.id.recyclerViewFav);
       rv.setLayoutManager(new LinearLayoutManager(requireContext()));
       favoriteFragmentAdapter = new FavoriteFragmentAdapter(favList,favList);
        rv.setAdapter(favoriteFragmentAdapter);



        return view;
    }

    private void getDataFavoriteDatabase() {
        CollectionReference collectionReference = db.collection("Favorite");
        collectionReference.orderBy("attribute",Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value != null){
                    for (DocumentSnapshot snapshot : value.getDocuments()){
                        Map<String,Object> data = snapshot.getData();

                        String price = data.get("price").toString();
                        String imageUrl = data.get("imageURl").toString();
                        String attribute = data.get("attribute").toString();
                        String phone = data.get("phoneNumber").toString();
                        String bathCount = data.get("bathCount").toString();
                        String bedCount = data.get("bedCount").toString();
                        String description = data.get("description").toString();
                        String rentOrSale = data.get("rentOrSale").toString();
                        String sq = data.get("sq").toString();
                        String location = data.get("location").toString();
                        String latitude = data.get("latitude").toString();
                        String longitude = data.get("longitude").toString();
                        Post p = new Post(phone,description,attribute,sq,bedCount,rentOrSale,bathCount,imageUrl,price,location,latitude,longitude);
                        favList.add(p);
                        favoriteFragmentAdapter.notifyDataSetChanged();

                    }
                }
            }
        });
    }
}