package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;

public final class zzmf {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", zzUJ, zzUI);
    public static final Api.zzc<zzmj> zzUI = new Api.zzc<>();
    private static final Api.zza<zzmj, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzmj, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzf */
        public zzmj zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmj(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzmg zzamA = new zzmh();
}
