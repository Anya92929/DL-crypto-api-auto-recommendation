package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.zzad;

/* renamed from: com.google.android.gms.measurement.internal.u */
class C1941u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzad.zza f7233a;

    C1941u(zzad.zza zza) {
        this.f7233a = zza;
    }

    public void run() {
        zzad.this.m7750a(new ComponentName(zzad.this.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
