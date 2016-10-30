package com.example.monirul.sqlitewithrecylerview;

/**
 * Created by Monirul on 10/19/2016.
 */

public class FruitsContract {

    public FruitsContract() {
    }

    public static class FruitEntry{
        public static final String TABLE_NAME = "fruit_details";
        public static final String NAME = "name";
        public static final String CALORIES = "calories";
        public static final String FAT = "fat";
    }
}
