package android.support.p000v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: android.support.v4.net.ConnectivityManagerCompat */
public class ConnectivityManagerCompat {

    /* renamed from: a */
    private static final ConnectivityManagerCompatImpl f1002a;

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl */
    class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
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

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl */
    interface ConnectivityManagerCompatImpl {
        boolean isActiveNetworkMetered(ConnectivityManager connectivityManager);
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl */
    class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        GingerbreadConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl */
    class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(connectivityManager);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl */
    class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }

        public boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(connectivityManager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f1002a = new JellyBeanConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 13) {
            f1002a = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            f1002a = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            f1002a = new BaseConnectivityManagerCompatImpl();
        }
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return f1002a.isActiveNetworkMetered(connectivityManager);
    }
}
