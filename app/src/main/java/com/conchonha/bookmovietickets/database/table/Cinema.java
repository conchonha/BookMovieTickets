package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
}
