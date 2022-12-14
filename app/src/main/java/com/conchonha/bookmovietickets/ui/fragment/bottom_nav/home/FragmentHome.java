package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.home;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentHomeBinding;
import com.conchonha.bookmovietickets.viewmodel.HomeViewModel;

public class FragmentHome extends BaseFragment<FragmentHomeBinding, HomeViewModel> {
    @Override
    protected Class<HomeViewModel> getClassName() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
}
