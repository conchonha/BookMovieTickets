package com.conchonha.bookmovietickets.ui.fragment.language;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentLanguageBinding;
import com.conchonha.bookmovietickets.viewmodel.LanguageViewModel;

public class FragmentLanguage extends BaseFragment<FragmentLanguageBinding, LanguageViewModel> {
    @Override
    protected Class<LanguageViewModel> getClassName() {
        return LanguageViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_language;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVm(viewModel);
    }
}
