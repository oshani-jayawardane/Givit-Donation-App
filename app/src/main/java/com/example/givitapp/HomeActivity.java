package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.givitapp.signup.User;

public class HomeActivity extends AppCompatActivity {

    TextView Namedisplay;
    Button btnAcc, donateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        Namedisplay = findViewById(R.id.NameText);
        btnAcc = findViewById(R.id.btnAccount);
        donateButton = findViewById(R.id.btnDonate);

        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent donateIntent = new Intent(HomeActivity.this,UploadItemActivity.class);
                startActivity(donateIntent);
            }
        });

        // receive Intents
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String number = intent.getStringExtra("number");
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("user");
        Namedisplay.setText(name);


        final FrameLayout[] btnCategory = new FrameLayout[10];

        String[] categories = {"Furniture", "Home Accessories", "Cloths and Accessories", "Books and Stationery", "Electronic Items", "Sports Items", "Kitchen Utensils"};

        int[] frames = {R.id.frame1, R.id.frame2, R.id.frame3, R.id.frame4, R.id.frame5, R.id.frame6, R.id.frame7};

        for (int i = 0; i < frames.length; i++) {
            //Identify the buttons
            btnCategory[i] = findViewById(frames[i]);

            int finalI = i;
            btnCategory[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(HomeActivity.this, CategoryActivity.class);
                    String strCategory = categories[finalI];
                    categoryIntent.putExtra("category_name", strCategory);
                    startActivity(categoryIntent);
                }
            });

        }
        FrameLayout frameDots = findViewById(R.id.frame8);
        frameDots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoriesIntent = new Intent(HomeActivity.this,CategoriesActivity.class);
                startActivity(categoriesIntent);
            }
        });





        //Account set on clicklistener
//        btnAcc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent accountIntent = new Intent(getApplicationContext(), Profile.class);
//                accountIntent.putExtra("namekey", name);
//                accountIntent.putExtra("emailkey", email);
//                accountIntent.putExtra("numberkey", number);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("userkey", user);
//                accountIntent.putExtras(bundle);
//                startActivity(accountIntent);
//            }
//        });


    }
}