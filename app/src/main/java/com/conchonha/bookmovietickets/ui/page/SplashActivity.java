package com.conchonha.bookmovietickets.ui.page;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.core.splashscreen.SplashScreen;
import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.database.AppDatabase;
import com.conchonha.bookmovietickets.database.callback.DumyData;

import java.util.Arrays;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BookMovieTickets);
        startActivity(new Intent(this, MainActivity.class));
    }
}