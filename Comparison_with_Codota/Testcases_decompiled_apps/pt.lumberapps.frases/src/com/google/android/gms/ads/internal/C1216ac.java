package com.google.android.gms.ads.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.ads.internal.ac */
class C1216ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WeakReference f3437a;

    /* renamed from: b */
    final /* synthetic */ zzr f3438b;

    C1216ac(zzr zzr, WeakReference weakReference) {
        this.f3438b = zzr;
        this.f3437a = weakReference;
    }

    public void run() {
        boolean unused = this.f3438b.f4067d = false;
        zza zza = (zza) this.f3437a.get();
        if (zza != null) {
            zza.zzd(this.f3438b.f4066c);
        }
    }
}
