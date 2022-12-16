package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Film {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int idCategory;
    public String name;
    public String date;
    public String time;
    public String description;
    public String[] listSlide;
    public int rate;
    public String protagonist;

    public Film(int id, int idCategory, String name, String date, String time, String description, String[] listSlide, int rate, String protagonist) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.date = date;
        this.time = time;
        this.description = description;
        this.listSlide = listSlide;
        this.rate = rate;
        this.protagonist = protagonist;
    }

    public Film(){

    }
}
