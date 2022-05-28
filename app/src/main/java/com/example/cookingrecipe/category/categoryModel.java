package com.example.cookingrecipe.category;

import java.util.ArrayList;

public class categoryModel {
    ArrayList<categories> categories;


    public static class categories{
        String strCategory;
        String strCategoryDescription;
        String strCategoryThumb;

        public String getStrCategoryDescription() {
            return strCategoryDescription;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public String strCategoryThumb() {
            return strCategoryThumb;
        }
    }
}
