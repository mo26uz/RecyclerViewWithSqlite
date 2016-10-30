package com.example.monirul.sqlitewithrecylerview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Fruit> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        FruitDbHelper fruitDbHelper = new FruitDbHelper(this);
        SQLiteDatabase sqLiteDatabase = fruitDbHelper.getReadableDatabase();

        Cursor cursor = fruitDbHelper.getInformation(sqLiteDatabase);
        cursor.moveToFirst();
        do{
            Fruit fruit = new Fruit(cursor.getString(0), cursor.getInt(1), cursor.getDouble(2));
            arrayList.add(fruit);
        }while (cursor.moveToNext());
        fruitDbHelper.close();

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
