package com.google.android.gms.measurement.internal;

import android.os.Looper;

/* renamed from: com.google.android.gms.measurement.internal.ak */
class C1893ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1892aj f7091a;

    C1893ak(C1892aj ajVar) {
        this.f7091a = ajVar;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f7091a.f7087a.zzbsc().zzm(this);
            return;
        }
        boolean b = this.f7091a.mo9234b();
        long unused = this.f7091a.f7089d = 0;
        if (b && this.f7091a.f7090e) {
            this.f7091a.mo9215a();
        }
    }
}
