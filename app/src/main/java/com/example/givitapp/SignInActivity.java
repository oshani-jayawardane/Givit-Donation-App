package com.example.givitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.givitapp.signup.User;
import com.example.givitapp.signup.UserDao;
import com.example.givitapp.signup.UserDataBase;

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);
        btnSignIn = findViewById(R.id.btnSignin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if(userEmailText.isEmpty()||passwordText.isEmpty()){
                    Toast.makeText(SignInActivity.this, "Fill all Fields", Toast.LENGTH_SHORT).show();
                }else{
                    //perform Query
                    UserDataBase userDataBase = UserDataBase.getUserDatabase((getApplicationContext()));
                    UserDao userDao = userDataBase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.loginUser(userEmailText,passwordText);
                            String firstName = user.getFirstName();
                            String userEmail = user.getUserEmail();
                            String userNumber = user.getMobNumber();
                            if(user == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(SignInActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.putExtra("name", firstName);
                                intent.putExtra("email", userEmail);
                                intent.putExtra("number", userNumber);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("user", user);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}



