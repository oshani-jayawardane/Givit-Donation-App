package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //Identify the buttons
        Button btnCategories = findViewById(R.id.btnNavCategories);
        Button btnUpload = findViewById(R.id.btnNavUpload);
        Button btnEditUpload = findViewById(R.id.btnNavEditUpload);
        Button btnAccount = findViewById(R.id.btnNavAccount);

        // Add a click listener to the buttons
        btnCategories.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(categoryIntent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(HomeActivity.this, UploadItemActivity.class);
                startActivity(categoryIntent);
            }
        });

        btnEditUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(HomeActivity.this, EditUploadActivity.class);
                startActivity(categoryIntent);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(HomeActivity.this, UserAccountActivity.class);
                startActivity(categoryIntent);
            }
        });

    }
}