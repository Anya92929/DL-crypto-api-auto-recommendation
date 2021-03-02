package com.tapcrowd.app.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Check {
    public static boolean isConnectedToInternet() {
        NetworkInfo ni;
        ConnectivityManager cm = (ConnectivityManager) App.act.getSystemService("connectivity");
        if (cm == null || (ni = cm.getActiveNetworkInfo()) == null || !ni.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
