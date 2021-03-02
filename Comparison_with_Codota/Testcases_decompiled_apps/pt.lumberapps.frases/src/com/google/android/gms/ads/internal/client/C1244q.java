package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhp;

/* renamed from: com.google.android.gms.ads.internal.client.q */
class C1244q extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Activity f3489a;

    /* renamed from: b */
    final /* synthetic */ zzl f3490b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1244q(zzl zzl, Activity activity) {
        super(zzl, (C1237j) null);
        this.f3490b = zzl;
        this.f3489a = activity;
    }

    /* renamed from: a */
    public zzhp mo5061b() {
        zzhp zzg = this.f3490b.f3605h.zzg(this.f3489a);
        if (zzg != null) {
            return zzg;
        }
        this.f3490b.m5606a((Context) this.f3489a, "iap");
        return null;
    }

    /* renamed from: a */
    public zzhp mo5062b(zzx zzx) {
        return zzx.createInAppPurchaseManager(zze.zzac(this.f3489a));
    }
}
