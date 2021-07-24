package com.example.salerenthomeproject.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salerenthomeproject.R;
import com.example.salerenthomeproject.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragmentAdapter  extends RecyclerView.Adapter<FavoriteFragmentAdapter.MyViewHolder>{

    public List<Post> favoriteList;
    private ArrayList<Post> contextA;
    public FavoriteFragmentAdapter(List<Post> postList, ArrayList<Post> context){
        this.contextA = context;
        this.favoriteList = postList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post postModel = favoriteList.get(position);
        Picasso.get().load(postModel.getImageUrl()).into(holder.homeImage);
        holder.price.setText(postModel.getPrice()+" TL");
        holder.location.setText(postModel.getLocation());
        holder.homeAttribute.setText(postModel.getAttribute());
        holder.bath.setText(postModel.getBathCount()+"Baths");
        holder.bed.setText(postModel.getBedCount()+"Bed");
        holder.sq.setText(postModel.getSq()+"Sqft");

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView homeAttribute,location,price,bath,bed,sq;
        public ImageView homeImage;
        public ViewGroup mContainer;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setFocusable(true);
            itemView.setEnabled(true);


            homeAttribute = itemView.findViewById(R.id.card_home_description);
            location = itemView.findViewById(R.id.card_location);
            price = itemView.findViewById(R.id.card_price);
            bath = itemView.findViewById(R.id.card_bath_textView);
            bed = itemView.findViewById(R.id.card_bed_textView);
            sq = itemView.findViewById(R.id.card_sq_textView);

            homeImage = itemView.findViewById(R.id.card_imageView);

        }
    }

}
