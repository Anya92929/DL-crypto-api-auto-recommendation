package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;

public final class zzrl {
    public static final Api<zzro> API = new Api<>("SignIn.API", zzUJ, zzUI);
    public static final Api.zzc<zzh> zzUI = new Api.zzc<>();
    public static final Api.zza<zzh, zzro> zzUJ = new Api.zza<zzh, zzro>() {
        public zzh zza(Context context, Looper looper, zzf zzf, zzro zzro, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, true, zzf, zzro == null ? zzro.zzbgV : zzro, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Api<zza> zzaoG = new Api<>("SignIn.INTERNAL_API", zzbgS, zzavN);
    public static final Api.zzc<zzh> zzavN = new Api.zzc<>();
    static final Api.zza<zzh, zza> zzbgS = new Api.zza<zzh, zza>() {
        public zzh zza(Context context, Looper looper, zzf zzf, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, false, zzf, zza.zzFF(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzrm zzbgT = new zzg();

    public static class zza implements Api.ApiOptions.HasOptions {
        private final Bundle zzbgU;

        public Bundle zzFF() {
            return this.zzbgU;
        }
    }
}
