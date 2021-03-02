package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0549bi;
import com.google.android.gms.analytics.internal.C0562j;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0646bh;

/* renamed from: com.google.android.gms.analytics.b */
public final class C0505b extends Service {

    /* renamed from: b */
    private static Boolean f3672b;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f3673a = new Handler();

    /* renamed from: a */
    private void m2960a() {
        try {
            synchronized (C0501a.f3666a) {
                C0646bh bhVar = C0501a.f3667b;
                if (bhVar != null && bhVar.mo7131b()) {
                    bhVar.mo7127a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    /* renamed from: a */
    public static boolean m2961a(Context context) {
        C1009bf.m4528a(context);
        if (f3672b != null) {
            return f3672b.booleanValue();
        }
        boolean a = C0570r.m3333a(context, (Class<? extends Service>) C0505b.class);
        f3672b = Boolean.valueOf(a);
        return a;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C0516ac a = C0516ac.m2979a((Context) this);
        C0562j f = a.mo6604f();
        if (a.mo6603e().mo6731a()) {
            f.mo6869b("Device AnalyticsService is starting up");
        } else {
            f.mo6869b("Local AnalyticsService is starting up");
        }
    }

    public void onDestroy() {
        C0516ac a = C0516ac.m2979a((Context) this);
        C0562j f = a.mo6604f();
        if (a.mo6603e().mo6731a()) {
            f.mo6869b("Device AnalyticsService is shutting down");
        } else {
            f.mo6869b("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m2960a();
        C0516ac a = C0516ac.m2979a((Context) this);
        C0562j f = a.mo6604f();
        String action = intent.getAction();
        if (a.mo6603e().mo6731a()) {
            f.mo6867a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.mo6867a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            a.mo6607i().mo6847a((C0549bi) new C0506c(this, i2, a, f));
        }
        return 2;
    }
}
