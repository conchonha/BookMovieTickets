package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerMapBinding;

public class MapAdapter extends BaseRecyclerViewAdapter<Cinema, ItemRecyclerMapBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_recycler_map;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemRecyclerMapBinding> holder, int position) {
        Cinema cinema = mListItem.get(position);
        holder.binding.setCinema(cinema);
        holder.binding.linear.setOnClickListener(view -> {
            action.onClickListener(cinema);
        });
    }
}
