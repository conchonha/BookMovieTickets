package com.conchonha.bookmovietickets.ui.page;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseActivity;
import com.conchonha.bookmovietickets.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInit() {
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerViewAuth);
//        NavController navController = navHostFragment.getNavController();
    }
}