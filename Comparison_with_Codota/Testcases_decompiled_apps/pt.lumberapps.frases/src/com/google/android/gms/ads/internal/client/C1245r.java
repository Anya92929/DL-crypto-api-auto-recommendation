package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhi;

/* renamed from: com.google.android.gms.ads.internal.client.r */
class C1245r extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Activity f3491a;

    /* renamed from: b */
    final /* synthetic */ zzl f3492b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1245r(zzl zzl, Activity activity) {
        super(zzl, (C1237j) null);
        this.f3492b = zzl;
        this.f3491a = activity;
    }

    /* renamed from: a */
    public zzhi mo5061b() {
        zzhi zzf = this.f3492b.f3606i.zzf(this.f3491a);
        if (zzf != null) {
            return zzf;
        }
        this.f3492b.m5606a((Context) this.f3491a, "ad_overlay");
        return null;
    }

    /* renamed from: a */
    public zzhi mo5062b(zzx zzx) {
        return zzx.createAdOverlay(zze.zzac(this.f3491a));
    }
}
