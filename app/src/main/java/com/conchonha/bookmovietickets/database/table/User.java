package com.conchonha.bookmovietickets.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String phone,password,email;

    public User(String password, String phone, String email) {
        this.phone = phone;
        this.password = password;
        this.email = email;
    }

    public User(){

    }
}
