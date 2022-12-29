package com.example.givitapp.items;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

////import androidx.room.Insert;
////import androidx.room.OnConflictStrategy;
////import androidx.room.Query;

@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Query("SELECT * FROM items_table WHERE item_id = :id")
    Item ViewItem(int id);


//    @Update
//    public void updateWords(Word... words);
//
//    @Query("DELETE FROM items_table WHERE id")
//    void deleteAll();
//
//    @Query("SELECT * from items_table ORDER BY word ASC")
//    List<Word> getAllWords();
//
//    @Query("SELECT * FROM items_table WHERE word LIKE :word ")
//    public List<Word> findWord(String word);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    // void  registerUser(Item item);

}


