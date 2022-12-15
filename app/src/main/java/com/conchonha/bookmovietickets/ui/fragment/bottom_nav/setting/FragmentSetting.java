package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.setting;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentSettingBinding;
import com.conchonha.bookmovietickets.model.SettingDisplay;
import com.conchonha.bookmovietickets.ui.adapter.AdapterSetting;
import com.conchonha.bookmovietickets.viewmodel.SettingViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FragmentSetting extends BaseFragment<FragmentSettingBinding, SettingViewModel> {
    private final AdapterSetting adapterSetting = new AdapterSetting();
    @Override
    protected Class<SettingViewModel> getClassName() {
        return SettingViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerSetting.setAdapter(adapterSetting);
        viewModel.listItemSetting.observe(getViewLifecycleOwner(),value->{
            adapterSetting.updateItems(new ArrayList(Arrays.asList(value)),viewModel);
        });
    }
}
