package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.database.table.Cart;
import com.conchonha.bookmovietickets.databinding.ItemHistoryPayBinding;
import com.conchonha.bookmovietickets.utils.BindingAdapterExt;

public class AdapterCartHistory extends BaseRecyclerViewAdapter<Cart, ItemHistoryPayBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_history_pay;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemHistoryPayBinding> holder, int position) {
        Cart cart = mListItem.get(position);
        holder.binding.setCart(cart);
        if(cart.listChair != null){
            String price = holder.itemView.getContext().getString(R.string.price)+" " + cart.listChair.size() +" = "+(cart.listChair.size() * 75000);
            holder.binding.txtPrice.setText(price);
        }

        if(cart.film.listSlide != null && cart.film.listSlide.length > 0){
            BindingAdapterExt.loadSrcServer(holder.binding.imgFilm,cart.film.listSlide[0]);
        }
    }
}
