package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.databinding.ItemArrayImageDetailBinding;
import com.conchonha.bookmovietickets.databinding.ItemArrayImageDetailBindingImpl;
import com.conchonha.bookmovietickets.databinding.ItemArrayImageMapBinding;

public class AdapterImageDetail extends BaseRecyclerViewAdapter<String, ItemArrayImageDetailBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_array_image_detail;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemArrayImageDetailBinding> holder, int position) {
        holder.binding.setImage(mListItem.get(position));
    }
}
