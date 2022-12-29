package com.example.givitapp.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.givitapp.R;
import com.example.givitapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}