package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.kz */
class C1704kz implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzir f5259a;

    C1704kz(zzir zzir) {
        this.f5259a = zzir;
    }

    public void zza(zzlh zzlh, Map map) {
        synchronized (this.f5259a.f6440b) {
            if (!this.f5259a.f6443e.isDone()) {
                C1706la laVar = new C1706la(-2, map);
                if (this.f5259a.f6441c.equals(laVar.mo7459g())) {
                    laVar.mo7460h();
                    this.f5259a.f6443e.zzh(laVar);
                }
            }
        }
    }
}
