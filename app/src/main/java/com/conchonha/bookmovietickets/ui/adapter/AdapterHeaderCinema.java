package com.conchonha.bookmovietickets.ui.adapter;

import android.graphics.Typeface;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.databinding.ItemHeaderCinemaBinding;

public class AdapterHeaderCinema extends BaseRecyclerViewAdapter<Cinema, ItemHeaderCinemaBinding> {
    private int position1 = 0;
    @Override
    protected int getLayout() {
        return R.layout.item_header_cinema;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemHeaderCinemaBinding> holder, int position) {
        Cinema cinema = mListItem.get(position);
        holder.binding.setIsChecked((this.position1 == position));
        holder.binding.txtTitle.setText(cinema.name);
        holder.binding.txtTitle.setOnClickListener(view -> {
            position1 = position;
            holder.binding.setIsChecked(true);
            action.onClickListener(cinema);

            if(position == position1){
                holder.binding.txtTitle.setTypeface(holder.binding.txtTitle.getTypeface(), Typeface.BOLD);
            }else{
                holder.binding.txtTitle.setTypeface(holder.binding.txtTitle.getTypeface(), Typeface.NORMAL);
            }
            notifyDataSetChanged();
        });
    }
}
