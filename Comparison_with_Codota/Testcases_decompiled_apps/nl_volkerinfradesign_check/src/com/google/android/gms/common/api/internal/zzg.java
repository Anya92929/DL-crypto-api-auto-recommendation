package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzl;

public class zzg implements zzk {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzl f2691a;

    /* renamed from: b */
    private boolean f2692b = false;

    public zzg(zzl zzl) {
        this.f2691a = zzl;
    }

    /* renamed from: a */
    private <A extends Api.zzb> void m3741a(zzj.C0711e<A> eVar) throws DeadObjectException {
        this.f2691a.f2783g.mo5189a(eVar);
        A zza = this.f2691a.f2783g.zza(eVar.zzoR());
        if (zza.isConnected() || !this.f2691a.f2778b.containsKey(eVar.zzoR())) {
            eVar.zzb(zza);
        } else {
            eVar.zzw(new Status(17));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5175a() {
        if (this.f2692b) {
            this.f2692b = false;
            this.f2691a.f2783g.mo5190a(false);
            disconnect();
        }
    }

    public void begin() {
    }

    public void connect() {
        if (this.f2692b) {
            this.f2692b = false;
            this.f2691a.mo5211a((zzl.C0712a) new zzl.C0712a(this) {
                /* renamed from: a */
                public void mo5184a() {
                    zzg.this.f2691a.f2784h.zzi((Bundle) null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.f2692b) {
            return false;
        }
        if (this.f2691a.f2783g.mo5194e()) {
            this.f2692b = true;
            for (zzx a : this.f2691a.f2783g.f2741i) {
                a.mo5238a();
            }
            return false;
        }
        this.f2691a.mo5210a((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.f2691a.mo5210a((ConnectionResult) null);
        this.f2691a.f2784h.zzc(i, this.f2692b);
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(T t) {
        try {
            m3741a(t);
        } catch (DeadObjectException e) {
            this.f2691a.mo5211a((zzl.C0712a) new zzl.C0712a(this) {
                /* renamed from: a */
                public void mo5184a() {
                    zzg.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
