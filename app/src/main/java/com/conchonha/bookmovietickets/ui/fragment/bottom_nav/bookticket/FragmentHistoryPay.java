package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.bookticket;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentHistoryPayBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterCartHistory;
import com.conchonha.bookmovietickets.viewmodel.HistoryPayViewModel;

public class FragmentHistoryPay extends BaseFragment<FragmentHistoryPayBinding, HistoryPayViewModel> {
    public final AdapterCartHistory adapterCartHistory = new AdapterCartHistory();
    @Override
    protected Class<HistoryPayViewModel> getClassName() {
        return HistoryPayViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_history_pay;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerHistory.setAdapter(adapterCartHistory);
        viewModel.listCart.observe(getViewLifecycleOwner(),carts -> {
            adapterCartHistory.updateItems(carts,null);
        });
    }
}
