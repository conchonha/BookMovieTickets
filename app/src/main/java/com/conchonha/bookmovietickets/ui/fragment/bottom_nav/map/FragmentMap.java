package com.conchonha.bookmovietickets.ui.fragment.bottom_nav.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentMapBinding;
import com.conchonha.bookmovietickets.ui.adapter.MapAdapter;
import com.conchonha.bookmovietickets.ui.dialog.ShowButtonSheetDialogMap;
import com.conchonha.bookmovietickets.utils.DialogUtils;
import com.conchonha.bookmovietickets.utils.Validations;
import com.conchonha.bookmovietickets.viewmodel.MapViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FragmentMap extends BaseFragment<FragmentMapBinding, MapViewModel> implements OnMapReadyCallback {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private final MapAdapter adapter = new MapAdapter();
    private ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        checkGps();
    });

    private ActivityResultLauncher requestMultiplePermissions =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                if (result.get(Manifest.permission.ACCESS_COARSE_LOCATION) == true) {
                    checkGps();
                    return;
                }
                DialogUtils.showAlertDialog(requireActivity(), getString(R.string.lbl_permission), null);
            });

    @Override
    protected Class<MapViewModel> getClassName() {
        return MapViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_map;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        viewModel.map = googleMap;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());
        checkPermission();

        googleMap.setOnMarkerClickListener(marker -> {
            Validations.hideKeyboard(binding.getRoot());
            viewModel.findCinemaFromMarker(marker);
            return false;
        });

        googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        requireContext(), R.raw.style_json));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        binding.setVm(viewModel);
        binding.recyclerMenu.setAdapter(adapter);

        listener();
    }

    private void listener() {
        binding.cardBtnMap.setOnClickListener(view1 -> {
            viewModel.isVisible.postValue(false);
        });

        binding.cardLocation.setOnClickListener(view1 -> {
            binding.setIsLocation(true);
            checkPermission();
        });

        binding.cardBtnSearch.setOnClickListener(view1 -> {
            viewModel.isVisible.postValue(true);
        });

        viewModel.listCinema.observe(getViewLifecycleOwner(),value->{
            adapter.updateItems(value,viewModel);
        });

        viewModel.showBottomSheet.observe(getViewLifecycleOwner(),value->{
            if(value){
                new ShowButtonSheetDialogMap().show(getChildFragmentManager(),FragmentMap.class.getName());
            }
        });
    }

    // check permission find location
    private void checkPermission() {
        Log.d(TAG, "checkPermission: ");
        if (viewModel.isPermissionGrand()) {
            checkGps();
            return;
        }
        requestMultiplePermissions.launch(viewModel.permissions);
    }

    private void checkGps() {
        if (Validations.checkGpsStatus(getContext())) {
            findLocation();
            return;
        }
        DialogUtils.showAlertDialog(requireActivity(), getString(R.string.please_enable_gps), () -> {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            launcher.launch(intent);
        });
    }

    @SuppressLint("MissingPermission")
    private void findLocation() {
        if(fusedLocationProviderClient == null) return;
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                viewModel.findLocation(task.getResult());
                return;
            }

            fusedLocationProviderClient.getCurrentLocation(105, new CancellationTokenSource().getToken()).addOnSuccessListener(location -> {
                viewModel.findLocation(location);
            });
        });
    }
}
