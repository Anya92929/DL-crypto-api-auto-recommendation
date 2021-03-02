package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.l */
class C1239l extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3471a;

    /* renamed from: b */
    final /* synthetic */ AdSizeParcel f3472b;

    /* renamed from: c */
    final /* synthetic */ String f3473c;

    /* renamed from: d */
    final /* synthetic */ zzgj f3474d;

    /* renamed from: e */
    final /* synthetic */ zzl f3475e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1239l(zzl zzl, Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj) {
        super(zzl, (C1237j) null);
        this.f3475e = zzl;
        this.f3471a = context;
        this.f3472b = adSizeParcel;
        this.f3473c = str;
        this.f3474d = zzgj;
    }

    /* renamed from: a */
    public zzu mo5061b() {
        zzu zza = this.f3475e.f3600c.zza(this.f3471a, this.f3472b, this.f3473c, this.f3474d, 2);
        if (zza != null) {
            return zza;
        }
        this.f3475e.m5606a(this.f3471a, "interstitial");
        return new zzak();
    }

    /* renamed from: a */
    public zzu mo5062b(zzx zzx) {
        return zzx.createInterstitialAdManager(zze.zzac(this.f3471a), this.f3472b, this.f3473c, this.f3474d, com.google.android.gms.common.internal.zze.f4556xM);
    }
}
