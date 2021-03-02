package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzqh;

/* renamed from: com.google.android.gms.internal.ok */
class C1797ok implements zzqh.zza {

    /* renamed from: a */
    final /* synthetic */ C1795oi f5440a;

    private C1797ok(C1795oi oiVar) {
        this.f5440a = oiVar;
    }

    /* synthetic */ C1797ok(C1795oi oiVar, C1796oj ojVar) {
        this(oiVar);
    }

    public void zzc(int i, boolean z) {
        this.f5440a.f5437m.lock();
        try {
            if (this.f5440a.f5436l || this.f5440a.f5435k == null || !this.f5440a.f5435k.isSuccess()) {
                boolean unused = this.f5440a.f5436l = false;
                this.f5440a.m6511a(i, z);
                return;
            }
            boolean unused2 = this.f5440a.f5436l = true;
            this.f5440a.f5429e.onConnectionSuspended(i);
            this.f5440a.f5437m.unlock();
        } finally {
            this.f5440a.f5437m.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        this.f5440a.f5437m.lock();
        try {
            ConnectionResult unused = this.f5440a.f5434j = connectionResult;
            this.f5440a.m6522c();
        } finally {
            this.f5440a.f5437m.unlock();
        }
    }

    public void zzm(Bundle bundle) {
        this.f5440a.f5437m.lock();
        try {
            this.f5440a.m6512a(bundle);
            ConnectionResult unused = this.f5440a.f5434j = ConnectionResult.f4269rb;
            this.f5440a.m6522c();
        } finally {
            this.f5440a.f5437m.unlock();
        }
    }
}
