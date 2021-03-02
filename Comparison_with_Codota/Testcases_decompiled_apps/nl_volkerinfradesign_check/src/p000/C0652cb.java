package p000;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: cb */
public class C0652cb {
    /* renamed from: a */
    public static boolean m3570a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case 1:
            case 7:
            case 9:
                return false;
            default:
                return true;
        }
    }
}
