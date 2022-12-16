package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    public int id;
    public String name;
    public Film[] films;

    public Category(int id,String name,Film[] films) {
        this.id = id;
        this.name = name;
        this.films = films;
    }

    public Category(){

    }
}
