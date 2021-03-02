package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0562j;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0646bh;

/* renamed from: com.google.android.gms.analytics.a */
public final class C0501a extends BroadcastReceiver {

    /* renamed from: a */
    static Object f3666a = new Object();

    /* renamed from: b */
    static C0646bh f3667b;

    /* renamed from: c */
    static Boolean f3668c;

    /* renamed from: a */
    public static boolean m2952a(Context context) {
        C1009bf.m4528a(context);
        if (f3668c != null) {
            return f3668c.booleanValue();
        }
        boolean a = C0570r.m3334a(context, (Class<? extends BroadcastReceiver>) C0501a.class, false);
        f3668c = Boolean.valueOf(a);
        return a;
    }

    public void onReceive(Context context, Intent intent) {
        C0516ac a = C0516ac.m2979a(context);
        C0562j f = a.mo6604f();
        String action = intent.getAction();
        if (a.mo6603e().mo6731a()) {
            f.mo6866a("Device AnalyticsReceiver got", action);
        } else {
            f.mo6866a("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean a2 = C0505b.m2961a(context);
            Intent intent2 = new Intent(context, C0505b.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f3666a) {
                context.startService(intent2);
                if (a2) {
                    try {
                        if (f3667b == null) {
                            f3667b = new C0646bh(context, 1, "Analytics WakeLock");
                            f3667b.mo7130a(false);
                        }
                        f3667b.mo7128a(1000);
                    } catch (SecurityException e) {
                        f.mo6879e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
                return;
            }
        }
        return;
    }
}
