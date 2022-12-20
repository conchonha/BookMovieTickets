package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ui.NavigationUI;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.databinding.FragmentHomeBinding;
import com.conchonha.bookmovietickets.databinding.HeaderHomeBinding;
import com.conchonha.bookmovietickets.databinding.HeaderHomeBindingImpl;
import com.conchonha.bookmovietickets.ui.adapter.AdapterRecyclerHome;
import com.conchonha.bookmovietickets.utils.Const;
import com.conchonha.bookmovietickets.viewmodel.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

public class FragmentHome extends BaseFragment<FragmentHomeBinding, HomeViewModel> {
    private final AdapterRecyclerHome adapterRecyclerHome = new AdapterRecyclerHome();
    private HeaderHomeBinding headerHomeBinding;
    @Override
    protected Class<HomeViewModel> getClassName() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        drawableHandle();
    }

    private void init() {
        binding.recyclerHome.setAdapter(adapterRecyclerHome);
        headerHomeBinding = HeaderHomeBinding.inflate(LayoutInflater.from(getContext()));

        viewModel.listItem.observe(getViewLifecycleOwner(),value->{
            adapterRecyclerHome.updateItems(value,viewModel);
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void drawableHandle() {
        headerHomeBinding.txtTitle.setText(MyApplication.user.email);
        headerHomeBinding.txtPhone.setText(MyApplication.user.phone);

        binding.navigationDrawerLayout.addHeaderView(headerHomeBinding.getRoot());
        binding.navigationDrawerLayout.setNavigationItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.map:
                    navigation(R.id.fragmentMap,null);
                    break;
                case R.id.favorite:
                    navigation(R.id.fragmentBookTicket,null);
                    break;
                case R.id.fanpage:
                    MyApplication.cinema = new Cinema();
                    MyApplication.cinema.website = Const.FANPAGE;
                    navigation(R.id.fragmentWebView,null);
                    break;
                case R.id.policy:
                    MyApplication.cinema = new Cinema();
                    MyApplication.cinema.website = Const.POLICY;
                    navigation(R.id.fragmentWebView,null);
                    break;
                case R.id.setting:
                    navigation(R.id.fragmentSetting,null);
                    break;
                default:
                    MyApplication.isLogin = false;
                    MyApplication.user = null;
                    MyApplication.cinema = null;
                    MyApplication.isBuyFilm = false;
                    MyApplication.cart = null;
                    findNavHostController().navigate(R.id.action_fragmentBottomNavigation2_to_fragmentLogin);
                    break;
            }
            return true;
        });

    }
}
