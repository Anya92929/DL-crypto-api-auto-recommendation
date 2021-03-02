package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.ads.internal.q */
class C1298q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdRequestParcel f3900a;

    /* renamed from: b */
    final /* synthetic */ zzj f3901b;

    C1298q(zzj zzj, AdRequestParcel adRequestParcel) {
        this.f3901b = zzj;
        this.f3900a = adRequestParcel;
    }

    public void run() {
        synchronized (this.f3901b.f4039o) {
            zzq a = this.f3901b.mo5859a();
            WeakReference unused = this.f3901b.f4037m = new WeakReference(a);
            a.zzb(this.f3901b.f4028d);
            a.zzb(this.f3901b.f4029e);
            a.zza(this.f3901b.f4030f);
            a.zza(this.f3901b.f4026b);
            a.zzb(this.f3901b.f4031g);
            a.zzb(this.f3901b.m5809b());
            a.zzb(this.f3901b.f4032h);
            a.zza(this.f3901b.f4034j);
            a.zzb(this.f3900a);
        }
    }
}
