package com.conchonha.bookmovietickets.database;

import androidx.room.TypeConverter;

import com.conchonha.bookmovietickets.database.table.Cinema;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DatabaseConverter {
    @TypeConverter
    public String fromCinema(String[] listImageDetail) {
        Gson gson = new Gson();
        return gson.toJson(listImageDetail);
    }

    @TypeConverter
    public String[] toCinema(String cinema) {
        Gson gson = new Gson();
        Type type = new TypeToken<String[]>() {}.getType();
        return gson.fromJson(cinema, type);
    }
}
