package com.conchonha.bookmovietickets.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.conchonha.bookmovietickets.database.callback.CallbackRoomDatabase;
import com.conchonha.bookmovietickets.database.dao.CartDao;
import com.conchonha.bookmovietickets.database.dao.CategoryDao;
import com.conchonha.bookmovietickets.database.dao.CinemaDao;
import com.conchonha.bookmovietickets.database.dao.FilmsDao;
import com.conchonha.bookmovietickets.database.dao.UserDao;
import com.conchonha.bookmovietickets.database.table.Cart;
import com.conchonha.bookmovietickets.database.table.Category;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.database.table.Film;
import com.conchonha.bookmovietickets.database.table.User;

import kotlin.jvm.Volatile;

//đây là annotation sẽ cho mình biết là sẽ có bao nhiêu bảng được tạo trong sqlite
@Database(entities = {User.class, Cinema.class, Category.class, Film.class, Cart.class}, version = 2, exportSchema = true)
@TypeConverters(DatabaseConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    //đây là các abstract giúp cho công việc truy vấn trở lên dễ dàng hơn
    public abstract UserDao userDao();
    public abstract CinemaDao cinemaDao();
    public abstract CategoryDao categoryDao();
    public abstract FilmsDao filmsDao();
    public abstract CartDao cartDao();

    //thuộc tính với hàm này giúp mình lấy được instance của class này
    @Volatile
    public static AppDatabase DATABASE_INSTANCE;
    public static AppDatabase getInstance(Context context){
        if (DATABASE_INSTANCE == null){
            DATABASE_INSTANCE = Room.databaseBuilder(context,
                            AppDatabase.class,
                            "app_database")
                    .allowMainThreadQueries()
                    .addCallback(new CallbackRoomDatabase())
                    .build();
        }
        return DATABASE_INSTANCE;
    }
}
