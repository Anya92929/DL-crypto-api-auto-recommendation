package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzad<T extends IInterface> extends zzj<T> {
    private final Api.zzd<T> zzamx;

    public zzad(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzf, Api.zzd zzd) {
        super(context, looper, i, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzamx = zzd;
    }

    /* access modifiers changed from: protected */
    public T zzW(IBinder iBinder) {
        return this.zzamx.zzW(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.zzamx.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return this.zzamx.zzgu();
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return this.zzamx.zzgv();
    }
}
