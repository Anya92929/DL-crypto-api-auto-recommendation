package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cb */
final class C1464cb extends zzanh {
    C1464cb() {
    }

    /* renamed from: a */
    public Class zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Class cls) {
        if (cls == null) {
            zzaoo.mo7926l();
        } else {
            String valueOf = String.valueOf(cls.getName());
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
        }
    }
}
