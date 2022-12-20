package com.conchonha.bookmovietickets.ui.fragment.auth;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentLoginBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterSlideLogin;
import com.conchonha.bookmovietickets.viewmodel.AuthViewModel;

public class FragmentLogin extends BaseFragment<FragmentLoginBinding, AuthViewModel> {
    protected final AdapterSlideLogin adapterSlideLogin = new AdapterSlideLogin();
    @Override
    protected Class<AuthViewModel> getClassName() {
        return AuthViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVm(viewModel);
        adapterSlideLogin.updateItems(viewModel.getListSlide(),null);
        binding.viewPager.setAdapter(adapterSlideLogin);

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.pageIndicatorViewBanner.setSelection(position);
            }
        });
    }
}
