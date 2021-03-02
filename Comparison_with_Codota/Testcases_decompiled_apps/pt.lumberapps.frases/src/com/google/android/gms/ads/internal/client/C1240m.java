package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.m */
class C1240m extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3476a;

    /* renamed from: b */
    final /* synthetic */ String f3477b;

    /* renamed from: c */
    final /* synthetic */ zzgj f3478c;

    /* renamed from: d */
    final /* synthetic */ zzl f3479d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1240m(zzl zzl, Context context, String str, zzgj zzgj) {
        super(zzl, (C1237j) null);
        this.f3479d = zzl;
        this.f3476a = context;
        this.f3477b = str;
        this.f3478c = zzgj;
    }

    /* renamed from: a */
    public zzs mo5061b() {
        zzs zza = this.f3479d.f3601d.zza(this.f3476a, this.f3477b, this.f3478c);
        if (zza != null) {
            return zza;
        }
        this.f3479d.m5606a(this.f3476a, "native_ad");
        return new zzaj();
    }

    /* renamed from: a */
    public zzs mo5062b(zzx zzx) {
        return zzx.createAdLoaderBuilder(zze.zzac(this.f3476a), this.f3477b, this.f3478c, com.google.android.gms.common.internal.zze.f4556xM);
    }
}
