package com.conchonha.bookmovietickets.ui.fragment.pay;

import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentPayBinding;
import com.conchonha.bookmovietickets.viewmodel.PayViewModel;


public class FragmentPay extends BaseFragment<FragmentPayBinding, PayViewModel> {
    @Override
    protected Class<PayViewModel> getClassName() {
        return PayViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_pay;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cardInput.setPostalCodeEnabled(false);

        binding.payBtn.setOnClickListener(view1 -> {
           viewModel.payFilm(binding.cardInput);
        });
        handleEvents();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MyApplication.cart = null;
        MyApplication.film = null;
        MyApplication.cinema = null;
        MyApplication.isBuyFilm = false;
    }

    private void handleEvents() {
        getActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                            navigation(R.id.action_fragmentPay_to_fragmentBottomNavigation2,null);
                    }
                }
        );
    }
}
