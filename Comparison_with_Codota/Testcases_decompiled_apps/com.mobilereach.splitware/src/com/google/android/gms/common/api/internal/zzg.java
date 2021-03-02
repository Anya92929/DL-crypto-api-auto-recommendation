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
    public final zzl zzahj;
    private boolean zzahk = false;

    public zzg(zzl zzl) {
        this.zzahj = zzl;
    }

    private <A extends Api.zzb> void zza(zzj.zze<A> zze) throws DeadObjectException {
        this.zzahj.zzagW.zzb(zze);
        A zza = this.zzahj.zzagW.zza(zze.zzoR());
        if (zza.isConnected() || !this.zzahj.zzaio.containsKey(zze.zzoR())) {
            zze.zzb(zza);
        } else {
            zze.zzw(new Status(17));
        }
    }

    public void begin() {
    }

    public void connect() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zza((zzl.zza) new zzl.zza(this) {
                public void zzpt() {
                    zzg.this.zzahj.zzais.zzi((Bundle) null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.zzahk) {
            return false;
        }
        if (this.zzahj.zzagW.zzpG()) {
            this.zzahk = true;
            for (zzx zzpU : this.zzahj.zzagW.zzaia) {
                zzpU.zzpU();
            }
            return false;
        }
        this.zzahj.zzh((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
        this.zzahj.zzh((ConnectionResult) null);
        this.zzahj.zzais.zzc(cause, this.zzahk);
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0426zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends Api.zzb, T extends zza.C0426zza<? extends Result, A>> T zzb(T t) {
        try {
            zza(t);
        } catch (DeadObjectException e) {
            this.zzahj.zza((zzl.zza) new zzl.zza(this) {
                public void zzpt() {
                    zzg.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public void zzps() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zzagW.zzaa(false);
            disconnect();
        }
    }
}
