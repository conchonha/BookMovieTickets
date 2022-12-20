package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.data.IActionQuery;
import com.conchonha.bookmovietickets.database.table.Cart;
import com.conchonha.bookmovietickets.database.table.Category;

import java.util.List;

public class HistoryPayViewModel extends BaseViewModel{
    public final MutableLiveData<List<Cart>>listCart = new MutableLiveData<>();

    public HistoryPayViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        super.onResume(owner);
        queryRoomFlowable(db.cartDao().getListCartFromUser(MyApplication.user.id), data -> {
            listCart.setValue(data);
        });
    }
}
