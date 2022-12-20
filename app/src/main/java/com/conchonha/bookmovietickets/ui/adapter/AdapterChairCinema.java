package com.conchonha.bookmovietickets.ui.adapter;

import android.util.Pair;
import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerChairBinding;

public class AdapterChairCinema extends BaseRecyclerViewAdapter<Pair<Integer,Boolean>, ItemRecyclerChairBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_recycler_chair;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemRecyclerChairBinding> holder, int position) {
        Pair<Integer,Boolean> pair = mListItem.get(position);
        holder.binding.setIsChecked(pair.second);
        holder.itemView.setOnClickListener(view -> {
            action.onClickListener(pair);
        });
    }
}
