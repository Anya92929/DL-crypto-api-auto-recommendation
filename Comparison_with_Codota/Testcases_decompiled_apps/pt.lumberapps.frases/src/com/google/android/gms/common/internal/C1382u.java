package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzd;

/* renamed from: com.google.android.gms.common.internal.u */
final class C1382u implements zzd.zzc {

    /* renamed from: a */
    final /* synthetic */ GoogleApiClient.OnConnectionFailedListener f4506a;

    C1382u(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f4506a = onConnectionFailedListener;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f4506a.onConnectionFailed(connectionResult);
    }
}
