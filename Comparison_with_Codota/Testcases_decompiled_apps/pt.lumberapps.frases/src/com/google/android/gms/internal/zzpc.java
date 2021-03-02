package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzpf;

public class zzpc extends zzk {
    public zzpc(Context context, Looper looper, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzpf zzbb(IBinder iBinder) {
        return zzpf.zza.zzdm(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    public void zza(zzpe zzpe, LogEventParcelable logEventParcelable) {
        ((zzpf) zzasa()).zza(zzpe, logEventParcelable);
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return "com.google.android.gms.clearcut.service.START";
    }
}
