package com.conchonha.bookmovietickets.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.databinding.DialogMapBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterImageMap;
import com.conchonha.bookmovietickets.viewmodel.MapViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowButtonSheetDialogMap extends BottomSheetDialogFragment {
    private DialogMapBinding binding;
    private final AdapterImageMap adapterImageMap = new AdapterImageMap();
    private MapViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogMapBinding.inflate(inflater);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        viewModel = new ViewModelProvider(getViewModelStore(), MyApplication.factory).get(MapViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerImage.setAdapter(adapterImageMap);
        binding.setCinema(MyApplication.cinema);

        List<String> list = new ArrayList(Arrays.asList(MyApplication.cinema.listImageDetail));
        adapterImageMap.updateItems(list,null);

        binding.btnDirection.setOnClickListener(view1 -> {
            Navigation.findNavController(getParentFragment().getView()).navigate(R.id.fragmentWebView);
        });
    }
}
