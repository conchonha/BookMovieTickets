package com.conchonha.bookmovietickets.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.app.MyApplication;
import com.conchonha.bookmovietickets.base.BaseViewModel;
import com.conchonha.bookmovietickets.utils.SharePrefs;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.Stripe;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

public class PayViewModel extends BaseViewModel {
    public PayViewModel(@NonNull Application application) {
        super(application);
    }

    public void payFilm(CardInputWidget cardInput){
        Stripe stripe = new Stripe(getApplication(), "pk_test_y8urHXEikr7ysm3tk7uRilcp00aTSdh57w");
        try {
            stripe.createCardToken(
                    cardInput.getCard(),
                    new ApiResultCallback<Token>() {
                        public void onSuccess(@NonNull final Token token) {
                            MyApplication.cart.listChair.forEach(integer -> {
                                sharePrefs.put(MyApplication.cart.cinema.name.trim()+integer,true);
                            });
                            MyApplication.cart.idUser = MyApplication.user.id;
                            queryRoomCompletable(db.cartDao().insert(MyApplication.cart),data -> {
                                showToast(getString(R.string.pay_success));
                            });
                        }

                        public void onError(@NonNull Exception error) {
                            Log.d(TAG, "onError: " + error);
                            Toast.makeText(getApplication(), "Stripper is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }catch (Exception e){
            Toast.makeText(getApplication(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
