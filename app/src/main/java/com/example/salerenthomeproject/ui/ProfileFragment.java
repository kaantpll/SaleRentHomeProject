package com.example.salerenthomeproject.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.salerenthomeproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ProfileFragment extends Fragment {



    private TextView userName,email,phoneNumber,age;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore db;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        userName = view.findViewById(R.id.usernameProfile);
        email = view.findViewById(R.id.emailProfile);
        phoneNumber = view.findViewById(R.id.phoneNumberProfile);
        age = view.findViewById(R.id.ageProfile);

        getUserData(view);






        return  view;
    }

    public void getUserData(View v){
        db.collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    List<DocumentSnapshot> post = task.getResult().getDocuments();


                    

                    Snackbar.make(v,"Listed",3000).show();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            e.printStackTrace();
            }
        });
    }
}