package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.signin.internal.zzg;

/* renamed from: com.google.android.gms.internal.rd */
final class C1871rd extends Api.zza {
    C1871rd() {
    }

    /* renamed from: a */
    public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg zzg, zzvv zzvv, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzg(context, looper, true, zzg, zzvv == null ? zzvv.atR : zzvv, connectionCallbacks, onConnectionFailedListener);
    }
}
