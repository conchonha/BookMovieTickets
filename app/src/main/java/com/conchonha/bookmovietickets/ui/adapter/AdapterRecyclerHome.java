package com.conchonha.bookmovietickets.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.conchonha.bookmovietickets.database.table.Category;
import com.conchonha.bookmovietickets.database.table.Film;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerFilmBodyBinding;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerFilmEndBinding;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerFilmHeaderBinding;
import com.conchonha.bookmovietickets.databinding.ItemRecyclerHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerHome extends RecyclerView.Adapter {
    private List<Category> mListItem = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE.TYPE_HEADER.ordinal();
        } else if (position == mListItem.size() - 1) {
            return TYPE.TYPE_END.ordinal();
        }
        return TYPE.TYPE_BODY.ordinal();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerHomeBinding binding = ItemRecyclerHomeBinding.inflate(LayoutInflater.from(parent.getContext()));
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        binding.getRoot().setLayoutParams(layoutParams);
        return new ViewHolderItem(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemRecyclerHomeBinding binding = ((ViewHolderItem) holder).binding;
        Category category = mListItem.get(position);
        binding.txtTitle.setText("khẻkđjghdjjgvkfscnbkjdfnb ,mdfn lbdpkhbnfkl cvndfklbn ljdfvn");

        binding.lineImage.removeAllViews();
        for (Film film : category.films){
            if(film.listSlide.length > 0){
                ViewBinding viewBinding;
                if (getItemViewType(position) == TYPE.TYPE_HEADER.ordinal()) {
                    ItemRecyclerFilmHeaderBinding item = ItemRecyclerFilmHeaderBinding.inflate(LayoutInflater.from(holder.itemView.getContext()));
                    item.setSrc(film.listSlide[0]);
                    viewBinding = item;
                } else if (getItemViewType(position) == TYPE.TYPE_BODY.ordinal()) {
                    ItemRecyclerFilmBodyBinding item = ItemRecyclerFilmBodyBinding.inflate(LayoutInflater.from(holder.itemView.getContext()));
                    item.setSrc(film.listSlide[0]);
                    viewBinding = item;
                } else {
                    ItemRecyclerFilmEndBinding item = ItemRecyclerFilmEndBinding.inflate(LayoutInflater.from(holder.itemView.getContext()));
                    item.setSrc(film.listSlide[0]);
                    viewBinding = item;
                }
//
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(220,220);
//                layoutParams.setMargins(15, 0, 15, 0);
//                viewBinding.getRoot().setLayoutParams(layoutParams);
                binding.lineImage.addView(viewBinding.getRoot());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateItems(List<Category> value, Object o) {
        mListItem = value;
        notifyDataSetChanged();
    }

    static class ViewHolderItem extends RecyclerView.ViewHolder {
        public ItemRecyclerHomeBinding binding;
        public ViewHolderItem(@NonNull ItemRecyclerHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    enum TYPE {
        TYPE_HEADER,
        TYPE_BODY,
        TYPE_END
    }
}
//public class AdapterRecyclerHome extends BaseRecyclerViewAdapter<Category,ItemRecyclerHomeBinding> {
//    @Override
//    protected int getLayout() {
//        return R.layout.item_recycler_home;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BaseViewHolder<ItemRecyclerHomeBinding> holder, int position) {
//        Category category = mListItem.get(position);
//
//        holder.binding.txtTitle.setText(category.name);
//        ChildAdapterRecycler adapterRecycler = new ChildAdapterRecycler();
//        adapterRecycler.updateItems(Arrays.asList(category.films),null);
//        holder.binding.recyclerChild.setAdapter(adapterRecycler);
//    }
//
//    class ChildAdapterRecycler extends BaseRecyclerViewAdapter<Film, ItemRecyclerFilmBinding>{
//
//        @Override
//        protected int getLayout() {
//            return R.layout.item_recycler_film;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull BaseViewHolder<ItemRecyclerFilmBinding> holder, int position) {
//            if(mListItem.size() > 0 && mListItem.get(position).listSlide.length > 0){
//                holder.binding.setSrc(mListItem.get(position).listSlide[0]);
//            }
//        }
//    }
//}
