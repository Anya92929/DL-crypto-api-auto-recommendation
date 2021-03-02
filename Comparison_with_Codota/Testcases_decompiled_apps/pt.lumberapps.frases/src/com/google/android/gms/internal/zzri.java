package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzrk;

public class zzri extends zzk {
    public zzri(Context context, Looper looper, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzrk zzbb(IBinder iBinder) {
        return zzrk.zza.zzea(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    public String zzqz() {
        return "com.google.android.gms.common.service.START";
    }
}
