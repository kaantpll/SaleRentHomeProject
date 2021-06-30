package com.example.salerenthomeproject.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.models.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {



    private TextView userName,email,phoneNumber,age;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore db;
   private ArrayList<Post> userList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
        userList = new ArrayList<>();

        userName = view.findViewById(R.id.usernameProfile);
        email = view.findViewById(R.id.emailProfile);
        phoneNumber = view.findViewById(R.id.phoneNumberProfile);
        age = view.findViewById(R.id.ageProfile);



        getUserData(userName,email,phoneNumber,age);





        return  view;
    }

    public void getUserData(TextView usernameText,TextView emailText,TextView phoneNumber , TextView ageText){



        db.collection("User").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.isEmpty()){
                    Log.d("Error "," while fetch data error");
                    return;
                }
                else{
                    List<DocumentSnapshot> snapshots = queryDocumentSnapshots.getDocuments();

                    for(int i =0;i<snapshots.size();i++){

                        String nameUser = snapshots.get(i).get("username").toString();
                        String phoneNumberUser = snapshots.get(i).get("phoneNumber").toString();
                        String ageUser = snapshots.get(i).get("age").toString();
                        String emailUser = snapshots.get(i).get("email").toString();

                       usernameText.setText(nameUser);
                       emailText.setText(emailUser);
                       phoneNumber.setText(phoneNumberUser);
                       ageText.setText(ageUser);

                    }
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