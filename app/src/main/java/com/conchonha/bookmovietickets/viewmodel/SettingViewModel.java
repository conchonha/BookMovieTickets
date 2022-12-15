package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.conchonha.bookmovietickets.BuildConfig;
import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.interfaces.IActionAdapterRecycler;
import com.conchonha.bookmovietickets.database.callback.DumyData;
import com.conchonha.bookmovietickets.database.table.Cinema;
import com.conchonha.bookmovietickets.model.SettingDisplay;
import com.conchonha.bookmovietickets.utils.Const;

public class SettingViewModel extends BaseViewModel implements IActionAdapterRecycler<SettingDisplay> {
    public MutableLiveData<SettingDisplay[]> listItemSetting = new MutableLiveData<>();

    public SettingViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        listItemSetting.setValue(DumyData.getListSetting(getApplication()));
    }


    @Override
    public void onClickListener(SettingDisplay data) {
        switch (data.typeDisplayUI){
            case TYPE_REMOVE_CACHE:
                sharePrefs.deleteDir(getApplication().getCacheDir());
                listItemSetting.setValue(DumyData.getListSetting(getApplication()));
                break;
            case TYPE_LANGUAGE:
                iActivityAction.getNavController().navigate(R.id.fragmentLanguage);
                break;
            case TYPE_SHARE:
                shareApp();
                break;
            case TYPE_PRIVACY:
                MyApplication.cinema = new Cinema();
                MyApplication.cinema.website = Const.WEB_PRIVACY;
                onNavigate(R.id.fragmentWebView,null);
                break;
        }
    }

    @Override
    public void onCheckedChange(SettingDisplay data) {
        switch (data.typeDisplayUI) {
            case TYPE_NOTIFICATION:
                sharePrefs.put(Const.KEY_NOTIFY, data.isChecked);
                break;
        }
    }

    private void shareApp(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(
                Intent.EXTRA_TEXT,
                "BookMovieTickets at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
        );
        getApplication().startActivity(intent);
    }

}

