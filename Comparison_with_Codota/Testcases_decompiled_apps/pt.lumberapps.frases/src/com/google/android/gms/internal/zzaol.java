package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class zzaol {

    /* renamed from: a */
    final Class f5848a;

    /* renamed from: b */
    final Type f5849b;

    /* renamed from: c */
    final int f5850c;

    protected zzaol() {
        this.f5849b = m6721a(getClass());
        this.f5848a = zzano.zzf(this.f5849b);
        this.f5850c = this.f5849b.hashCode();
    }

    zzaol(Type type) {
        this.f5849b = zzano.zze((Type) zzann.zzy(type));
        this.f5848a = zzano.zzf(this.f5849b);
        this.f5850c = this.f5849b.hashCode();
    }

    /* renamed from: a */
    static Type m6721a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return zzano.zze(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static zzaol zzl(Type type) {
        return new zzaol(type);
    }

    public static zzaol zzr(Class cls) {
        return new zzaol(cls);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzaol) && zzano.zza(this.f5849b, ((zzaol) obj).f5849b);
    }

    public final int hashCode() {
        return this.f5850c;
    }

    /* renamed from: m */
    public final Class mo7939m() {
        return this.f5848a;
    }

    /* renamed from: n */
    public final Type mo7940n() {
        return this.f5849b;
    }

    public final String toString() {
        return zzano.zzg(this.f5849b);
    }
}
