package com.example.cookingrecipe.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface mealMethods {
        @GET("api/json/v1/1/filter.php")
        Call<mealModel> getMyMeals(@Query( "c" ) String title);
}
