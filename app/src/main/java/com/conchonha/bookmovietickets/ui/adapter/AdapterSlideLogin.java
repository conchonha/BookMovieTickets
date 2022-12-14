package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.databinding.ItemViewpagerLoginBinding;

public class AdapterSlideLogin extends BaseRecyclerViewAdapter<Integer,ItemViewpagerLoginBinding>{
    @Override
    protected int getLayout() {
        return R.layout.item_viewpager_login;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemViewpagerLoginBinding> holder, int position) {
        holder.binding.setSrc(mListItem.get(position));
    }
}