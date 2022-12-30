package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.givitapp.items.Item;
import com.example.givitapp.items.ItemDao;
import com.example.givitapp.items.ItemDataBase;
import com.example.givitapp.signup.User;
import com.example.givitapp.signup.UserDao;
import com.example.givitapp.signup.UserDataBase;

import java.util.ArrayList;
import java.util.List;

public class UploadItemActivity extends AppCompatActivity {

    private EditText editItemName, editItemDescription, editItemCategory, editItemQuantity;
    private Button btnItemUpload, btnItemView;
//    private RecyclerView itemRv;
    private List<Item> itemList = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_item);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        editItemName = findViewById(R.id.editTextItemName);
        editItemDescription = findViewById(R.id.editTextItemDescription);
        editItemCategory = findViewById(R.id.editTextItemCategory);
        editItemQuantity = findViewById(R.id.editTextItemQuantity);
        btnItemUpload = findViewById(R.id.btnUpload);
        btnItemView = findViewById(R.id.btnView);

        btnItemUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = new Item();

                item.setItemName(editItemName.getText().toString());
                item.setItemDescription(editItemDescription.getText().toString());
                item.setItemCategory(editItemCategory.getText().toString());
                item.setItemQuantity(Integer.parseInt(editItemQuantity.getText().toString()));
                itemList.add(item);
            }
        });

//        btnItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itemAdapter = new ItemAdapter(itemList);
//                itemRv.setLayoutManager(new LinearLayoutManager(UploadItemActivity.this));
//                itemRv.setAdapter(itemAdapter);
//            }
//        });

//        btnItemUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //creating Item Entity
//                Item item = new Item();
//                item.setItemName(editItemName.getText().toString());
//                item.setItemDescription(editItemDescription.getText().toString());
//                item.setItemCategory(editItemCategory.getText().toString());
//                item.setItemQuantity(Integer.parseInt(editItemQuantity.getText().toString()));
//
//
//                if (validate(item)) {
//                    //Do insert operation
//                    ItemDataBase itemDataBase = ItemDataBase.getItemDatabase(getApplicationContext());
//                    final ItemDao itemDao = itemDataBase.ItemDao();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Register User
//                            itemDao.insert(item);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(UploadItemActivity.this, "Item Added Successfully !", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//
//                        }
//                    }).start();
//                } else {
//                    Toast.makeText(UploadItemActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    private Boolean validate (Item item){
        if (item.getItemName().isEmpty() || item.getItemDescription().isEmpty() || item.getItemCategory().isEmpty()) {
            return false;
        }
        return true;
    }

}