package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //Identify the cards
        FrameLayout itemCard = findViewById(R.id.itemCard);

        itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent categoryIntent = new Intent(CategoryActivity.this, RequestActivity.class);
                startActivity(categoryIntent);
            }
        });

        //Identify the text view
        TextView categoryName = findViewById(R.id.nameCategory);
        categoryName.setText(getIntent().getStringExtra("category_name"));

    }
}