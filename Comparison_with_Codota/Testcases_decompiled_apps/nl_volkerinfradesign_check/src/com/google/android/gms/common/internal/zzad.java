package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzad<T extends IInterface> extends zzj<T> {

    /* renamed from: b */
    private final Api.zzd<T> f2939b;

    public zzad(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzf, Api.zzd zzd) {
        super(context, looper, i, zzf, connectionCallbacks, onConnectionFailedListener);
        this.f2939b = zzd;
    }

    /* access modifiers changed from: protected */
    public T zzW(IBinder iBinder) {
        return this.f2939b.zzW(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.f2939b.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return this.f2939b.zzgu();
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return this.f2939b.zzgv();
    }
}
