package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zzpm;

public class zzqd extends zzpu {

    /* renamed from: a */
    private final zzc f6894a;

    public zzqd(zzc zzc) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f6894a = zzc;
    }

    public Looper getLooper() {
        return this.f6894a.getLooper();
    }

    public void zza(zzqx zzqx) {
        this.f6894a.zzanx();
    }

    public void zzb(zzqx zzqx) {
        this.f6894a.zzany();
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        return this.f6894a.zza(zza);
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        return this.f6894a.zzb(zza);
    }
}
