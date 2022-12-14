package com.conchonha.bookmovietickets.utils;

import android.content.Context;
import android.location.LocationManager;

import java.lang.reflect.Array;
import java.util.Objects;

public class Validations {
    public static boolean isPassAndConfirmPass(String pass,String confirmPass){
        if(isPassword(pass) && pass.equals(confirmPass)){
            return true;
        }
        return false;
    }
    public static boolean isLogin(String email , String pass) {
        if(isEmail(email) && isPassword(pass)){
            return  true;
        }
        return false;
    }

    public static boolean isRegister(String email, String pass, String phone) {
        if (isEmail(email)  && isPassword(pass) && (phone != null || !phone.isEmpty())) {
            return true;
        }
        return false;
    }

    public static boolean isHeightAndWeight(String valuate) {
        try {
            Float.parseFloat(valuate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFullName(String valuate) {
        if (valuate.equals("")) {
            return false;
        }
        return true;
    }

    public static boolean isAge(String valuate) {
        try {
            if (Integer.parseInt(valuate) >= 100 || Integer.parseInt(valuate) < 1 || valuate == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isPassword(String value) {
        if (value == null || value.equals("") || value.length() <= 6) {
            return false;
        }
        return true;
    }

    public static boolean isEmail(String value) {
        if (value == null || value.equals("") || !value.endsWith("@gmail.com")) {
            return false;
        }
        return true;
    }

    public static Boolean checkGpsStatus(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
}