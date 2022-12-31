package com.example.givitapp.items;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM items_table")
    LiveData<List<Item>> getAll();

    @Query("SELECT * FROM items_table WHERE item_category == :category")
    LiveData<List<Item>> getAll(String category);

    @Query("SELECT * FROM items_table WHERE itemId = :itemID")
    LiveData<Item> get(int itemID);


}


