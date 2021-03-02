package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.ads.internal.n */
class C1275n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzfs f3724a;

    /* renamed from: b */
    final /* synthetic */ String f3725b;

    /* renamed from: c */
    final /* synthetic */ String f3726c;

    /* renamed from: d */
    final /* synthetic */ boolean f3727d;

    /* renamed from: e */
    final /* synthetic */ Context f3728e;

    /* renamed from: f */
    final /* synthetic */ zzg f3729f;

    C1275n(zzg zzg, zzfs zzfs, String str, String str2, boolean z, Context context) {
        this.f3729f = zzg;
        this.f3724a = zzfs;
        this.f3725b = str;
        this.f3726c = str2;
        this.f3727d = z;
        this.f3728e = context;
    }

    public void run() {
        this.f3724a.zzma().zza(new C1276o(this), new zzla.zzb());
    }
}
