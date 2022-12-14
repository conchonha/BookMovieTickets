package com.conchonha.bookmovietickets.ui.fragment.bottom_nav;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentBottomNavigationBinding;
import com.conchonha.bookmovietickets.viewmodel.HomeViewModel;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentBottomNavigation extends BaseFragment<FragmentBottomNavigationBinding, HomeViewModel> {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomNavigate, navController);
        binding.bottomNavigate.setBackground(null);
        binding.bottomNavigate.setOnItemReselectedListener(item -> {
            navController.popBackStack(item.getItemId(),  false);
        });

        binding.fab.setOnClickListener(view1 ->{
            navController.navigate(R.id.fragmentBookTicket,null);
        });
    }

    @Override
    protected Class<HomeViewModel> getClassName() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_bottom_navigation;
    }
}