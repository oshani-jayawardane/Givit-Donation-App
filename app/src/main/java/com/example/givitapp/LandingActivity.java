package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //Identify the button
        Button signupButton = findViewById(R.id.btnSignUp);
        TextView signinButton = findViewById(R.id.btnTxtSignIn);

        // Add a click listener to the button
        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(LandingActivity.this, SignUpActivity.class);
                startActivity(categoryIntent);
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent categoryIntent = new Intent(LandingActivity.this, SignInActivity.class);
                startActivity(categoryIntent);
            }
        });
    }
}