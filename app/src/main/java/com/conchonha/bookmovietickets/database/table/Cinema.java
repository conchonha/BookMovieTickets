package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Cinema {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public Double lat,lng;
    public String name;
    public String[] listImageDetail;
    public String icon;
    public String description;
    public String website;

    public Cinema(Double lat, Double lng, String name) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public Cinema(Double lat, Double lng, String name, String[] listImageDetail, String icon, String description,String website) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.listImageDetail = listImageDetail;
        this.icon = icon;
        this.description = description;
        this.website = website;
    }

    public Cinema(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return lat.equals(cinema.lat) && lng.equals(cinema.lng) && name.equals(cinema.name) && Arrays.equals(listImageDetail, cinema.listImageDetail) && icon.equals(cinema.icon) && description.equals(cinema.description) && website.equals(cinema.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
