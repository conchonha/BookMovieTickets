package com.conchonha.bookmovietickets.ui.fragment.auth;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentBookticketBinding;
import com.conchonha.bookmovietickets.databinding.FragmentFormAuthBinding;
import com.conchonha.bookmovietickets.viewmodel.AuthViewModel;

public class FragmentForm extends BaseFragment<FragmentFormAuthBinding, AuthViewModel> {
    @Override
    protected Class<AuthViewModel> getClassName() {
        return AuthViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_form_auth;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
    }
}
