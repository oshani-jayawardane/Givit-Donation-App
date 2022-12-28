package com.example.givitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyUploadActivity extends AppCompatActivity {

    Button Back;
    Button Home;
    Button Account;
    ImageView ed,de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_upload);

        Back = findViewById(R.id.button1);
        Home = findViewById(R.id.button2);
        Account = findViewById(R.id.button3);
        ed = findViewById(R.id.imageView3);
        de = findViewById(R.id.imageView5);
        ed = findViewById(R.id.imageView7);
        de = findViewById(R.id.imageView8);


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),UserAccountActivity.class);
                startActivity(i);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(I);
            }
        });


        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(getApplicationContext(),UserAccountActivity.class);
                startActivity(Int);
            }
        });

        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ied1 = new Intent(getApplicationContext(),EditUploadActivity.class);
                startActivity(Ied1);
            }
        });

        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ide1 = new Intent(getApplicationContext(),EditUploadActivity.class);
                startActivity(Ide1);
            }
        });

        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ied2 = new Intent(getApplicationContext(),EditUploadActivity.class);
                startActivity(Ied2);
            }
        });

        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ide2 = new Intent(getApplicationContext(),EditUploadActivity.class);
                startActivity(Ide2);
            }
        });


    }
}