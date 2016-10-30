package com.example.monirul.sqlitewithrecylerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Monirul on 10/19/2016.
 */

public class FruitDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "furit_db";
    public static final int DB_VERSION = 1;
    public static final String CREATE_QUERY = "create table "+ FruitsContract.FruitEntry.TABLE_NAME
            +"( "+ FruitsContract.FruitEntry.NAME + " text, "
            + FruitsContract.FruitEntry.CALORIES + " integer, "
            + FruitsContract.FruitEntry.FAT + " double );";

    private static final String DROP_QUERY = "drop table if exists " + FruitsContract.FruitEntry.TABLE_NAME + ";";

    public FruitDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("Database operations", "Database Created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        Log.d("Database operations", "Database Update...");
    }

    public void putInformation(String name, int calories, double fat, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(FruitsContract.FruitEntry.NAME,name);
        contentValues.put(FruitsContract.FruitEntry.CALORIES,calories);
        contentValues.put(FruitsContract.FruitEntry.FAT,fat);
        Long l= db.insert(FruitsContract.FruitEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations", "One row inserted...");
    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] projection = {FruitsContract.FruitEntry.NAME, FruitsContract.FruitEntry.CALORIES, FruitsContract.FruitEntry.FAT};
        Cursor cursor = db.query(FruitsContract.FruitEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
