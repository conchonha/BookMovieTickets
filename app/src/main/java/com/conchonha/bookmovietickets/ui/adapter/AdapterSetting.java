package com.conchonha.bookmovietickets.ui.adapter;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseRecyclerViewAdapter;
import com.conchonha.bookmovietickets.base.BaseViewHolder;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerSettingBinding;
import com.conchonha.bookmovietickets.model.SettingDisplay;

public class AdapterSetting extends BaseRecyclerViewAdapter<SettingDisplay, ItemRecyclerSettingBinding> {
    @Override
    protected int getLayout() {
        return R.layout.item_recycler_setting;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ItemRecyclerSettingBinding> holder, int position) {
        SettingDisplay settingDisplay = mListItem.get(position);

        holder.binding.setData(settingDisplay);
        holder.binding.swipe.setOnCheckedChangeListener((view, b) -> {
            settingDisplay.isChecked = b;
            action.onCheckedChange(settingDisplay);
        });

        holder.binding.getRoot().setOnClickListener(v -> {
            action.onClickListener(settingDisplay);
        });
    }
}
