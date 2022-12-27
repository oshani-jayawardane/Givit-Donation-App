package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Array;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        String[] categories = {"Food and Groceries", "Kitchen Utensils", "Furniture", "Home Accessories", "Cloths and Accessories", "Books and Stationery", "Electronic Items", "Sports Items", "Musical Instruments", "Pets"};
//
//        for (String category:categories) {
//
//        }
        //Identify the buttons
        FrameLayout btnCategory = findViewById(R.id.frame1);

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                startActivity(categoryIntent);
            }
        });

    }
}