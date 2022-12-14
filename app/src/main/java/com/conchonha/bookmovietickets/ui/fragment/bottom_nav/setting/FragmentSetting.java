package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.setting;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentSettingBinding;
import com.conchonha.bookmovietickets.viewmodel.SettingViewModel;

public class FragmentSetting extends BaseFragment<FragmentSettingBinding, SettingViewModel> {
    @Override
    protected Class<SettingViewModel> getClassName() {
        return SettingViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_setting;
    }
}
