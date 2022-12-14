package com.conchonha.bookmovietickets.viewmodel;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.data.IActionQuery;
import com.conchonha.bookmovietickets.database.table.User;
import com.conchonha.bookmovietickets.model.Place;
import com.conchonha.bookmovietickets.utils.Validations;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapViewModel extends BaseViewModel {
    public GoogleMap map;
    private Application application;
    public String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION};
    public final MutableLiveData<String> edtSearch = new MutableLiveData();
    public final MutableLiveData<List<Place>> listCinema = new MutableLiveData<>();

    public MapViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        super.onResume(owner);
        edtSearch.observe(owner, s -> {

        });
    }

    public void findLocation(Location location) {
        Place place = new Place(
                location.getLatitude(), location.getLongitude(),
                getString(R.string.lbl_my_location)
        );
        addMarker(place);
        moveCamera(place);
    }

    private void addMarker(Place place) {
        map.addMarker(
                new MarkerOptions()
                        .position(new LatLng(place.lat, place.lng))
                        .title(place.name)
        );
    }

    private void moveCamera(Place place) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(place.lat, place.lng), 15f));
    }

    public Boolean isPermissionGrand() {
        for (int i = 0; i < permissions.length; i++) {
            if (ActivityCompat.checkSelfPermission(this.application, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private void initListLocation() {
        Place[] listPlace = {
                new Place(
                        /*lat*/ 21.030803843498454,
                        /*lng*/ 105.78527824661644,
               /*tên rạp phim*/ "test",
                        new String[]{
   /*list hình slide rạp phim*/  "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png",
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png"
                        },
              /*icon rạp phim*/ "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png",
             /*Mô tả rạp phim*/ "mo ta rap phim ")
        };
    }
}
