package com.conchonha.bookmovietickets.app;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModelProvider;

import com.conchonha.bookmovietickets.database.AppDatabase;
import com.conchonha.bookmovietickets.database.callback.DumyData;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.utils.SharePrefs;

import java.util.Arrays;

import io.reactivex.schedulers.Schedulers;


public class MyApplication extends Application {
    public static Boolean isLogin = true;
    public static Cinema cinema;
    public static ViewModelProvider.Factory factory;

    private final String KEY_FIRST_DATABASE = "KEY_FIRST_DATABASE";
    private SharePrefs sharePrefs;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.getInstance(this);
        factory = (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(this);

        //đã có callback database room nhưng lười viết kiểu đó chơi như này cho nhanh
        sharePrefs =  new SharePrefs(this);
        if(!sharePrefs.getSharedPref().getBoolean(KEY_FIRST_DATABASE, false)){
            AppDatabase.DATABASE_INSTANCE
                    .cinemaDao()
                    .insert(Arrays.asList(DumyData.listCinema))
                    .subscribeOn(Schedulers.io())
                    .subscribe();
        }
        sharePrefs.put(KEY_FIRST_DATABASE,true);
    }
}

