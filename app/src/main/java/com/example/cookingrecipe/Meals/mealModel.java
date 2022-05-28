package com.example.cookingrecipe.Meals;


import java.util.ArrayList;

public class mealModel {

    ArrayList<meals> meals;


    public static class meals{
        String strMeal,strMealThumb,idMeal;

        public String getStrMeal() {
            return strMeal;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        public String getIdMeal() {
            return idMeal;
        }
    }
}
