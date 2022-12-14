package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.base.data.IActionQuery;
import com.conchonha.bookmovietickets.database.table.User;
import com.conchonha.bookmovietickets.utils.Validations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends BaseViewModel {
    public final MutableLiveData<String> phone = new MutableLiveData();
    public final MutableLiveData<String> pass = new MutableLiveData();
    public final MutableLiveData<String> email = new MutableLiveData();
    public final LiveData<Boolean> isLogin = new MutableLiveData(MyApplication.isLogin);


    public AuthViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Integer> getListSlide() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.logo_1);
        arrayList.add(R.drawable.logo_3);
        arrayList.add(R.drawable.loggo_2);
        return arrayList;
    }

    public void loginForm(Boolean isLogin) {
        MyApplication.isLogin = isLogin;
        onNavigate(R.id.fragmentFormAuth, null);
    }

    public void onClick() {
        if (MyApplication.isLogin) {
            final List<User> users = db.userDao().login(email.getValue(), pass.getValue());
            if (users.size() > 0) {
                onNavigate(R.id.action_fragmentRegister_to_fragmentBottomNavigation2, null);
                return;
            }
            showAlertYesOption(getString(R.string.account_is_not_valid_or_not_exit));
            return;
        }

        if (Validations.isRegister(email.getValue(), pass.getValue(), phone.getValue())) {
            queryRoomCompletable(db.userDao().insert(new User(pass.getValue(), phone.getValue(), email.getValue())), data -> {
                onNavigate(R.id.action_fragmentRegister_to_fragmentBottomNavigation2,null);
            });
            return;
        }
        showAlertYesOption(getString(R.string.value_is_not_valid));
    }
}
