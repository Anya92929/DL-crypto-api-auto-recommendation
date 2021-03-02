package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;

/* renamed from: com.google.android.gms.internal.os */
class C1805os extends C1818pe {

    /* renamed from: a */
    final /* synthetic */ zzd.zzf f5452a;

    /* renamed from: b */
    final /* synthetic */ C1803oq f5453b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1805os(C1803oq oqVar, zzpz zzpz, zzd.zzf zzf) {
        super(zzpz);
        this.f5453b = oqVar;
        this.f5452a = zzf;
    }

    /* renamed from: a */
    public void mo7625a() {
        this.f5452a.zzh(new ConnectionResult(16, (PendingIntent) null));
    }
}
