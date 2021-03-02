package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0562j;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0646bh;

/* renamed from: com.google.android.gms.analytics.f */
public class C0509f extends Service {

    /* renamed from: b */
    private static Boolean f3682b;

    /* renamed from: a */
    private Handler f3683a;

    /* renamed from: a */
    private void m2966a() {
        try {
            synchronized (C0508e.f3679a) {
                C0646bh bhVar = C0508e.f3680b;
                if (bhVar != null && bhVar.mo7131b()) {
                    bhVar.mo7127a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    /* renamed from: a */
    public static boolean m2967a(Context context) {
        C1009bf.m4528a(context);
        if (f3682b != null) {
            return f3682b.booleanValue();
        }
        boolean a = C0570r.m3333a(context, (Class<? extends Service>) C0509f.class);
        f3682b = Boolean.valueOf(a);
        return a;
    }

    /* renamed from: b */
    private Handler m2968b() {
        Handler handler = this.f3683a;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.f3683a = handler2;
        return handler2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6579a(C0562j jVar, Handler handler, int i) {
        handler.post(new C0512i(this, i, jVar));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C0516ac.m2979a((Context) this).mo6604f().mo6869b("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        C0516ac.m2979a((Context) this).mo6604f().mo6869b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m2966a();
        C0516ac a = C0516ac.m2979a((Context) this);
        C0562j f = a.mo6604f();
        String str = null;
        if (a.mo6603e().mo6731a()) {
            f.mo6881f("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler b = m2968b();
        if (TextUtils.isEmpty(str)) {
            if (!a.mo6603e().mo6731a()) {
                f.mo6879e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            a.mo6606h().mo7018a((Runnable) new C0510g(this, f, b, i2));
        } else {
            int e = a.mo6603e().mo6735e();
            if (str.length() > e) {
                f.mo6875c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(e));
                str = str.substring(0, e);
            }
            f.mo6867a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            a.mo6607i().mo6849a(str, new C0511h(this, f, b, i2));
        }
        return 2;
    }
}
