package com.example.monirul.sqlitewithrecylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Monirul on 10/20/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Fruit> arrayList = new ArrayList<>();
    RecyclerAdapter( ArrayList<Fruit> arrayList){
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Fruit fruit = arrayList.get(position);
        holder.Name.setText(fruit.getName());
        holder.Calories.setText(Integer.toString(fruit.getCalories()));
        holder.Fat.setText(String.valueOf(fruit.getFat()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Calories,Fat;
        RecyclerViewHolder(View view){
            super(view);
            Name = (TextView) view.findViewById(R.id.name);
            Calories = (TextView) view.findViewById(R.id.calories);
            Fat = (TextView) view.findViewById(R.id.fat);

        }
    }
}
