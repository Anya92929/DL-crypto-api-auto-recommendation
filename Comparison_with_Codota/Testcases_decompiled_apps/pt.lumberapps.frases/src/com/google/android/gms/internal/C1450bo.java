package com.google.android.gms.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.bo */
final class C1450bo implements zzani {
    C1450bo() {
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Type n = zzaol.mo7940n();
        if (!(n instanceof GenericArrayType) && (!(n instanceof Class) || !((Class) n).isArray())) {
            return null;
        }
        Type zzh = zzano.zzh(n);
        return new zzany(zzamp, zzamp.zza(zzaol.zzl(zzh)), zzano.zzf(zzh));
    }
}
