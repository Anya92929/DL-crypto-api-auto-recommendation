package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.internal.zzi;

public class zzb extends zzj<zzi> {
    private final String zzaOs;
    protected final zzp<zzi> zzaOt = new zzp<zzi>() {
        public void zzqI() {
            zzb.this.zzqI();
        }

        /* renamed from: zzyM */
        public zzi zzqJ() throws DeadObjectException {
            return (zzi) zzb.this.zzqJ();
        }
    };

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zzf zzf) {
        super(context, looper, 23, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaOs = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcg */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzcj(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzaOs);
        return bundle;
    }
}
