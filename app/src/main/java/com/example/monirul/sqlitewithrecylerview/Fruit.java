package com.example.monirul.sqlitewithrecylerview;

/**
 * Created by Monirul on 10/20/2016.
 */

public class Fruit {
    private String name;
    private int calories;
    private double fat;

    public Fruit(String name, int calories, double fat) {
        this.setName(name);
        this.setCalories(calories);
        this.setFat(fat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }
}
