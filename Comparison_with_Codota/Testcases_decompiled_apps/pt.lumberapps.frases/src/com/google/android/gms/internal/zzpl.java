package com.google.android.gms.internal;

import android.support.p009v4.p019f.C0136a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import java.util.Set;

public final class zzpl extends zzpo {

    /* renamed from: d */
    private int f6780d;

    /* renamed from: e */
    private boolean f6781e;

    /* renamed from: a */
    private void m7410a(ConnectionResult connectionResult) {
        C0136a aVar = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVar.size()) {
                zza((zzpj) aVar.mo1152b(i2), connectionResult);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzb zzc(Status status) {
        zzb zza;
        synchronized (0) {
            try {
                m7410a(new ConnectionResult(8));
                C0136a aVar = null;
                zza = aVar.size() == 1 ? new zza(status, (C0136a) null) : new zzb(status, (C0136a) null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    /* JADX INFO: finally extract failed */
    public void zza(zzpj zzpj, ConnectionResult connectionResult) {
        synchronized (0) {
            C0136a aVar = null;
            try {
                aVar.put(zzpj, connectionResult);
                this.f6780d--;
                if (!connectionResult.isSuccess()) {
                    this.f6781e = true;
                }
                if (this.f6780d == 0) {
                    Status status = this.f6781e ? new Status(13) : Status.f4328sq;
                    C0136a aVar2 = null;
                    zzc(aVar2.size() == 1 ? new zza(status, (C0136a) null) : new zzb(status, (C0136a) null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set zzaoq() {
        C0136a aVar = null;
        return aVar.keySet();
    }
}
