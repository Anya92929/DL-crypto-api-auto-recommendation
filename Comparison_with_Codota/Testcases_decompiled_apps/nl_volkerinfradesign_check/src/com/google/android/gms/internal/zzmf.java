package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

public final class zzmf {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", f3214a, zzUI);

    /* renamed from: a */
    private static final Api.zza<zzmj, Api.ApiOptions.NoOptions> f3214a = new Api.zza<zzmj, Api.ApiOptions.NoOptions>() {
        /* renamed from: a */
        public zzmj zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmj(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api.zzc<zzmj> zzUI = new Api.zzc<>();
    public static final zzmg zzamA = new zzmh();
}
