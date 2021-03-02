package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import java.util.Collections;

public class zzi implements zzk {

    /* renamed from: a */
    private final zzl f2732a;

    public zzi(zzl zzl) {
        this.f2732a = zzl;
    }

    public void begin() {
        this.f2732a.mo5214c();
        this.f2732a.f2783g.f2736d = Collections.emptySet();
    }

    public void connect() {
        this.f2732a.mo5209a();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(T t) {
        this.f2732a.f2783g.f2733a.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
