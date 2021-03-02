package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collection;

public final class zzanz implements zzani {

    /* renamed from: a */
    private final zzanp f5816a;

    public zzanz(zzanp zzanp) {
        this.f5816a = zzanp;
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Type n = zzaol.mo7940n();
        Class m = zzaol.mo7939m();
        if (!Collection.class.isAssignableFrom(m)) {
            return null;
        }
        Type zza = zzano.zza(n, m);
        return new C1451bp(zzamp, zza, zzamp.zza(zzaol.zzl(zza)), this.f5816a.zzb(zzaol));
    }
}
