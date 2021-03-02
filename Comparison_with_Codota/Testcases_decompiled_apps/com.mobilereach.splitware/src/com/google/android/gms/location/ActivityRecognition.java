package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.internal.zzl;

public class ActivityRecognition {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ActivityRecognition.API", zzUJ, zzUI);
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();
    public static final String CLIENT_NAME = "activity_recognition";
    /* access modifiers changed from: private */
    public static final Api.zzc<zzl> zzUI = new Api.zzc<>();
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzl, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzn */
        public zzl zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    };

    public static abstract class zza<R extends Result> extends zza.C0426zza<R, zzl> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.zzUI, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
