package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;

public class zzm {
    public final Object result;
    public final zzb.zza zzbf;
    public final zzr zzbg;
    public boolean zzbh;

    public interface zza {
        void zze(zzr zzr);
    }

    public interface zzb {
        void zzb(Object obj);
    }

    private zzm(zzr zzr) {
        this.zzbh = false;
        this.result = null;
        this.zzbf = null;
        this.zzbg = zzr;
    }

    private zzm(Object obj, zzb.zza zza2) {
        this.zzbh = false;
        this.result = obj;
        this.zzbf = zza2;
        this.zzbg = null;
    }

    public static zzm zza(Object obj, zzb.zza zza2) {
        return new zzm(obj, zza2);
    }

    public static zzm zzd(zzr zzr) {
        return new zzm(zzr);
    }

    public boolean isSuccess() {
        return this.zzbg == null;
    }
}
