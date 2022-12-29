package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        final FrameLayout[] btnCategory = new FrameLayout[10];

        String[] categories = {"Food and Groceries", "Kitchen Utensils", "Furniture", "Home Accessories", "Cloths and Accessories", "Books and Stationery", "Electronic Items", "Sports Items", "Musical Instruments", "Pets"};

        int[] frames = {R.id.frame1, R.id.frame2, R.id.frame3, R.id.frame4, R.id.frame5, R.id.frame6, R.id.frame7, R.id.frame8, R.id.frame9, R.id.frame10};

        for (int i = 0; i < frames.length; i++) {
            //Identify the buttons
            btnCategory[i] = findViewById(frames[i]);

            int finalI = i;
            btnCategory[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                    String strCategory = categories[finalI];
                    categoryIntent.putExtra("category_name", strCategory);
                    startActivity(categoryIntent);
                }
            });
        }


    }
}