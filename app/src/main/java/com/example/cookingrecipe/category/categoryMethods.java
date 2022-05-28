package com.example.cookingrecipe.category;


import retrofit2.Call;
import retrofit2.http.GET;

public interface categoryMethods {
    @GET("api/json/v1/1/categories.php")
    Call<categoryModel> getAllCategories();
}


