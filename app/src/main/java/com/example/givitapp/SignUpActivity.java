package com.example.givitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.givitapp.signup.User;
import com.example.givitapp.signup.UserDao;
import com.example.givitapp.signup.UserDataBase;

public class SignUpActivity extends AppCompatActivity {

    EditText email, password, firstName, lastName, mobileNum;
    Button register, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);
        firstName = findViewById(R.id.firstNameText);
        lastName = findViewById(R.id.lastNameText);
        mobileNum = findViewById(R.id.mobiletxt);
        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.btnLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating User Entity
                User user = new User();
                user.setUserEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                user.setFirstName(firstName.getText().toString());
                user.setMobNumber(mobileNum.getText().toString());
                user.setLastName(lastName.getText().toString());

                if (validate(user)) {
                    //Do insert operation
                    UserDataBase userDataBase = UserDataBase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDataBase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            userDao.registerUser(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SignUpActivity.this, "New User Registered", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).start();
                } else {
                    Toast.makeText(SignUpActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    private Boolean validate (User user){
        if (user.getUserEmail().isEmpty()
                || user.getPassword().isEmpty()
                || user.getFirstName().isEmpty()
                || user.getLastName().isEmpty()
                || user.getMobNumber().isEmpty()) {
            return false;
        }
        return true;
    }
}

