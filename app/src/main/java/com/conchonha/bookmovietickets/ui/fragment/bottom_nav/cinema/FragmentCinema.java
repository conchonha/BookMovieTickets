package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.cinema;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentCinemaBinding;
import com.conchonha.bookmovietickets.viewmodel.CinemaViewModel;

public class FragmentCinema extends BaseFragment<FragmentCinemaBinding, CinemaViewModel> {
    @Override
    protected Class<CinemaViewModel> getClassName() {
        return CinemaViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cinema;
    }
}
