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

    /* renamed from: a */
    static final Api.zza<zzh, zza> f3245a = new Api.zza<zzh, zza>() {
        /* renamed from: a */
        public zzh zza(Context context, Looper looper, zzf zzf, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, false, zzf, zza.zzFF(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api.zzc<zzh> zzUI = new Api.zzc<>();
    public static final Api.zza<zzh, zzro> zzUJ = new Api.zza<zzh, zzro>() {
        /* renamed from: a */
        public zzh zza(Context context, Looper looper, zzf zzf, zzro zzro, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, true, zzf, zzro == null ? zzro.zzbgV : zzro, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Api<zza> zzaoG = new Api<>("SignIn.INTERNAL_API", f3245a, zzavN);
    public static final Api.zzc<zzh> zzavN = new Api.zzc<>();
    public static final zzrm zzbgT = new zzg();

    public static class zza implements Api.ApiOptions.HasOptions {

        /* renamed from: a */
        private final Bundle f3246a;

        public Bundle zzFF() {
            return this.f3246a;
        }
    }
}
