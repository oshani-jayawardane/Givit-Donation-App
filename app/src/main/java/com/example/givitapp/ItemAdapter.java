package com.example.givitapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.givitapp.items.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.myViewHolder> {

    public List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_card, parent, false);
        return new ItemAdapter.myViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.myViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.name.setText(item.getItemName());
        holder.description.setText(item.getItemDescription());
        holder.category.setText(item.getItemCategory());
        holder.quantity.setText(item.getItemQuantity()+"");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, description, category, quantity;

        ItemAdapter adapter;

        public myViewHolder(@NonNull View itemView, ItemAdapter itemAdapter) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            description = itemView.findViewById(R.id.txt_description);
            category = itemView.findViewById(R.id.txt_category);
            quantity = itemView.findViewById(R.id.txt_quantity);
            this.adapter = itemAdapter;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
