package com.example.salerenthomeproject.activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.salerenthomeproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.getMenu().getItem(2).isEnabled();
        bottomNavigationView.getItemRippleColor();

        NavController navController = Navigation.findNavController(this,R.id.containerFragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
}