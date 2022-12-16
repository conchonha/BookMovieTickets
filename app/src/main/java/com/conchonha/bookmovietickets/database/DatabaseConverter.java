package com.conchonha.bookmovietickets.database;

import androidx.room.TypeConverter;

import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.database.table.Film;
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

    @TypeConverter
    public String fromFilm(Film[] films) {
        Gson gson = new Gson();
        return gson.toJson(films);
    }

    @TypeConverter
    public Film[] toFilm(String films) {
        Gson gson = new Gson();
        Type type = new TypeToken<Film[]>() {}.getType();
        return gson.fromJson(films, type);
    }
}
