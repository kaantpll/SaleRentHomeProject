package com.example.salerenthomeproject.ui;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salerenthomeproject.R;
import com.squareup.picasso.Picasso;

public class DescriptionFragment extends Fragment {

    private TextView attributeText,priceText,bedCount,bathCount,sq,sentOrRate;
    private ImageView callPhone,addFavorite,homeImage,backImage;
    private Button sendMessage;
    private DescriptionFragmentArgs args ;
    private NavController controller;

    public DescriptionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_description, container, false);
        args =DescriptionFragmentArgs.fromBundle(getArguments());

        controller= Navigation.findNavController((Activity) requireContext(),R.id.containerFragment);


        attributeText = view.findViewById(R.id.description_attribute);
        priceText = view.findViewById(R.id.description_price);
        bedCount = view.findViewById(R.id.descriptionBedCount);
        bathCount = view.findViewById(R.id.descriptionBathCount);
        sq = view.findViewById(R.id.descriptionSq);
        homeImage = view.findViewById(R.id.description_imageView);

        backImage = view.findViewById(R.id.backImage);
        callPhone = view.findViewById(R.id.callImageView);
        addFavorite = view.findViewById(R.id.favImageView);

        sendMessage = view.findViewById(R.id.sendMessage);

        attributeText.setText(args.getPost().getAttribute());
        priceText.setText(args.getPost().getPrice());
        bedCount.setText(args.getPost().getBedCount());
        bathCount.setText(args.getPost().getBathCount());

        Picasso.get().load(args.getPost().getImageUrl()).into(homeImage);
        sq.setText(args.getPost().getSq());

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            controller.navigate(R.id.action_descriptionFragment_to_homeFragment);
            }
        });

        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gönder
            }
        });

        return  view;
    }
}