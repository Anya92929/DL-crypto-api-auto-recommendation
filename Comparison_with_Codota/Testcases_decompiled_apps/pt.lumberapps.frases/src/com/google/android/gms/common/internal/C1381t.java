package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzd;

/* renamed from: com.google.android.gms.common.internal.t */
final class C1381t implements zzd.zzb {

    /* renamed from: a */
    final /* synthetic */ GoogleApiClient.ConnectionCallbacks f4505a;

    C1381t(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f4505a = connectionCallbacks;
    }

    public void onConnected(Bundle bundle) {
        this.f4505a.onConnected(bundle);
    }

    public void onConnectionSuspended(int i) {
        this.f4505a.onConnectionSuspended(i);
    }
}
