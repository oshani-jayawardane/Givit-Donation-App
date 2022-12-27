package com.example.givitapp.signup;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users WHERE userEmail = :email and password = :password")
    User loginUser(String email, String password);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void  registerUser(User user);

}
