package com.google.android.gms.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.ak */
final class C1419ak implements Serializable, GenericArrayType {

    /* renamed from: a */
    private final Type f4833a;

    public C1419ak(Type type) {
        this.f4833a = zzano.zze(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && zzano.zza((Type) this, (Type) (GenericArrayType) obj);
    }

    public Type getGenericComponentType() {
        return this.f4833a;
    }

    public int hashCode() {
        return this.f4833a.hashCode();
    }

    public String toString() {
        return String.valueOf(zzano.zzg(this.f4833a)).concat("[]");
    }
}
