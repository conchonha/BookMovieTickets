package com.conchonha.bookmovietickets.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.conchonha.bookmovietickets.database.BaseDao;
import com.conchonha.bookmovietickets.database.table.Category;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CategoryDao extends BaseDao<Category> {
    @Query("select * from Category")
    public Flowable<List<Category>> getListCategory();
}
