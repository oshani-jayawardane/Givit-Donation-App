package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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

public class UploadItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_item);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        EditText item_name, description, category, quantity;
        Button upload;

        item_name = findViewById(R.id.editTextItemName);
        description = findViewById(R.id.editTextItemDescription);
        category = findViewById(R.id.editTextItemCategory);
        quantity = findViewById(R.id.editTextItemQuantity);
        upload = findViewById(R.id.btnUpload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating Item Entity
                Item item = new Item();
                item.setItemName(item_name.getText().toString());
                item.setItemDescription(description.getText().toString());
                item.setItemCategory(category.getText().toString());
                item.setItemQuantity(Integer.parseInt(quantity.getText().toString()));


                if (validate(item)) {
                    //Do insert operation
                    ItemDataBase itemDataBase = ItemDataBase.getItemDatabase(getApplicationContext());
                    final ItemDao itemDao = itemDataBase.ItemDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            itemDao.insert(item);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(UploadItemActivity.this, "Item Added Successfully !", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();
                } else {
                    Toast.makeText(UploadItemActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Boolean validate (Item item){
        if (item.getItemName().isEmpty()
                || item.getItemDescription().isEmpty()
                || item.getItemCategory().isEmpty()) {
            return false;
        }
        return true;
    }

}