package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzpc;

/* renamed from: com.google.android.gms.clearcut.a */
final class C1337a extends Api.zza {
    C1337a() {
    }

    /* renamed from: a */
    public zzpc zza(Context context, Looper looper, zzg zzg, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzpc(context, looper, zzg, connectionCallbacks, onConnectionFailedListener);
    }
}
