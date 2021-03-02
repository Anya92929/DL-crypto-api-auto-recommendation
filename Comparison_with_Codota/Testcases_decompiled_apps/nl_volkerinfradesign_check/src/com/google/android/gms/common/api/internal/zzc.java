package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

public class zzc implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    private final int f2671a;

    /* renamed from: b */
    private zzl f2672b;
    public final Api<?> zzagT;

    public zzc(Api<?> api, int i) {
        this.zzagT = api;
        this.f2671a = i;
    }

    /* renamed from: a */
    private void m3717a() {
        zzx.zzb(this.f2672b, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(@Nullable Bundle bundle) {
        m3717a();
        this.f2672b.onConnected(bundle);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        m3717a();
        this.f2672b.zza(connectionResult, this.zzagT, this.f2671a);
    }

    public void onConnectionSuspended(int i) {
        m3717a();
        this.f2672b.onConnectionSuspended(i);
    }

    public void zza(zzl zzl) {
        this.f2672b = zzl;
    }
}
