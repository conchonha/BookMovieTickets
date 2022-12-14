package com.conchonha.bookmovietickets.model;

public class Place {
    public Double lat,lng;
    public String name;
    public String[] listImageDetail;
    public String icon;
    public String description;

    public Place(Double lat, Double lng, String name) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public Place(Double lat, Double lng, String name, String[] listImageDetail, String icon, String description) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.listImageDetail = listImageDetail;
        this.icon = icon;
        this.description = description;
    }
}
