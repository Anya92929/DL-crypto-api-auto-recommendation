package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;

public class zzpp implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    private final int f6806a;

    /* renamed from: b */
    private zzqa f6807b;

    /* renamed from: pN */
    public final Api f6808pN;

    public zzpp(Api api, int i) {
        this.f6808pN = api;
        this.f6806a = i;
    }

    /* renamed from: a */
    private void m7427a() {
        zzab.zzb((Object) this.f6807b, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(Bundle bundle) {
        m7427a();
        this.f6807b.onConnected(bundle);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        m7427a();
        this.f6807b.zza(connectionResult, this.f6808pN, this.f6806a);
    }

    public void onConnectionSuspended(int i) {
        m7427a();
        this.f6807b.onConnectionSuspended(i);
    }

    public void zza(zzqa zzqa) {
        this.f6807b = zzqa;
    }
}
