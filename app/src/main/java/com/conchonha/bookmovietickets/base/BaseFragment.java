package com.conchonha.bookmovietickets.base;

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
import androidx.navigation.Navigation;

import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.data.DataAction;
import com.conchonha.bookmovietickets.ui.page.MainActivity;
import com.conchonha.bookmovietickets.utils.DialogUtils;

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
                    default:
                        throw new IllegalStateException("No implement method: " + dataAction.getEventSender().ordinal());
                }
            }
        });
    }

    protected void navigation(int actionId, Bundle bundle){
        Navigation.findNavController(requireView()).navigate(actionId,bundle);
    }

    protected abstract int getLayout();

    private MainActivity getActivityMain(){
        if(getActivity().getClass().equals(MainActivity.class)){
            return (MainActivity) getActivity();
        }
        return null;
    }
}
