package com.conchonha.bookmovietickets.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.conchonha.bookmovietickets.R;
import com.conchonha.bookmovietickets.databinding.DialogConfirmAlertBinding;

public class DialogUtils {
    public static void showAlertDialog(Context context,String message){
        Dialog dialog = new Dialog(context);
        //binding
        DialogConfirmAlertBinding binding = DialogConfirmAlertBinding.inflate(LayoutInflater.from(context));
        binding.txtTitle.setText(R.string.lbl_dialog);
        binding.txtContent.setText(message);
        binding.txtOke.setOnClickListener(view -> {
            dialog.dismiss();
        });
        //custom
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        dialog.setContentView(binding.getRoot());
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(true);
        dialog.show();
    }
}
