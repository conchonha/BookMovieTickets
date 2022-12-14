package com.conchonha.bookmovietickets.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface BaseDao<T>{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insert(List<T> listData);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insert(T  data);

    @Update
    public Completable update(T data);

    @Update
    public Completable update(List<T> listData);

    @Delete
    public Completable delete(List<T> listData);

    @Delete
    public Completable delete(T data);
}
