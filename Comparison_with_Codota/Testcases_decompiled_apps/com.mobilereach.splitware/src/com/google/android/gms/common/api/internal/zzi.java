package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import java.util.Collections;

public class zzi implements zzk {
    private final zzl zzahj;

    public zzi(zzl zzl) {
        this.zzahj = zzl;
    }

    public void begin() {
        this.zzahj.zzpM();
        this.zzahj.zzagW.zzahU = Collections.emptySet();
    }

    public void connect() {
        this.zzahj.zzpK();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0426zza<R, A>> T zza(T t) {
        this.zzahj.zzagW.zzahN.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, T extends zza.C0426zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
