package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.k */
class C1238k extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3467a;

    /* renamed from: b */
    final /* synthetic */ AdSizeParcel f3468b;

    /* renamed from: c */
    final /* synthetic */ String f3469c;

    /* renamed from: d */
    final /* synthetic */ zzl f3470d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1238k(zzl zzl, Context context, AdSizeParcel adSizeParcel, String str) {
        super(zzl, (C1237j) null);
        this.f3470d = zzl;
        this.f3467a = context;
        this.f3468b = adSizeParcel;
        this.f3469c = str;
    }

    /* renamed from: a */
    public zzu mo5061b() {
        zzu zza = this.f3470d.f3600c.zza(this.f3467a, this.f3468b, this.f3469c, (zzgj) null, 3);
        if (zza != null) {
            return zza;
        }
        this.f3470d.m5606a(this.f3467a, "search");
        return new zzak();
    }

    /* renamed from: a */
    public zzu mo5062b(zzx zzx) {
        return zzx.createSearchAdManager(zze.zzac(this.f3467a), this.f3468b, this.f3469c, com.google.android.gms.common.internal.zze.f4556xM);
    }
}
