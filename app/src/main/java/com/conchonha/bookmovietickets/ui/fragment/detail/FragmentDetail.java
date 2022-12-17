package com.conchonha.bookmovietickets.ui.fragment.detail;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentDetailBinding;
import com.conchonha.bookmovietickets.ui.adapter.AdapterImageDetail;
import com.conchonha.bookmovietickets.viewmodel.DetailFilmViewModel;

import java.util.Arrays;

public class FragmentDetail extends BaseFragment<FragmentDetailBinding, DetailFilmViewModel> {
    private final AdapterImageDetail imageDetail = new AdapterImageDetail();
    @Override
    protected Class<DetailFilmViewModel> getClassName() {
        return DetailFilmViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(MyApplication.film != null)
        binding.setFilm(MyApplication.film);
        imageDetail.updateItems(Arrays.asList(MyApplication.film.listSlide),null);
        binding.viewPager2.setAdapter(imageDetail);

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.pageIndicatorViewBanner.setSelection(position);
            }
        });
    }
}
