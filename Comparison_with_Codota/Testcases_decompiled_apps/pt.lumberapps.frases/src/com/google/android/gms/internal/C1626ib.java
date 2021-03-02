package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.internal.ib */
class C1626ib implements zzla.zza {

    /* renamed from: a */
    final /* synthetic */ zzfs.zzd f5127a;

    /* renamed from: b */
    final /* synthetic */ zzfs f5128b;

    C1626ib(zzfs zzfs, zzfs.zzd zzd) {
        this.f5128b = zzfs;
        this.f5127a = zzd;
    }

    public void run() {
        synchronized (this.f5128b.f6193a) {
            int unused = this.f5128b.f6200h = 1;
            zzkd.m7303v("Failed loading new engine. Marking new engine destroyable.");
            this.f5127a.zzmd();
        }
    }
}
