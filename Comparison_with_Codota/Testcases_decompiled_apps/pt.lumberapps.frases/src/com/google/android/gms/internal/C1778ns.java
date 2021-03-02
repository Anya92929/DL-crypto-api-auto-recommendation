package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.google.android.gms.internal.ns */
class C1778ns implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GoogleApiClient f5403a;

    /* renamed from: b */
    final /* synthetic */ C1780nu f5404b;

    /* renamed from: c */
    final /* synthetic */ zzpb f5405c;

    C1778ns(zzpb zzpb, GoogleApiClient googleApiClient, C1780nu nuVar) {
        this.f5405c = zzpb;
        this.f5403a = googleApiClient;
        this.f5404b = nuVar;
    }

    public void run() {
        this.f5403a.zzc(this.f5404b);
    }
}
