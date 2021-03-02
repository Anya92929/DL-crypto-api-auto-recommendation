package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzpm;
import java.util.Collections;

public class zzpx implements zzpz {

    /* renamed from: a */
    private final zzqa f6836a;

    public zzpx(zzqa zzqa) {
        this.f6836a = zzqa;
    }

    public void begin() {
        this.f6836a.mo8961c();
        this.f6836a.f6867g.f6840d = Collections.emptySet();
    }

    public void connect() {
        this.f6836a.mo8956a();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void zza(ConnectionResult connectionResult, Api api, int i) {
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        this.f6836a.f6867g.f6837a.add(zza);
        return zza;
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
