package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.zzpm;

public class zzpv implements zzpz {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzqa f6813a;

    /* renamed from: b */
    private boolean f6814b = false;

    public zzpv(zzqa zzqa) {
        this.f6813a = zzqa;
    }

    /* renamed from: a */
    private void m7432a(zzpm.zza zza) {
        this.f6813a.f6867g.f6845i.mo9008a(zza);
        Api.zze a = this.f6813a.f6867g.mo8949a(zza.zzans());
        if (a.isConnected() || !this.f6813a.f6862b.containsKey(zza.zzans())) {
            boolean z = a instanceof zzah;
            Api.zzb zzb = a;
            if (z) {
                zzb = ((zzah) a).zzatn();
            }
            zza.zzb(zzb);
            return;
        }
        zza.zzz(new Status(17));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8940a() {
        if (this.f6814b) {
            this.f6814b = false;
            this.f6813a.f6867g.f6845i.release();
            disconnect();
        }
    }

    public void begin() {
    }

    public void connect() {
        if (this.f6814b) {
            this.f6814b = false;
            this.f6813a.mo8958a((C1818pe) new C1800on(this, this));
        }
    }

    public boolean disconnect() {
        if (this.f6814b) {
            return false;
        }
        if (this.f6813a.f6867g.mo8953e()) {
            this.f6814b = true;
            for (zzqx a : this.f6813a.f6867g.f6844h) {
                a.mo9006a();
            }
            return false;
        }
        this.f6813a.mo8957a((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.f6813a.mo8957a((ConnectionResult) null);
        this.f6813a.f6868h.zzc(i, this.f6814b);
    }

    public void zza(ConnectionResult connectionResult, Api api, int i) {
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        return zzd(zza);
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        try {
            m7432a(zza);
        } catch (DeadObjectException e) {
            this.f6813a.mo8958a((C1818pe) new C1799om(this, this));
        }
        return zza;
    }
}
