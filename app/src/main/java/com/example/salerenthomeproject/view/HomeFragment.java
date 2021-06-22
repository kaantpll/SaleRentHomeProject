package com.example.salerenthomeproject.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.adapters.HomeFragmentAdapter;
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

public class HomeFragment extends Fragment {

    private FirebaseFirestore db;
    private HomeFragmentAdapter adapter;
    private ArrayList<Post> posts;
    private RecyclerView rv;

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);

        db = FirebaseFirestore.getInstance();

        posts = new ArrayList<Post>();

        getDataFromFirebase();
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new HomeFragmentAdapter(posts);
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

                            Post p = new Post(phone,description,attribute,sq,bedCount,rentOrSale,bathCount,imageUrl,price);

                            posts.add(p);
                            adapter.notifyDataSetChanged();
                        }
                    }
            }
        });
    }
}