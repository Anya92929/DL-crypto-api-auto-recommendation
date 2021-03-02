package p000;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: ca */
public class C0651ca {
    /* renamed from: a */
    public static boolean m3569a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case 1:
                return false;
            default:
                return true;
        }
    }
}
