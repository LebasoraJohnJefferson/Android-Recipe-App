package com.example.cookingrecipe.Meals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cookingrecipe.R;
import com.example.cookingrecipe.Recipe.RecipeActivity;

public class mealAdapter extends RecyclerView.Adapter<mealAdapter.mealViewHolder> {
    String[] Meal;
    String[] MealThumb;
    String[] idMeal;
    Context context;

    public mealAdapter(Context context, String[] Meal,String[] MealThumb,String[] idMeal) {
        this.Meal = Meal;
        this.context = context;
        this.MealThumb=MealThumb;
        this.idMeal = idMeal;
    }

    @NonNull
    @Override
    public mealAdapter.mealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View view = layoutInflater.inflate( R.layout.meal_label_design,parent,false);
        return new mealViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull mealAdapter.mealViewHolder holder, int position) {
        holder.mealTitleView.setText( Meal[position] );

        Glide.with(holder.itemView.getContext()).
                load( MealThumb[position] )
                .placeholder( R.drawable.ic_launcher_foreground )
                .into(holder.mealImageView);

        holder.seeRecipeBtnView.setOnClickListener( view -> {
            Intent intent = new Intent(context,RecipeActivity.class);
            intent.putExtra( "mealID",idMeal[position] );
            context.startActivity( intent );
        } );
    }

    @Override
    public int getItemCount() {
        return Meal.length;
    }

    public static class mealViewHolder extends RecyclerView.ViewHolder{
        TextView mealTitleView;
        ImageView mealImageView;
        Button seeRecipeBtnView;
        public mealViewHolder(@NonNull View itemView) {
            super( itemView );
            mealTitleView = itemView.findViewById( R.id.mealTitle );
            mealImageView = itemView.findViewById( R.id.mealImage );
            seeRecipeBtnView = itemView.findViewById( R.id.seeRecipeBtn );
        }
    }
}
