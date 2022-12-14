package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.databinding.ItemArrayImageMapBinding;

public class AdapterImageMap extends BaseRecyclerViewAdapter<String, ItemArrayImageMapBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_array_image_map;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemArrayImageMapBinding> holder, int position) {
        holder.binding.setImage(mListItem.get(position));
    }
}
