package com.conchonha.bookmovietickets.ui.fragment.pay;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.base.BaseFragment;
import com.conchonha.bookmovietickets.databinding.FragmentPayBinding;
import com.conchonha.bookmovietickets.viewmodel.PayViewModel;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.Stripe;
import com.stripe.android.model.Token;


public class FragmentPay extends BaseFragment<FragmentPayBinding, PayViewModel> {
    @Override
    protected Class<PayViewModel> getClassName() {
        return PayViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_pay;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cardInput.setPostalCodeEnabled(false);

        binding.payBtn.setOnClickListener(view1 -> {
            Stripe stripe = new Stripe(requireContext(), "pk_test_y8urHXEikr7ysm3tk7uRilcp00aTSdh57w");
            try {
                stripe.createCardToken(
                        binding.cardInput.getCard(),
                        new ApiResultCallback<Token>() {
                            public void onSuccess(@NonNull final Token token) {

                            }

                            public void onError(@NonNull Exception error) {
                                Log.d(TAG, "onError: " + error);
                                Toast.makeText(requireContext(), "Stripper is incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }catch (Exception e){
                Toast.makeText(requireContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
