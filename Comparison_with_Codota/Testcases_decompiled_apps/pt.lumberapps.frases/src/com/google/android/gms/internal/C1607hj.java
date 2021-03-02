package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* renamed from: com.google.android.gms.internal.hj */
class C1607hj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f5086a;

    /* renamed from: b */
    final /* synthetic */ VersionInfoParcel f5087b;

    /* renamed from: c */
    final /* synthetic */ C1609hl f5088c;

    /* renamed from: d */
    final /* synthetic */ zzas f5089d;

    /* renamed from: e */
    final /* synthetic */ String f5090e;

    /* renamed from: f */
    final /* synthetic */ zzfq f5091f;

    C1607hj(zzfq zzfq, Context context, VersionInfoParcel versionInfoParcel, C1609hl hlVar, zzas zzas, String str) {
        this.f5091f = zzfq;
        this.f5086a = context;
        this.f5087b = versionInfoParcel;
        this.f5088c = hlVar;
        this.f5089d = zzas;
        this.f5090e = str;
    }

    public void run() {
        this.f5091f.m7051a(this.f5086a, this.f5087b, this.f5088c, this.f5089d).zzbh(this.f5090e);
    }
}
