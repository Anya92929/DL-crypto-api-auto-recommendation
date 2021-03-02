package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfs;

/* renamed from: com.google.android.gms.internal.kr */
final class C1696kr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzfs f5241a;

    /* renamed from: b */
    final /* synthetic */ zzir f5242b;

    /* renamed from: c */
    final /* synthetic */ zzdk f5243c;

    /* renamed from: d */
    final /* synthetic */ zzdi f5244d;

    /* renamed from: e */
    final /* synthetic */ String f5245e;

    C1696kr(zzfs zzfs, zzir zzir, zzdk zzdk, zzdi zzdi, String str) {
        this.f5241a = zzfs;
        this.f5242b = zzir;
        this.f5243c = zzdk;
        this.f5244d = zzdi;
        this.f5245e = str;
    }

    public void run() {
        zzfs.zzc zzma = this.f5241a.zzma();
        this.f5242b.zzb(zzma);
        this.f5243c.zza(this.f5244d, "rwc");
        zzma.zza(new C1697ks(this, this.f5243c.zzkg()), new C1698kt(this));
    }
}
