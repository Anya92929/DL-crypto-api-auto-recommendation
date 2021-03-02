package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Map;

public final class zzaoe implements zzani {

    /* renamed from: a */
    private final zzanp f5838a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final boolean f5839b;

    public zzaoe(zzanp zzanp, boolean z) {
        this.f5838a = zzanp;
        this.f5839b = z;
    }

    /* renamed from: a */
    private zzanh m6712a(zzamp zzamp, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzaok.bgc : zzamp.zza(zzaol.zzl(type));
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Type n = zzaol.mo7940n();
        if (!Map.class.isAssignableFrom(zzaol.mo7939m())) {
            return null;
        }
        Type[] zzb = zzano.zzb(n, zzano.zzf(n));
        zzanh a = m6712a(zzamp, zzb[0]);
        zzanh zza = zzamp.zza(zzaol.zzl(zzb[1]));
        zzanu zzb2 = this.f5838a.zzb(zzaol);
        return new C1455bt(this, zzamp, zzb[0], a, zzb[1], zza, zzb2);
    }
}
