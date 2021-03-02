package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.oz */
class C1812oz implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f5463a;

    /* renamed from: b */
    final /* synthetic */ zzqu f5464b;

    /* renamed from: c */
    final /* synthetic */ zzpy f5465c;

    C1812oz(zzpy zzpy, AtomicReference atomicReference, zzqu zzqu) {
        this.f5465c = zzpy;
        this.f5463a = atomicReference;
        this.f5464b = zzqu;
    }

    public void onConnected(Bundle bundle) {
        this.f5465c.m7467a((GoogleApiClient) this.f5463a.get(), this.f5464b, true);
    }

    public void onConnectionSuspended(int i) {
    }
}
