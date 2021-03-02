package android.support.p001v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: android.support.v4.net.ConnectivityManagerCompat */
public class ConnectivityManagerCompat {

    /* renamed from: a */
    private static final C0215b f762a;

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$b */
    interface C0215b {
        /* renamed from: a */
        boolean mo1442a(ConnectivityManager connectivityManager);
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$a */
    static class C0214a implements C0215b {
        C0214a() {
        }

        /* renamed from: a */
        public boolean mo1442a(ConnectivityManager connectivityManager) {
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

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$c */
    static class C0216c implements C0215b {
        C0216c() {
        }

        /* renamed from: a */
        public boolean mo1442a(ConnectivityManager connectivityManager) {
            return C0651ca.m3569a(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$d */
    static class C0217d implements C0215b {
        C0217d() {
        }

        /* renamed from: a */
        public boolean mo1442a(ConnectivityManager connectivityManager) {
            return C0652cb.m3570a(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$e */
    static class C0218e implements C0215b {
        C0218e() {
        }

        /* renamed from: a */
        public boolean mo1442a(ConnectivityManager connectivityManager) {
            return C0653cc.m3571a(connectivityManager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f762a = new C0218e();
        } else if (Build.VERSION.SDK_INT >= 13) {
            f762a = new C0217d();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f762a = new C0216c();
        } else {
            f762a = new C0214a();
        }
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return f762a.mo1442a(connectivityManager);
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }
}
