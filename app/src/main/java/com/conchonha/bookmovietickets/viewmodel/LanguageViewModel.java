package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.utils.Const;

public class LanguageViewModel extends BaseViewModel {
    public MutableLiveData<Boolean> isEnglish = new MutableLiveData<>(true);
    public MutableLiveData<Boolean> isVietName = new MutableLiveData<>();

    public LanguageViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickItemLanguage(int index){
        isEnglish.setValue(index == 0);
        isVietName.setValue(index == 1);
    }

    public void changeLanguage(){
        if(Boolean.TRUE.equals(isVietName.getValue())){
            sharePrefs.put(Const.KEY_LANGUAGE,"vi");
            iActivityAction.changeLanguage();
            return;
        }
        sharePrefs.put(Const.KEY_LANGUAGE,"en");
        iActivityAction.changeLanguage();
    }
}
