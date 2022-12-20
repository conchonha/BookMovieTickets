package com.conchonha.bookmovietickets.base;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.Navigation;

import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.data.DataAction;
import com.conchonha.bookmovietickets.ui.fragment.bottom_nav.FragmentBottomNavigation;
import com.conchonha.bookmovietickets.ui.page.MainActivity;
import com.conchonha.bookmovietickets.utils.Const;
import com.conchonha.bookmovietickets.utils.DialogUtils;
import com.conchonha.bookmovietickets.utils.SharePrefs;
import com.conchonha.bookmovietickets.utils.Validations;

import java.util.Locale;
import java.util.Objects;

public abstract class BaseFragment<VB extends ViewDataBinding,VM extends BaseViewModel> extends Fragment {
    protected VB binding;
    protected VM viewModel;
    protected final String TAG = this.getClass().getName();

    protected abstract Class<VM> getClassName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayout(),container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        viewModel = new ViewModelProvider(getViewModelStore(), MyApplication.factory).get(getClassName());
        getLifecycle().addObserver(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();

        viewModel.eventSender.observe(getViewLifecycleOwner(), new Observer<DataAction>() {
            @Override
            public void onChanged(DataAction dataAction) {
                Log.d(TAG, "onChanged: "+dataAction.getEventSender());
                switch (dataAction.getEventSender()){
                    case ON_CLOSE:
                        requireActivity().finish();
                        break;
                    case ON_NAVIGATE:
                        navigation(dataAction.getActionId(),dataAction.getBundle());
                        break;
                    case SHOW_TOAST:
                        Toast.makeText(requireContext(),dataAction.getMessage(),Toast.LENGTH_LONG).show();
                        break;
                    case SHOW_ALERT_YES_OPTION:
                        DialogUtils.showAlertDialog(requireActivity(),dataAction.getMessage(),null);
                        break;
                    case ON_NAVIGATE_DEEPLINK:
                        navigationDeepLink(dataAction.getUriDeepLink());
                        break;
                    case BACK_SCREEN:
                        backScreen();
                        break;
                    default:
                        throw new IllegalStateException("No implement method: " + dataAction.getEventSender().ordinal());
                }
            }
        });
    }

    private void setup() {
        if(getActivityMain() != null){
            viewModel.iActivityAction = getActivityMain();
        }
        binding.getRoot().setOnClickListener(Validations::hideKeyboard);
        String lg = new SharePrefs(getContext()).getSharedPref().getString(Const.KEY_LANGUAGE,"");
        if(!Objects.equals(lg, "")){
            setAppLocale(lg);
            viewModel.setAppLocale(lg);
        }
    }

    protected void navigation(int actionId, Bundle bundle){
        Navigation.findNavController(requireView()).navigate(actionId,bundle);
    }

    protected void backScreen(){
        Navigation.findNavController(requireView()).popBackStack();
    }
    protected abstract int getLayout();

    private MainActivity getActivityMain(){
        if(getActivity().getClass().equals(MainActivity.class)){
            return (MainActivity) getActivity();
        }
        return null;
    }

    protected NavController findNavHostController(){
        return Navigation.findNavController(binding.getRoot());
    }

    /** change multiple language */
    private void setAppLocale(String language) {
        Locale df = new Locale(language);
        Locale.setDefault(df);
        getResources().getConfiguration().setLocale(df);
        getResources().updateConfiguration(getResources().getConfiguration(),getResources().getDisplayMetrics());
    }

    protected void navigationDeepLink(String uri){
        FragmentBottomNavigation.navController.navigate(NavDeepLinkRequest.Builder
                .fromUri(Uri.parse(uri)).build());
    }
}
