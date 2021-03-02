package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;

/* renamed from: com.google.android.gms.internal.qf */
final class C1846qf extends Api.zza {
    C1846qf() {
    }

    /* renamed from: a */
    public zzri zza(Context context, Looper looper, zzg zzg, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzri(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
    }
}
