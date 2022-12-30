package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.givitapp.items.Item;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    TextView TxtItemName, TxtItemDescription, TxtItemCategory, TxtItemQuantity;
    private List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        TxtItemName.setText();
//        TxtItemDescription.setText();
//        TxtItemCategory.setText();
//        TxtItemQuantity.setText();

    }
}