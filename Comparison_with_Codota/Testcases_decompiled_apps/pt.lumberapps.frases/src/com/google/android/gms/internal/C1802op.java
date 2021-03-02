package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.op */
class C1802op implements zzd.zzf {

    /* renamed from: a */
    private final WeakReference f5445a;

    /* renamed from: b */
    private final Api f5446b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f5447c;

    public C1802op(zzpw zzpw, Api api, int i) {
        this.f5445a = new WeakReference(zzpw);
        this.f5446b = api;
        this.f5447c = i;
    }

    public void zzh(ConnectionResult connectionResult) {
        boolean z = false;
        zzpw zzpw = (zzpw) this.f5445a.get();
        if (zzpw != null) {
            if (Looper.myLooper() == zzpw.f6815a.f6867g.getLooper()) {
                z = true;
            }
            zzab.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzpw.f6816b.lock();
            try {
                if (zzpw.m7442a(0)) {
                    if (!connectionResult.isSuccess()) {
                        zzpw.m7435a(connectionResult, this.f5446b, this.f5447c);
                    }
                    if (zzpw.m7441a()) {
                        zzpw.m7448b();
                    }
                    zzpw.f6816b.unlock();
                }
            } finally {
                zzpw.f6816b.unlock();
            }
        }
    }
}
