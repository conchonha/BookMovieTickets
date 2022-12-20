package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public Cinema cinema;
    public Film film;
    public int idUser;
    public Set<Integer> listChair = new HashSet<>();

    public Cart(Cinema cinema, Film film, Set<Integer> listChair) {
        this.cinema = cinema;
        this.film = film;
        this.listChair = listChair;
    }

    public Cart(){

    }
}
