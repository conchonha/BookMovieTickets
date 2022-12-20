package com.conchonha.bookmovietickets.model;

import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.database.table.Film;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    public Cinema cinema;
    public Film film;
    public Set<Integer> listChair = new HashSet<>();

    public Cart(Cinema cinema, Film film, Set<Integer> listChair) {
        this.cinema = cinema;
        this.film = film;
        this.listChair = listChair;
    }
    public Cart(){

    }
}
