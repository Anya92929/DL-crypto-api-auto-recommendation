package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.zzad;

/* renamed from: com.google.android.gms.measurement.internal.s */
class C1939s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ComponentName f7229a;

    /* renamed from: b */
    final /* synthetic */ zzad.zza f7230b;

    C1939s(zzad.zza zza, ComponentName componentName) {
        this.f7230b = zza;
        this.f7229a = componentName;
    }

    public void run() {
        zzad.this.m7750a(this.f7229a);
    }
}
