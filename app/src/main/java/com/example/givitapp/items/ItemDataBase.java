package com.example.givitapp.items;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDataBase extends RoomDatabase {
    private static final String dbName = "item";
    private static ItemDataBase itemDatabase;

    public static synchronized ItemDataBase getItemDatabase(Context context) {
        if (itemDatabase == null) {
            itemDatabase = Room.databaseBuilder(context, ItemDataBase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return itemDatabase;
    }
    public abstract ItemDao ItemDao();
}

