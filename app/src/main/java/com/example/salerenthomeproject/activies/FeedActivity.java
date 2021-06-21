package com.example.salerenthomeproject.activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.salerenthomeproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FeedActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);


        fab = findViewById(R.id.fab);

        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
        bottomNavigationView.getItemRippleColor();

        NavController navController = Navigation.findNavController(this,R.id.containerFragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(FeedActivity.this,AddActivity.class);
                startActivity(a);
            }
        });


    }
}