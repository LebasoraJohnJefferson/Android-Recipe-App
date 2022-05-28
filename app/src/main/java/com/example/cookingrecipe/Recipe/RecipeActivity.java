package com.example.cookingrecipe.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.cookingrecipe.R;
import com.example.cookingrecipe.RetrofitClient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeActivity extends AppCompatActivity {
    private static final String TAG = "RecipeMethods";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recipe );
        Objects.requireNonNull( getSupportActionBar() ).setDisplayHomeAsUpEnabled( true );

        TextView mealView = findViewById( R.id.strMeal );
        TextView categoryView = findViewById( R.id.strCategory );
        TextView areaView = findViewById( R.id.strArea );
        ImageView youtubeView = findViewById( R.id.strYoutube );
        TextView ingredient1 = findViewById( R.id.strIngredient1 );
        TextView measure1 = findViewById( R.id.strMeasure1 );
        TextView instructions = findViewById( R.id.strInstructions );
        ImageView image = findViewById( R.id.strMealThumb );
        String mealID = getIntent().getStringExtra( "mealID" );


        RecipeMethods myRecipe = RetrofitClient.getRetrofitInstance().create( RecipeMethods.class );
        Call<RecipeModel> call = myRecipe.getMyRecipe(mealID);
        call.enqueue( new Callback<RecipeModel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<RecipeModel> call, @NonNull Response<RecipeModel> response) {
                assert response.body() != null;
                ArrayList<RecipeModel.meals> meals = response.body().meals;

                Glide.with(RecipeActivity.this).
                        load( meals.get( 0 ).getStrMealThumb() ).
                        placeholder( R.drawable.ic_launcher_foreground  )
                .into( image );
                instructions.setText(meals.get(0).getStrInstructions());
                mealView.setText(meals.get(0).getStrMeal());
                categoryView.setText( "Category: "+meals.get(0).getStrCategory() );
                areaView.setText( "Area: "+meals.get( 0 ).getStrArea() );
                youtubeView.setOnClickListener( view -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(meals.get( 0 ).getStrYoutube()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    startActivity(intent);
                } );
                ingredient1.setText(
                                meals.get( 0 ).getStrIngredient1()+"\n"
                                +meals.get( 0 ).getStrIngredient2()+"\n"
                                +meals.get( 0 ).getStrIngredient3()+"\n"
                                +meals.get( 0 ).getStrIngredient4()+"\n"
                                +meals.get( 0 ).getStrIngredient5()+"\n"
                                +meals.get( 0 ).getStrIngredient6()+"\n"
                                +meals.get( 0 ).getStrIngredient7()+"\n"
                                +meals.get( 0 ).getStrIngredient8()+"\n"
                                +meals.get( 0 ).getStrIngredient9()+"\n"
                                +meals.get( 0 ).getStrIngredient10()+"\n"
                                +meals.get( 0 ).getStrIngredient11()+"\n"
                                +meals.get( 0 ).getStrIngredient12()+"\n"
                                +meals.get( 0 ).getStrIngredient13()+"\n"
                                +meals.get( 0 ).getStrIngredient14()+"\n"
                                +meals.get( 0 ).getStrIngredient15()+"\n"
                                +meals.get( 0 ).getStrIngredient16()+"\n"
                                +meals.get( 0 ).getStrIngredient17()+"\n"
                                        +meals.get( 0 ).getStrIngredient18()+"\n"
                                        +meals.get( 0 ).getStrIngredient19()+"\n"
                                        +meals.get( 0 ).getStrIngredient20()+"\n" );
                measure1.setText(
                        meals.get( 0 ).getStrMeasure1()+"\n"
                        +meals.get( 0 ).getStrMeasure2()+"\n"
                                +meals.get( 0 ).getStrMeasure3()+"\n"
                                +meals.get( 0 ).getStrMeasure4()+"\n"
                                +meals.get( 0 ).getStrMeasure5()+"\n"
                                +meals.get( 0 ).getStrMeasure6()+"\n"
                                +meals.get( 0 ).getStrMeasure7()+"\n"
                                +meals.get( 0 ).getStrMeasure8()+"\n"
                                +meals.get( 0 ).getStrMeasure9()+"\n"
                                +meals.get( 0 ).getStrMeasure10()+"\n"
                                +meals.get( 0 ).getStrMeasure11()+"\n"
                                +meals.get( 0 ).getStrMeasure12()+"\n"
                                +meals.get( 0 ).getStrMeasure13()+"\n"
                                +meals.get( 0 ).getStrMeasure14()+"\n"
                                +meals.get( 0 ).getStrMeasure15()+"\n"
                                +meals.get( 0 ).getStrMeasure16()+"\n"
                                +meals.get( 0 ).getStrMeasure17()+"\n"
                                +meals.get( 0 ).getStrMeasure18()+"\n"
                                +meals.get( 0 ).getStrMeasure19()+"\n"
                                +meals.get( 0 ).getStrMeasure20()+"\n"
                );
            }

            @Override
            public void onFailure(@NonNull Call<RecipeModel> call, @NonNull Throwable t) {
                Log.e(TAG,"onFailure:"+ t.getMessage());
            }
        } );

    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}