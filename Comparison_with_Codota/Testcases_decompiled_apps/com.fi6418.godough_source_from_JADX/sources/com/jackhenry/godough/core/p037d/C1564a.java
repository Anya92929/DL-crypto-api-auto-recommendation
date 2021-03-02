package com.jackhenry.godough.core.p037d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Set;

/* renamed from: com.jackhenry.godough.core.d.a */
public class C1564a extends BroadcastReceiver {

    /* renamed from: b */
    private static boolean f6116b;

    /* renamed from: a */
    private Set<C1565b> f6117a;

    /* renamed from: a */
    private static void m6119a(Context context) {
        f6116b = false;
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if ((networkInfo.getType() == 0 || networkInfo.getType() == 1 || networkInfo.getType() == 6 || networkInfo.getType() == 9) && networkInfo.isAvailable()) {
                    f6116b = true;
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m6120a() {
        return f6116b;
    }

    public void onReceive(Context context, Intent intent) {
        m6119a(context);
        for (C1565b a : this.f6117a) {
            a.mo9777a(f6116b);
        }
    }
}
