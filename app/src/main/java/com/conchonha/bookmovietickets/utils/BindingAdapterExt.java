package com.conchonha.bookmovietickets.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.conchonha.bookmovietickets.R;

public class BindingAdapterExt {
    @BindingAdapter("app:setImageUrl")
    public static void loadSrcServer(ImageView imageView, String src) {
        Glide.with(imageView.getContext())
                .load(src) //replace with contact image uri
                .placeholder(R.drawable.progress_anim)
                .error(R.drawable.ic_logo)
                .into(imageView);
    }
}


