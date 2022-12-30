package com.example.givitapp.items;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDataBase extends RoomDatabase {
    private static final String dbName = "item";
    private static ItemDataBase itemDatabase;

    public static synchronized ItemDataBase getItemDatabase(Context context) {
        if (itemDatabase == null) {
            itemDatabase = Room.databaseBuilder(context, ItemDataBase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();

        }
        return itemDatabase;
    }
    public abstract ItemDao itemDao();


    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        final ExecutorService dbExecutor = Executors.newFixedThreadPool(4);
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            dbExecutor.execute( () -> {
                Item myItem = new Item();
                myItem.setItemName("item name");
                myItem.setItemDescription("item desc");
                myItem.setItemCategory("item category");
                myItem.setItemQuantity(2);
                itemDatabase.itemDao().insert(myItem);
            });
        }
    };
}

