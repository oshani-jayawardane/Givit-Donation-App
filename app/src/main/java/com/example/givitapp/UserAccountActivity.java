package com.example.givitapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.givitapp.signup.User;

public class UserAccountActivity extends AppCompatActivity {

    TextView userName, userEmail, userNumber;
    ImageView imageView;
    Bitmap bmpImage;
    Button takePic, savePic, uploadItemBtn, myUploadsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        userName = findViewById(R.id.profileName);
        userEmail = findViewById(R.id.profileEmail);
        userNumber = findViewById(R.id.profileNumber);
        imageView = findViewById(R.id.userImage);
        takePic=findViewById(R.id.btnTakepic);
        bmpImage = null;
        uploadItemBtn = findViewById(R.id.btnUploadItems);
        myUploadsBtn = findViewById(R.id.btnMyUploads);

        Intent i = getIntent();
        String name = i.getStringExtra("namekey");
        String email = i.getStringExtra("emailkey");
        String number = i.getStringExtra("numberkey");
        Bundle bundle = i.getExtras();
        User user = (User) bundle.getSerializable("userkey");
        userName.setText(name);
        userEmail.setText(email);
        userNumber.setText(number);

        uploadItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadIntent = new Intent(UserAccountActivity.this, UploadItemActivity.class);
                startActivity(uploadIntent);
            }
        });

        myUploadsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myUploadsIntent = new Intent(UserAccountActivity.this, MyUploadsActivity.class);
                startActivity(myUploadsIntent);
            }
        });


//        savePic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(bmpImage == null){
//                    Toast.makeText(getApplicationContext(), "Image missing", Toast.LENGTH_SHORT).show();
//                }
//                else{
//
//                    user.setImage(DataConverter.convertImage2ByteArray(bmpImage));
//                }
//            }
//        });

    }

    final int CAMERA_INTENT = 51;
    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAMERA_INTENT);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_INTENT:
                if(resultCode == Activity.RESULT_OK){
                    bmpImage = (Bitmap) data.getExtras().get("data");
                    if(bmpImage !=null){
                        imageView.setImageBitmap(bmpImage);
                    }
                }
                break;

        }
    }

//    public void savePicture(View view) {
//
//        if(bmpImage == null){
//            Toast.makeText(this, "Image missing", Toast.LENGTH_SHORT).show();
//        }
//        else{
//
//            user.setImage(DataConverter.convertImage2ByteArray(bmpImage));
//        }
//    }

}
