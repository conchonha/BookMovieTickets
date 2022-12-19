package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.interfaces.IActionAdapterRecycler;
import com.conchonha.bookmovietickets.database.callback.DumyData;
import com.conchonha.bookmovietickets.database.table.Cinema;

import java.util.List;

public class CinemaViewModel extends BaseViewModel implements IActionAdapterRecycler<Cinema> {
    public final MutableLiveData<List<Cinema>> listCinema = new MutableLiveData<>();
    public final MutableLiveData<List<Pair<Integer,Boolean>>> listChair = new MutableLiveData<>();
    public final MutableLiveData<Cinema>cinema = new MutableLiveData<>();

    public CinemaViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        queryRoomFlowable(db.cinemaDao().getListCinema(),value->{
            listCinema.setValue(value);
            if(value != null && value.size() > 0){
                listChair.setValue(DumyData.getListChair(value.get(0).name,getApplication()));
                cinema.setValue(value.get(0));
            }
        });
    }

    @Override
    public void onClickListener(Cinema data) {
        cinema.setValue(data);
    }

    @Override
    public void onCheckedChange(Cinema data) {

    }
}
