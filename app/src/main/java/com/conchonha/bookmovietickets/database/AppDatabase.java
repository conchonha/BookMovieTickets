package com.conchonha.bookmovietickets.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.conchonha.bookmovietickets.database.dao.UserDao;
import com.conchonha.bookmovietickets.database.table.User;

//đây là annotation sẽ cho mình biết là sẽ có bao nhiêu bảng được tạo trong sqlite
@Database(entities = {User.class,}, version = 2, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    //đây là các abstract giúp cho công việc truy vấn trở lên dễ dàng hơn
    public abstract UserDao userDao();

    //thuộc tính với hàm này giúp mình lấy được instance của class này
    public static AppDatabase DATABASE_INSTANCE;
    public static AppDatabase getInstance(Context context){
        if (DATABASE_INSTANCE == null){
            DATABASE_INSTANCE = Room.databaseBuilder(context,
                            AppDatabase.class,
                            "app_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return DATABASE_INSTANCE;
    }
}
