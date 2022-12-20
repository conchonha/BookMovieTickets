package com.conchonha.bookmovietickets.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.conchonha.bookmovietickets.database.BaseDao;
import com.conchonha.bookmovietickets.database.table.Cart;
import com.conchonha.bookmovietickets.database.table.Category;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CartDao extends BaseDao<Cart> {
    @Query("select * from Cart where idUser = :idUser")
    public Flowable<List<Cart>> getListCartFromUser(int idUser);
}
