package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.givitapp.items.Item;
import com.example.givitapp.items.ItemDao;
import com.example.givitapp.items.ItemDataBase;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    TextView TxtItemName, TxtItemDescription, TxtItemCategory, TxtItemQuantity;
    Button btnRequest;
    private List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        TxtItemName = findViewById(R.id.itemTitle);
        TxtItemDescription = findViewById(R.id.itemDescription);
        TxtItemCategory = findViewById(R.id.itemCategory);
        TxtItemQuantity = findViewById(R.id.itemQuantity);
        btnRequest = findViewById(R.id.btnRequest);

        ItemDataBase itemDataBase = ItemDataBase.getItemDatabase(getApplicationContext());
        final ItemDao itemDao = itemDataBase.itemDao();

        int itemId = getIntent().getIntExtra("ID", 1);
        itemDao.get(itemId).observe(this, (item -> {
            TxtItemName.setText(item.getItemName());
            TxtItemDescription.setText(item.getItemDescription());
            TxtItemCategory.setText(item.getItemCategory());
            TxtItemQuantity.setText(item.getItemQuantity() + "");
        }));

//        btnRequest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent categoryIntent = new Intent(RequestActivity.this, ChatActivity.class);
//                startActivity(categoryIntent);
//            }
//        });

    }
}