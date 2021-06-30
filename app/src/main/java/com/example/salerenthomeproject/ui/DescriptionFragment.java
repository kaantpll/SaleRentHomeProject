package com.example.salerenthomeproject.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.models.Post;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class DescriptionFragment extends Fragment {

    private TextView attributeText;
    private TextView priceText;
    private TextView bedCount;
    private TextView bathCount;
    private TextView sq,scrollViewText;
    private TextView sentOrRate;
    private TextView location;
    private String latitude,longitude;
    private ImageView callPhone,addFavorite,homeImage,backImage,goMap;
    private Button sendMessage;
    private DescriptionFragmentArgs args ;
    private NavController controller;
    private FirebaseFirestore db;

    public DescriptionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_description, container, false);
        args =DescriptionFragmentArgs.fromBundle(getArguments());

        db = FirebaseFirestore.getInstance();
        controller= Navigation.findNavController((Activity) requireContext(),R.id.containerFragment);
        BottomAppBar navBar = getActivity().findViewById(R.id.bottomAppBar);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);

        navBar.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);


        scrollViewText = view.findViewById(R.id.scrollViewText);
        attributeText = view.findViewById(R.id.description_attribute);
        priceText = view.findViewById(R.id.description_price);
        bedCount = view.findViewById(R.id.descriptionBedCount);
        bathCount = view.findViewById(R.id.descriptionBathCount);
        sq = view.findViewById(R.id.descriptionSq);
        homeImage = view.findViewById(R.id.description_imageView);
        location = view.findViewById(R.id.description_location);
        backImage = view.findViewById(R.id.backImage);
        callPhone = view.findViewById(R.id.callImageView);
        addFavorite = view.findViewById(R.id.favImageView);
        goMap = view.findViewById(R.id.goMap);


        sentOrRate = view.findViewById(R.id.descriptionSaleOrRate);
        longitude = args.getPost().getLongitude();
        latitude = args.getPost().getLatitude();
        attributeText.setText(args.getPost().getAttribute());
        priceText.setText(args.getPost().getPrice());
        bedCount.setText(args.getPost().getBedCount());
        sentOrRate.setText(args.getPost().getRentOrSale());
        bathCount.setText(args.getPost().getBathCount());
        location.setText(args.getPost().getLocation());
        Picasso.get().load(args.getPost().getImageUrl()).into(homeImage);
        scrollViewText.setText(args.getPost().getDescription());
        sq.setText(args.getPost().getSq());


        final NavController navController = Navigation.findNavController(getActivity(),R.id.containerFragment);
        goMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post p = new Post(args.getPost().getPhone(),args.getPost().getDescription(),args.getPost().getAttribute(),args.getPost().getSq(),
                        args.getPost().getBedCount(),args.getPost().getRentOrSale(),args.getPost().getRentOrSale(),args.getPost().getImageUrl(),args.getPost().getPrice()
                ,args.getPost().getLocation(),args.getPost().getLatitude(),args.getPost().getLongitude());
                DescriptionFragmentDirections.ActionDescriptionFragmentToMapsFragment action = DescriptionFragmentDirections.actionDescriptionFragmentToMapsFragment(p);
                navController.navigate(action);
            }
        });

        Uri c = Uri.parse("tel:" + args.getPost().getPhone());

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navBar.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                controller.navigate(R.id.action_descriptionFragment_to_homeFragment);

            }
        });

        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(c);
            startActivity(call);
            }
        });

        addFavorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return  view;
    }


}