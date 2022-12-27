package com.example.givitapp.signup;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {

    private static final String dbName = "user";
    private static UserDataBase userDataBase;

    public static synchronized UserDataBase getUserDatabase(Context context) {
        if (userDataBase == null) {
            userDataBase = Room.databaseBuilder(context, UserDataBase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return userDataBase;
    }
    public abstract UserDao userDao();
}
