package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzvt;
import com.google.android.gms.signin.internal.zzg;

/* renamed from: com.google.android.gms.internal.re */
final class C1872re extends Api.zza {
    C1872re() {
    }

    /* renamed from: a */
    public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zzvt.zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzg(context, looper, false, zzg, zza.zzbzn(), connectionCallbacks, onConnectionFailedListener);
    }
}
