package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentHomeBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterRecyclerHome;
import com.conchonha.bookmovietickets.viewmodel.HomeViewModel;

public class FragmentHome extends BaseFragment<FragmentHomeBinding, HomeViewModel> {
    private final AdapterRecyclerHome adapterRecyclerHome = new AdapterRecyclerHome();
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
        binding.recyclerHome.setAdapter(adapterRecyclerHome);
        viewModel.listItem.observe(getViewLifecycleOwner(),value->{
            adapterRecyclerHome.updateItems(value,viewModel);
        });
    }
}
