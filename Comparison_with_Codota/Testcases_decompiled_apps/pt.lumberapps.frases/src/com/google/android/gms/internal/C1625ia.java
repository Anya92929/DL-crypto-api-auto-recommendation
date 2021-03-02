package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.internal.ia */
class C1625ia implements zzla.zzc {

    /* renamed from: a */
    final /* synthetic */ zzfs.zzd f5125a;

    /* renamed from: b */
    final /* synthetic */ zzfs f5126b;

    C1625ia(zzfs zzfs, zzfs.zzd zzd) {
        this.f5126b = zzfs;
        this.f5125a = zzd;
    }

    /* renamed from: a */
    public void zzd(zzfp zzfp) {
        synchronized (this.f5126b.f6193a) {
            int unused = this.f5126b.f6200h = 0;
            if (!(this.f5126b.f6199g == null || this.f5125a == this.f5126b.f6199g)) {
                zzkd.m7303v("New JS engine is loaded, marking previous one as destroyable.");
                this.f5126b.f6199g.zzmd();
            }
            zzfs.zzd unused2 = this.f5126b.f6199g = this.f5125a;
        }
    }
}
