package com.conchonha.bookmovietickets.ui.page;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.core.splashscreen.SplashScreen;
import com.conchonha.bookmovietickets.R;

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BookMovieTickets);
        startActivity(new Intent(this, MainActivity.class));
    }
}