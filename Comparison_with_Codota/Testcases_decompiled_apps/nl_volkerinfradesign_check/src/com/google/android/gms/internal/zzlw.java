package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzly;

public class zzlw extends zzj<zzly> {
    public zzlw(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zzly) zzqJ()).zza(zzlx, logEventParcelable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaK */
    public zzly zzW(IBinder iBinder) {
        return zzly.zza.zzaM(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.clearcut.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
