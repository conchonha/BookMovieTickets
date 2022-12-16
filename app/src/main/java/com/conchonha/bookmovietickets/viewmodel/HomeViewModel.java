package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.database.table.Category;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class HomeViewModel  extends BaseViewModel{
    public final MutableLiveData<List<Category>> listItem = new MutableLiveData<>();
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        queryRoomFlowable(db.categoryDao().getListCategory(), listItem::postValue);
    }
}
