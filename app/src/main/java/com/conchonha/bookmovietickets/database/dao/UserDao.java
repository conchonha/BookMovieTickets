package com.conchonha.bookmovietickets.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.conchonha.bookmovietickets.database.BaseDao;
import com.conchonha.bookmovietickets.database.table.User;

import java.util.List;

@Dao
public interface UserDao extends BaseDao<User> {
    @Query("SELECT * FROM User WHERE email= :email and password= :password")
    List<User> login(String email, String password);
}
