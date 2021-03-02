package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzju;

/* renamed from: com.google.android.gms.ads.internal.request.k */
class C1310k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzju.zza f3924a;

    /* renamed from: b */
    final /* synthetic */ zzn f3925b;

    C1310k(zzn zzn, zzju.zza zza) {
        this.f3925b = zzn;
        this.f3924a = zza;
    }

    public void run() {
        this.f3925b.f3962h.zza(this.f3924a);
        if (this.f3925b.f3966l != null) {
            this.f3925b.f3966l.release();
            zzfs.zzc unused = this.f3925b.f3966l = null;
        }
    }
}
