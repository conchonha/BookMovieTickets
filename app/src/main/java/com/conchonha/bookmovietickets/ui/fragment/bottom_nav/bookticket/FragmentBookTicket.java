package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.bookticket;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentBookticketBinding;
import com.conchonha.bookmovietickets.viewmodel.BookTicketViewModel;

public class FragmentBookTicket extends BaseFragment<FragmentBookticketBinding, BookTicketViewModel> {
    @Override
    protected Class<BookTicketViewModel> getClassName() {
        return BookTicketViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_bookticket;
    }
}
