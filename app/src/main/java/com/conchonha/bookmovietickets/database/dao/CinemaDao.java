package com.conchonha.bookmovietickets.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.conchonha.bookmovietickets.database.BaseDao;
import com.conchonha.bookmovietickets.database.table.Cinema;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CinemaDao extends BaseDao<Cinema> {
    @Query("SELECT * FROM Cinema")
    Flowable<List<Cinema>>getListCinema();
}
