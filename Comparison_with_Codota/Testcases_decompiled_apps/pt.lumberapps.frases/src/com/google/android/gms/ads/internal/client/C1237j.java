package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.j */
class C1237j extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3462a;

    /* renamed from: b */
    final /* synthetic */ AdSizeParcel f3463b;

    /* renamed from: c */
    final /* synthetic */ String f3464c;

    /* renamed from: d */
    final /* synthetic */ zzgj f3465d;

    /* renamed from: e */
    final /* synthetic */ zzl f3466e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1237j(zzl zzl, Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj) {
        super(zzl, (C1237j) null);
        this.f3466e = zzl;
        this.f3462a = context;
        this.f3463b = adSizeParcel;
        this.f3464c = str;
        this.f3465d = zzgj;
    }

    /* renamed from: a */
    public zzu mo5061b() {
        zzu zza = this.f3466e.f3600c.zza(this.f3462a, this.f3463b, this.f3464c, this.f3465d, 1);
        if (zza != null) {
            return zza;
        }
        this.f3466e.m5606a(this.f3462a, "banner");
        return new zzak();
    }

    /* renamed from: a */
    public zzu mo5062b(zzx zzx) {
        return zzx.createBannerAdManager(zze.zzac(this.f3462a), this.f3463b, this.f3464c, this.f3465d, com.google.android.gms.common.internal.zze.f4556xM);
    }
}
