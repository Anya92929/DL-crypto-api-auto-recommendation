package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzah extends zzk {

    /* renamed from: a */
    private final Api.zzg f4518a;

    public zzah(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzg zzg, Api.zzg zzg2) {
        super(context, looper, i, zzg, connectionCallbacks, onConnectionFailedListener);
        this.f4518a = zzg2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return this.f4518a.zzra();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6653a(int i, IInterface iInterface) {
        this.f4518a.zza(i, iInterface);
    }

    public Api.zzg zzatn() {
        return this.f4518a;
    }

    /* access modifiers changed from: protected */
    public IInterface zzbb(IBinder iBinder) {
        return this.f4518a.zzbb(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return this.f4518a.zzqz();
    }
}
