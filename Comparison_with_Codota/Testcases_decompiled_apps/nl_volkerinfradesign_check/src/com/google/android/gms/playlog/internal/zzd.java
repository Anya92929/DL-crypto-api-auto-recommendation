package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqu;

public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    private final zzqu.zza f3577a;

    /* renamed from: b */
    private zzf f3578b = null;

    /* renamed from: c */
    private boolean f3579c = true;

    public zzd(zzqu.zza zza) {
        this.f3577a = zza;
    }

    public void onConnected(Bundle bundle) {
        this.f3578b.mo7268a(false);
        if (this.f3579c && this.f3577a != null) {
            this.f3577a.zzES();
        }
        this.f3579c = false;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f3578b.mo7268a(true);
        if (this.f3579c && this.f3577a != null) {
            if (connectionResult.hasResolution()) {
                this.f3577a.zzc(connectionResult.getResolution());
            } else {
                this.f3577a.zzET();
            }
        }
        this.f3579c = false;
    }

    public void onConnectionSuspended(int i) {
        this.f3578b.mo7268a(true);
    }

    public void zza(zzf zzf) {
        this.f3578b = zzf;
    }

    public void zzat(boolean z) {
        this.f3579c = z;
    }
}
