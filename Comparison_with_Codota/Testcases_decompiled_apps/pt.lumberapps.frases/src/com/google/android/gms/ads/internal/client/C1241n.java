package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.zze;

/* renamed from: com.google.android.gms.ads.internal.client.n */
class C1241n extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3480a;

    /* renamed from: b */
    final /* synthetic */ zzl f3481b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1241n(zzl zzl, Context context) {
        super(zzl, (C1237j) null);
        this.f3481b = zzl;
        this.f3480a = context;
    }

    /* renamed from: a */
    public zzz mo5061b() {
        zzz zzm = this.f3481b.f3602e.zzm(this.f3480a);
        if (zzm != null) {
            return zzm;
        }
        this.f3481b.m5606a(this.f3480a, "mobile_ads_settings");
        return new zzal();
    }

    /* renamed from: a */
    public zzz mo5062b(zzx zzx) {
        return zzx.getMobileAdsSettingsManagerWithClientJarVersion(zze.zzac(this.f3480a), com.google.android.gms.common.internal.zze.f4556xM);
    }
}
