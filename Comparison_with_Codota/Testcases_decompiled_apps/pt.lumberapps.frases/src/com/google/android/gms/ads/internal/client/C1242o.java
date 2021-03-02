package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdt;

/* renamed from: com.google.android.gms.ads.internal.client.o */
class C1242o extends C1246s {

    /* renamed from: a */
    final /* synthetic */ FrameLayout f3482a;

    /* renamed from: b */
    final /* synthetic */ FrameLayout f3483b;

    /* renamed from: c */
    final /* synthetic */ Context f3484c;

    /* renamed from: d */
    final /* synthetic */ zzl f3485d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1242o(zzl zzl, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        super(zzl, (C1237j) null);
        this.f3485d = zzl;
        this.f3482a = frameLayout;
        this.f3483b = frameLayout2;
        this.f3484c = context;
    }

    /* renamed from: a */
    public zzdt mo5061b() {
        zzdt zzb = this.f3485d.f3603f.zzb(this.f3484c, this.f3482a, this.f3483b);
        if (zzb != null) {
            return zzb;
        }
        this.f3485d.m5606a(this.f3484c, "native_ad_view_delegate");
        return new zzam();
    }

    /* renamed from: a */
    public zzdt mo5062b(zzx zzx) {
        return zzx.createNativeAdViewDelegate(zze.zzac(this.f3482a), zze.zzac(this.f3483b));
    }
}
