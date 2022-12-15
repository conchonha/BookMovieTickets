package com.conchonha.bookmovietickets.base;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.data.IActivityAction;
import com.conchonha.bookmovietickets.utils.Const;
import com.conchonha.bookmovietickets.utils.SharePrefs;

import org.intellij.lang.annotations.Language;

import java.util.Locale;
import java.util.Objects;


public abstract class BaseActivity<VB extends ViewDataBinding> extends AppCompatActivity implements IActivityAction {
    protected VB binding;

    protected final String TAG = this.getClass().getName();

    protected abstract int getLayout();

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_BookMovieTickets);
        super.onCreate(savedInstanceState);
        String lg = new SharePrefs(this).getSharedPref().getString(Const.KEY_LANGUAGE,"");
        if(!Objects.equals(lg, "")){
            setAppLocale(lg);
        }

        binding = DataBindingUtil.setContentView(this,getLayout());
        binding.setLifecycleOwner(this);
        onInit();
    }

    abstract protected void onInit();

    @Override
    public void changeLanguage() {
        startActivity(getIntent());
    }

    /** change multiple language */
   private void setAppLocale(String language) {
        Locale df = new Locale(language);
        Locale.setDefault(df);
        getResources().getConfiguration().setLocale(df);
        getResources().updateConfiguration(getResources().getConfiguration(),getResources().getDisplayMetrics());
    }
}