package com.conchonha.bookmovietickets.app;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.conchonha.bookmovietickets.database.table.Cinema;


public class MyApplication extends Application {
    public static Boolean isLogin = true;
    public static Cinema cinema;
    public static ViewModelProvider.Factory factory;

    @Override
    public void onCreate() {
        super.onCreate();
        factory = (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(this);
    }
}
