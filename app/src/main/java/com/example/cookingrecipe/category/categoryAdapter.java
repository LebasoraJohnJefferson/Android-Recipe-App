package com.example.cookingrecipe.category;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookingrecipe.Meals.mealActivity;

import com.bumptech.glide.Glide;
import com.example.cookingrecipe.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.CategoryViewHolder> {
    String[] title;
    String[] descriptions;
    String[] image;
    Context context;

    public categoryAdapter(Context context, String[] title,String[] descriptions,String[] image) {
        this.title = title;
        this.context = context;
        this.descriptions=descriptions;
        this.image = image;
    }

    @NonNull
    @Override
    public categoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View view = layoutInflater.inflate( R.layout.category_label_design,parent,false);
        return new CategoryViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter.CategoryViewHolder holder,int position){
        holder.titleView.setText( title[position] );
        holder.descriptionView.setText( descriptions[position] );

        Glide.with(holder.itemView.getContext()).
                load( image[position] )
                .placeholder( R.drawable.ic_launcher_foreground )
                .into(holder.imageView);

        holder.seeMoreView.setOnClickListener( view -> {
            Intent intent = new Intent(context,mealActivity.class);
            intent.putExtra( "title",title[position] );
            context.startActivity( intent );
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView titleView;
        TextView descriptionView;
        ImageView imageView;
        Button seeMoreView;
        public CategoryViewHolder(@NonNull View itemView) {
            super( itemView );
            titleView = itemView.findViewById( R.id.categoryTitle );
            descriptionView = itemView.findViewById( R.id.categoryDescription );
            imageView = itemView.findViewById( R.id.categoryImage );
            seeMoreView = itemView.findViewById( R.id.seeMoreBtn );

        }
    }
}
