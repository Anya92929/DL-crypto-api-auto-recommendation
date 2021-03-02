package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.pa */
class C1814pa implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    final /* synthetic */ zzqu f5467a;

    /* renamed from: b */
    final /* synthetic */ zzpy f5468b;

    C1814pa(zzpy zzpy, zzqu zzqu) {
        this.f5468b = zzpy;
        this.f5467a = zzqu;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f5467a.zzc((Result) new Status(8));
    }
}
