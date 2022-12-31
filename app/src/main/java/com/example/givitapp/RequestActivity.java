package com.example.givitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.givitapp.items.Item;
import com.example.givitapp.items.ItemDao;
import com.example.givitapp.items.ItemDataBase;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    TextView TxtItemName, TxtItemDescription, TxtItemCategory, TxtItemQuantity;
    Button btnRequest;
    ImageView btnMessages, btnPhone;
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
        btnMessages = findViewById(R.id.messageIcon);
        btnPhone = findViewById(R.id.phoneIcon);

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

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the intent with the ACTION_DIAL action
                Intent intent = new Intent(Intent.ACTION_DIAL);

                // Set the data for the intent to the phone number Uri
                intent.setData(Uri.parse("tel:1234567890"));

                // Verify that the intent will resolve to an activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the intent with the ACTION_SENDTO action
                Intent intent = new Intent(Intent.ACTION_SENDTO);

                // Set the data for the intent to the message recipient Uri
                intent.setData(Uri.parse("smsto:1234567890"));

                // Set the message body
                intent.putExtra("sms_body", "Hi, I'm interested in the item you posted on Givit!");

                // Verify that the intent will resolve to an activity
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}