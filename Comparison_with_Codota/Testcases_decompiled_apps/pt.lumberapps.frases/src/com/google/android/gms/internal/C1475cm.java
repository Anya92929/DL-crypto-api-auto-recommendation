package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cm */
final class C1475cm implements zzani {
    C1475cm() {
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Class<? super Enum> m = zzaol.mo7939m();
        if (!Enum.class.isAssignableFrom(m) || m == Enum.class) {
            return null;
        }
        if (!m.isEnum()) {
            m = m.getSuperclass();
        }
        return new C1498di(m);
    }
}
