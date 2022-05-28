package com.example.cookingrecipe.category;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cookingrecipe.R;
import com.example.cookingrecipe.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class categoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    categoryAdapter adapter;

    private static final String TAG = "categoryMethods";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_category );

        categoryMethods myCategoryMethods = RetrofitClient.getRetrofitInstance().create(categoryMethods.class);
        Call<categoryModel> call = myCategoryMethods.getAllCategories();
        call.enqueue( new Callback<categoryModel>() {
            @Override
            public void onResponse(@NonNull Call<categoryModel> call, @NonNull Response<categoryModel> response) {
                assert response.body() != null;
                List<categoryModel.categories> categories = response.body().categories;
                String[] categoriesTitle = new String[categories.size()];
                String[] categoriesDescription = new String[categories.size()];
                String[] categoriesImage = new String[categories.size()];
                for (int i = 0; i < categories.size(); i++) {
                    categoriesTitle[i] = categories.get(i).getStrCategory();
                    categoriesDescription[i] = categories.get(i).getStrCategoryDescription();
                    categoriesImage[i] = categories.get(i).strCategoryThumb();
                }
                setUpCategory( categoriesTitle,categoriesDescription,categoriesImage );
            }

            @Override
            public void onFailure(@NonNull Call<categoryModel> call, @NonNull Throwable t) {
                Log.e(TAG,"onFailure:"+ t.getMessage());
            }
        } );
    }

    private void setUpCategory(String[] myTitle, String[] myDescription, String[] myImage){
        recyclerView = findViewById( R.id.categoryRecyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        adapter = new categoryAdapter(this,myTitle,myDescription,myImage);
        recyclerView.setAdapter( adapter );
    }
}