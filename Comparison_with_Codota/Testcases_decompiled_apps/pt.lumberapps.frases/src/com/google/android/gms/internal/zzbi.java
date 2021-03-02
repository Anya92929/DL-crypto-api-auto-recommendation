package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.util.concurrent.Callable;

public class zzbi implements Callable {

    /* renamed from: a */
    private final zzax f5963a;

    /* renamed from: b */
    private final zzae.zza f5964b;

    public zzbi(zzax zzax, zzae.zza zza) {
        this.f5963a = zzax;
        this.f5964b = zza;
    }

    /* renamed from: zzcx */
    public Void call() {
        if (this.f5963a.zzcm() != null) {
            this.f5963a.zzcm().get();
        }
        zzae.zza zzcl = this.f5963a.zzcl();
        if (zzcl == null) {
            return null;
        }
        try {
            synchronized (this.f5964b) {
                zzapv.zza(this.f5964b, zzapv.zzf(zzcl));
            }
            return null;
        } catch (zzapu e) {
            return null;
        }
    }
}
