package com.conchonha.bookmovietickets.base;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.conchonha.bookmovietickets.R;


public abstract class BaseActivity<VB extends ViewDataBinding> extends AppCompatActivity {
    protected VB binding;

    protected final String TAG = this.getClass().getName();

    protected abstract int getLayout();

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_BookMovieTickets);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,getLayout());
        binding.setLifecycleOwner(this);
        onInit();
    }

    abstract protected void onInit();

}