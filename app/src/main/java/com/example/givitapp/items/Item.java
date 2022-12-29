package com.example.givitapp.items;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.room.Relation;

import com.example.givitapp.signup.User;

@Entity(tableName = "items_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int item_id;
    @ColumnInfo(name = "item_name")
    private String itemName;
    @ColumnInfo(name = "item_description")
    private String itemDescription;
    @ColumnInfo(name = "item_category")
    private String itemCategory;
    @ColumnInfo(name = "item_quantity")
    private int itemQuantity;
//    @ColumnInfo(name = "item_owner")
//    @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "item_owner")
//    private String itemOwner;



    public int getId() {
        return item_id;
    }

    public void setId(int id) {
        this.item_id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}

