package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;

/* renamed from: com.google.android.gms.internal.ld */
class C1709ld implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdRequestParcel f5278a;

    /* renamed from: b */
    final /* synthetic */ zzgk f5279b;

    /* renamed from: c */
    final /* synthetic */ zzjg f5280c;

    C1709ld(zzjg zzjg, AdRequestParcel adRequestParcel, zzgk zzgk) {
        this.f5280c = zzjg;
        this.f5278a = adRequestParcel;
        this.f5279b = zzgk;
    }

    public void run() {
        this.f5280c.m7273a(this.f5278a, this.f5279b);
    }
}
