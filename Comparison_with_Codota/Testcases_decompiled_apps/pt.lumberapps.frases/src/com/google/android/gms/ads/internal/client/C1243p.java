package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.p */
class C1243p extends C1246s {

    /* renamed from: a */
    final /* synthetic */ Context f3486a;

    /* renamed from: b */
    final /* synthetic */ zzgj f3487b;

    /* renamed from: c */
    final /* synthetic */ zzl f3488c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1243p(zzl zzl, Context context, zzgj zzgj) {
        super(zzl, (C1237j) null);
        this.f3488c = zzl;
        this.f3486a = context;
        this.f3487b = zzgj;
    }

    /* renamed from: a */
    public zzb mo5061b() {
        zzb zzb = this.f3488c.f3604g.zzb(this.f3486a, this.f3487b);
        if (zzb != null) {
            return zzb;
        }
        this.f3488c.m5606a(this.f3486a, "rewarded_video");
        return new zzan();
    }

    /* renamed from: a */
    public zzb mo5062b(zzx zzx) {
        return zzx.createRewardedVideoAd(zze.zzac(this.f3486a), this.f3487b, com.google.android.gms.common.internal.zze.f4556xM);
    }
}
