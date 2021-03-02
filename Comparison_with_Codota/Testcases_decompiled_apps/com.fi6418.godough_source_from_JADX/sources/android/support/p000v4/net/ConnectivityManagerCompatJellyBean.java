package android.support.p000v4.net;

import android.net.ConnectivityManager;

/* renamed from: android.support.v4.net.ConnectivityManagerCompatJellyBean */
class ConnectivityManagerCompatJellyBean {
    ConnectivityManagerCompatJellyBean() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
