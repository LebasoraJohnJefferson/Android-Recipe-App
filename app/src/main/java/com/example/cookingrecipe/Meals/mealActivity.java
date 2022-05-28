package com.example.cookingrecipe.Meals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cookingrecipe.R;
import com.example.cookingrecipe.RetrofitClient;


import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class mealActivity extends AppCompatActivity {
    mealAdapter adapter;
    RecyclerView recyclerView;

    private static final String TAG = "mealsMethods";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_meal );
        Objects.requireNonNull( getSupportActionBar() ).setDisplayHomeAsUpEnabled( true );


        String title = getIntent().getStringExtra( "title" );

        mealMethods myMeals = RetrofitClient.getRetrofitInstance().create( mealMethods.class );
        Call<mealModel> call = myMeals.getMyMeals(title);
        call.enqueue( new Callback<mealModel>() {
            @Override
            public void onResponse(@NonNull Call<mealModel> call, @NonNull Response<mealModel> response) {
                assert response.body() !=null;
                List<mealModel.meals> meals = response.body().meals;
                String[] Meal = new String[meals.size()];
                String[] MealThumb = new String[meals.size()];
                String[] idMeal = new String[meals.size()];
                for (int i = 0; i < meals.size(); i++) {
                    Meal[i] = meals.get(i).getStrMeal();
                    MealThumb[i] = meals.get(i).getStrMealThumb();
                    idMeal[i] = meals.get( i ).getIdMeal();
                }
                setUpMeals( Meal,MealThumb,idMeal );
            }

            @Override
            public void onFailure(@NonNull Call<mealModel> call, @NonNull Throwable t) {
                Log.e(TAG,"onFailure:"+ t.getMessage());
            }
        } );

    }

    private void setUpMeals(String[] Meal, String[] MealThumb, String[] idMeal){
        recyclerView = findViewById( R.id.mealRecyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        adapter = new mealAdapter(this,Meal,MealThumb,idMeal);
        recyclerView.setAdapter( adapter );
    }


}