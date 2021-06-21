package com.example.salerenthomeproject.activies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.models.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private Button addPostButton;
    private TextInputEditText phone,description,attribute,rentOrSale;
    private EditText sq , bedCount, bathCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        phone = findViewById(R.id.phoneAdd);
        description = findViewById(R.id.descriptionAdd);
        attribute = findViewById(R.id.textInputEditText);
        rentOrSale = findViewById(R.id.rentOrSaleAdd);
        sq = findViewById(R.id.add_sq);
        bedCount = findViewById(R.id.add_beds);
        bathCount = findViewById(R.id.add_bath);


        addPostButton = findViewById(R.id.addPostBtn);


        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePost(phone.toString(),description.toString(),attribute.toString(),sq.toString(),rentOrSale.toString(),bedCount.toString(),bathCount.toString());
            }
        });

    }

    private void sharePost(String phoneNumber, String description, String attribute, String sq, String rentOrSale, String bedCount, String bathCount) {

        Map<String, Object> post = new HashMap<>();
        post.put("phone",phoneNumber);
        post.put("description",description);
        post.put("attribute",attribute);
        post.put("sq",sq);
        post.put("rentOrSale",rentOrSale);
        post.put("bedCount",bedCount);
        post.put("bathCount",bathCount);

        //Post postInstance = new Post(phoneNumber,description,attribute,sq,bedCount,rentOrSale,bathCount);



        db.collection("Post").add(post).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AddActivity.this,"Success",Toast.LENGTH_SHORT).show();
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