package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzqh;

/* renamed from: com.google.android.gms.internal.ol */
class C1798ol implements zzqh.zza {

    /* renamed from: a */
    final /* synthetic */ C1795oi f5441a;

    private C1798ol(C1795oi oiVar) {
        this.f5441a = oiVar;
    }

    /* synthetic */ C1798ol(C1795oi oiVar, C1796oj ojVar) {
        this(oiVar);
    }

    public void zzc(int i, boolean z) {
        this.f5441a.f5437m.lock();
        try {
            if (this.f5441a.f5436l) {
                boolean unused = this.f5441a.f5436l = false;
                this.f5441a.m6511a(i, z);
                return;
            }
            boolean unused2 = this.f5441a.f5436l = true;
            this.f5441a.f5428d.onConnectionSuspended(i);
            this.f5441a.f5437m.unlock();
        } finally {
            this.f5441a.f5437m.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        this.f5441a.f5437m.lock();
        try {
            ConnectionResult unused = this.f5441a.f5435k = connectionResult;
            this.f5441a.m6522c();
        } finally {
            this.f5441a.f5437m.unlock();
        }
    }

    public void zzm(Bundle bundle) {
        this.f5441a.f5437m.lock();
        try {
            ConnectionResult unused = this.f5441a.f5435k = ConnectionResult.f4269rb;
            this.f5441a.m6522c();
        } finally {
            this.f5441a.f5437m.unlock();
        }
    }
}
