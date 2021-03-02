package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.im */
class C1637im implements Callable {

    /* renamed from: a */
    final /* synthetic */ zzgd f5144a;

    /* renamed from: b */
    final /* synthetic */ zzgg f5145b;

    C1637im(zzgg zzgg, zzgd zzgd) {
        this.f5145b = zzgg;
        this.f5144a = zzgd;
    }

    /* renamed from: a */
    public zzge call() {
        synchronized (this.f5145b.f6244i) {
            if (this.f5145b.f6245j) {
                return null;
            }
            return this.f5144a.zza(this.f5145b.f6241f, this.f5145b.f6242g);
        }
    }
}
