package com.example.cookingrecipe.Recipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeMethods {
    @GET("api/json/v1/1/lookup.php")
    Call<RecipeModel> getMyRecipe(@Query( "i" ) String mealID);
}
