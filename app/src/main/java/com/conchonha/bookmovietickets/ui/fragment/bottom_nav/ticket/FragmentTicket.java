package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.ticket;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentTicketBinding;
import com.conchonha.bookmovietickets.viewmodel.TicketViewModel;

public class FragmentTicket extends BaseFragment<FragmentTicketBinding, TicketViewModel> {
    @Override
    protected Class<TicketViewModel> getClassName() {
        return TicketViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_ticket;
    }
}
