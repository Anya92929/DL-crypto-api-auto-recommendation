package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0562j;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0646bh;

/* renamed from: com.google.android.gms.analytics.e */
public class C0508e extends BroadcastReceiver {

    /* renamed from: a */
    static Object f3679a = new Object();

    /* renamed from: b */
    static C0646bh f3680b;

    /* renamed from: c */
    static Boolean f3681c;

    /* renamed from: a */
    public static boolean m2963a(Context context) {
        C1009bf.m4528a(context);
        if (f3681c != null) {
            return f3681c.booleanValue();
        }
        boolean a = C0570r.m3334a(context, (Class<? extends BroadcastReceiver>) C0508e.class, true);
        f3681c = Boolean.valueOf(a);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class<? extends C0509f> mo6576a() {
        return C0509f.class;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6577a(String str) {
    }

    public void onReceive(Context context, Intent intent) {
        C0516ac a = C0516ac.m2979a(context);
        C0562j f = a.mo6604f();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        f.mo6866a("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            f.mo6879e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean a2 = C0509f.m2967a(context);
        if (!a2) {
            f.mo6879e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        mo6577a(stringExtra);
        if (a.mo6603e().mo6731a()) {
            f.mo6881f("Received unexpected installation campaign on package side");
            return;
        }
        Class<? extends C0509f> a3 = mo6576a();
        C1009bf.m4528a(a3);
        Intent intent2 = new Intent(context, a3);
        intent2.putExtra("referrer", stringExtra);
        synchronized (f3679a) {
            context.startService(intent2);
            if (a2) {
                try {
                    if (f3680b == null) {
                        f3680b = new C0646bh(context, 1, "Analytics campaign WakeLock");
                        f3680b.mo7130a(false);
                    }
                    f3680b.mo7128a(1000);
                } catch (SecurityException e) {
                    f.mo6879e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
            }
        }
    }
}
