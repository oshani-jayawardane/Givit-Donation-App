package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.givitapp.items.Item;
import com.example.givitapp.items.ItemDao;
import com.example.givitapp.items.ItemDataBase;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView itemRv;
    private ItemAdapter itemAdapter;

    private List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        itemRv = findViewById(R.id.list_view_layout);
        itemRv.setLayoutManager(new LinearLayoutManager(CategoryActivity.this));


        ItemDataBase itemDataBase = ItemDataBase.getItemDatabase(getApplicationContext());
        final ItemDao itemDao = itemDataBase.itemDao();

        itemDao.getAll().observe(this, items -> {
            for ( Item I : items ) {
                System.out.println(I.getItemName());
                System.out.println(I.getItemDescription());
            }


            itemAdapter = new ItemAdapter(items);
            itemRv.setAdapter(itemAdapter);
        });

        //Identify the cards
//        FrameLayout itemCard = findViewById(R.id.itemCard);
//
//        itemCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent categoryIntent = new Intent(CategoryActivity.this, RequestActivity.class);
//                startActivity(categoryIntent);
//            }
//        });

        //Identify the text view
//        TextView categoryName = findViewById(R.id.nameCategory);
//        categoryName.setText(getIntent().getStringExtra("category_name"));

    }
}