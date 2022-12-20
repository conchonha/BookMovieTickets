package com.conchonha.bookmovietickets.base;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.conchonha.bookmovietickets.base.data.DataAction;
import com.conchonha.bookmovietickets.base.data.IActionQuery;
import com.conchonha.bookmovietickets.base.data.IActivityAction;
import com.conchonha.bookmovietickets.database.AppDatabase;
import com.conchonha.bookmovietickets.utils.SharePrefs;
import com.conchonha.bookmovietickets.utils.SingleLiveEvent;

import java.util.Locale;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseViewModel extends AndroidViewModel implements DefaultLifecycleObserver {
    protected SharePrefs sharePrefs;
    private final DataAction _dataAction = new DataAction();
    public AppDatabase db = AppDatabase.getInstance(getApplication());
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected final String TAG = this.getClass().getName();
    protected final SingleLiveEvent<DataAction> eventSender = new SingleLiveEvent<>();
    public IActivityAction iActivityAction;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        sharePrefs = new SharePrefs(application);
    }

    public void onNavigate(int actionId, Bundle argument){
        _dataAction.setActionId(actionId);
        _dataAction.setBundle(argument);
        _dataAction.setEventSender(DataAction.EventSender.ON_NAVIGATE);
        eventSender.postValue(_dataAction);
    }

    protected void showToast(String message){
        _dataAction.setMessage(message);
        _dataAction.setEventSender(DataAction.EventSender.SHOW_TOAST);
        eventSender.postValue(_dataAction);
    }

    protected void showAlertYesOption(String message){
        _dataAction.setMessage(message);
        _dataAction.setEventSender(DataAction.EventSender.SHOW_ALERT_YES_OPTION);
        eventSender.postValue(_dataAction);
    }

    protected void navigationDeepLink(String uri){
        _dataAction.setUriDeepLink(uri);
        _dataAction.setEventSender(DataAction.EventSender.ON_NAVIGATE_DEEPLINK);
        eventSender.postValue(_dataAction);
    }

    protected void onClose(){
        _dataAction.setEventSender(DataAction.EventSender.ON_CLOSE);
        eventSender.postValue(_dataAction);
    }

    protected String getString(int message){
        return getApplication().getString(message);
    }

    protected <T>void queryRoomCompletable(Completable comparable, IActionQuery<T> actionQuery){
        Disposable disposable = comparable.subscribeOn(Schedulers.io()).subscribe(()->{
            actionQuery.onSuccess(null);
        },error->{
            showAlertYesOption(error.getMessage());
        });
        compositeDisposable.add(disposable);
    }

    protected <T>void queryRoomFlowable(Flowable<T> flowable, IActionQuery<T> actionQuery){
        Log.d(TAG, "queryRoomFlowable: ");
        Disposable disposable = flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(actionQuery::onSuccess);
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
        compositeDisposable.dispose();
    }

    public void setAppLocale(String lg) {
        Locale df = new Locale(lg);
        Locale.setDefault(df);
        getApplication().getResources().getConfiguration().setLocale(df);
        getApplication().getResources().updateConfiguration(getApplication().getResources().getConfiguration(),getApplication().getResources().getDisplayMetrics());
    }

}
