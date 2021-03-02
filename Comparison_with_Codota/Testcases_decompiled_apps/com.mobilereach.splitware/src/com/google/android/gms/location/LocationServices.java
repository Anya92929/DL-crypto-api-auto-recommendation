package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zzf;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

public class LocationServices {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("LocationServices.API", zzUJ, zzUI);
    public static final FusedLocationProviderApi FusedLocationApi = new zzd();
    public static final GeofencingApi GeofencingApi = new zzf();
    public static final SettingsApi SettingsApi = new zzq();
    /* access modifiers changed from: private */
    public static final Api.zzc<zzl> zzUI = new Api.zzc<>();
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzl, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzn */
        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzf);
        }
    };

    public static abstract class zza<R extends Result> extends zza.C0426zza<R, zzl> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzUI, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzl zzi(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzl zzl = (zzl) googleApiClient.zza(zzUI);
        if (zzl == null) {
            z = false;
        }
        zzx.zza(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzl;
    }
}
