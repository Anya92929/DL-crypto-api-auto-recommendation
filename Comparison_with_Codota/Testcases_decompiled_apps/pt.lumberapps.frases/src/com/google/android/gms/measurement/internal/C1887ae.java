package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

/* renamed from: com.google.android.gms.measurement.internal.ae */
class C1887ae {

    /* renamed from: a */
    private final zze f7079a;

    /* renamed from: b */
    private long f7080b;

    public C1887ae(zze zze) {
        zzab.zzy(zze);
        this.f7079a = zze;
    }

    /* renamed from: a */
    public void mo9219a() {
        this.f7080b = this.f7079a.elapsedRealtime();
    }

    /* renamed from: a */
    public boolean mo9220a(long j) {
        return this.f7080b == 0 || this.f7079a.elapsedRealtime() - this.f7080b >= j;
    }

    /* renamed from: b */
    public void mo9221b() {
        this.f7080b = 0;
    }
}
