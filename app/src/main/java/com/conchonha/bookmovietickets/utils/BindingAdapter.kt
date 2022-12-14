package com.conchonha.bookmovietickets.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.conchonha.bookmovietickets.R

@BindingAdapter("app:setImageUrl")
fun loadSrcServer(imageView: ImageView, src: String?) {
    Glide.with(imageView.context)
        .load(src) //replace with contact image uri
        .placeholder(R.drawable.progress_anim)
        .error(R.drawable.ic_logo)
        .into(imageView)
}


