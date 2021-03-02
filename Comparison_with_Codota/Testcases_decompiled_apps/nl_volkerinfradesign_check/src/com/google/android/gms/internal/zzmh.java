package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import p000.C1200hf;

public final class zzmh implements zzmg {

    /* renamed from: com.google.android.gms.internal.zzmh$a */
    static class C0788a extends zzme {

        /* renamed from: a */
        private final zza.zzb<Status> f3216a;

        public C0788a(zza.zzb<Status> zzb) {
            this.f3216a = zzb;
        }

        public void zzcb(int i) throws RemoteException {
            this.f3216a.zzs(new Status(i));
        }
    }

    public PendingResult<Status> zzf(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C1200hf.C1201a(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void zza(zzmj zzmj) throws RemoteException {
                ((zzml) zzmj.zzqJ()).zza(new C0788a(this));
            }
        });
    }
}
