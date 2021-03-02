package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.lb */
class C1707lb {

    /* renamed from: a */
    public final long f5273a = zzu.zzfu().currentTimeMillis();

    /* renamed from: b */
    public final zziv f5274b;

    /* renamed from: c */
    final /* synthetic */ zziw f5275c;

    public C1707lb(zziw zziw, zziv zziv) {
        this.f5275c = zziw;
        this.f5274b = zziv;
    }

    /* renamed from: a */
    public boolean mo7461a() {
        return ((Long) zzdc.zzbat.get()).longValue() + this.f5273a < zzu.zzfu().currentTimeMillis();
    }
}
