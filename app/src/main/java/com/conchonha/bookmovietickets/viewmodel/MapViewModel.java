package com.conchonha.bookmovietickets.viewmodel;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.data.IActionQuery;
import com.conchonha.bookmovietickets.base.interfaces.IActionAdapterRecycler;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.utils.SingleLiveEvent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapViewModel extends BaseViewModel implements IActionAdapterRecycler<Cinema> {
    private Application application;
    private List<Cinema> listSearch = new ArrayList<>();

    public GoogleMap map;
    public final String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION};
    public final MutableLiveData<String> edtSearch = new MutableLiveData();
    public final MutableLiveData<List<Cinema>> listCinema = new MutableLiveData<>();
    public final MutableLiveData<Boolean>isVisible = new MutableLiveData<>(false);
    public final SingleLiveEvent<Boolean>showBottomSheet = new SingleLiveEvent<>();


    public MapViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        super.onResume(owner);
        edtSearch.observe(owner, s -> {
            List<Cinema>tmp = new ArrayList<>();
            listSearch.forEach(cinema -> {
                if(cinema.name.toLowerCase().contains(s.toLowerCase())){
                    tmp.add(cinema);
                }
            });
            listCinema.setValue(tmp);
        });

        queryRoomFlowable(db.cinemaDao().getListCinema(),value->{
            Log.d("SangTB", "onResume: "+value);
            listSearch = value;
            listCinema.setValue(value);
            for (int i = 0; i < listSearch.size(); i++){
                addMarker(listSearch.get(i));
            }
        });
    }

    public void findLocation(Location location) {
        Cinema cinema = new Cinema(
                location.getLatitude(), location.getLongitude(),
                getString(R.string.lbl_my_location)
        );
        addMarker(cinema);
        moveCamera(cinema);
    }

    private void addMarker(Cinema cinema) {
        map.addMarker(
                new MarkerOptions()
                        .position(new LatLng(cinema.lat, cinema.lng))
                        .title(cinema.name)
        );
    }

    private void moveCamera(Cinema cinema) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(cinema.lat, cinema.lng), 15f));
    }

    public Boolean isPermissionGrand() {
        for (int i = 0; i < permissions.length; i++) {
            if (ActivityCompat.checkSelfPermission(this.application, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void onClickListener(Cinema data) {
        isVisible.setValue(false);
        moveCamera(data);
    }

    @Override
    public void onNavigate(Cinema data) {

    }

    public void findCinemaFromMarker(Marker marker) {
        if(marker.getTitle() == getString(R.string.lbl_my_location)) return;

        for (int i = 0; i < listSearch.size(); i++) {
            if(marker.getTitle().equals(listSearch.get(i).name)){
                MyApplication.cinema = listSearch.get(i);
                showBottomSheet.postValue(true);
            }
        }
    }
}
