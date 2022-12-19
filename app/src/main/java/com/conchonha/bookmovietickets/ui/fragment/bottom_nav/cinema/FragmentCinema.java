package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.cinema;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentCinemaBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterHeaderCinema;
import com.conchonha.bookmovietickets.viewmodel.CinemaViewModel;

public class FragmentCinema extends BaseFragment<FragmentCinemaBinding, CinemaViewModel> {
    private final AdapterHeaderCinema adapterHeaderCinema = new AdapterHeaderCinema();
    @Override
    protected Class<CinemaViewModel> getClassName() {
        return CinemaViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cinema;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        observer();
    }

    private void observer() {
        viewModel.listCinema.observe(getViewLifecycleOwner(),cinemas -> {
            adapterHeaderCinema.updateItems(cinemas,viewModel);
        });

        viewModel.listChair.observe(getViewLifecycleOwner(),pairs -> {

        });

        binding.txtWebsize.setOnClickListener(view -> {
            MyApplication.cinema = viewModel.cinema.getValue();
            Navigation.findNavController(getParentFragment().getView()).navigate(R.id.fragmentWebView);
        });
    }

    private void initView() {
        binding.setVm(viewModel);
        binding.txtWebsize.setPaintFlags(binding.txtWebsize.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.recyclerCinema.setAdapter(adapterHeaderCinema);
    }
}
