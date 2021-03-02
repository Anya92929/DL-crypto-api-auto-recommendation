package com.google.android.gms.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.al */
final class C1420al implements Serializable, ParameterizedType {

    /* renamed from: a */
    private final Type f4834a;

    /* renamed from: b */
    private final Type f4835b;

    /* renamed from: c */
    private final Type[] f4836c;

    public C1420al(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            zzann.zzbo(type != null || (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null));
        }
        this.f4834a = type == null ? null : zzano.zze(type);
        this.f4835b = zzano.zze(type2);
        this.f4836c = (Type[]) typeArr.clone();
        for (int i = 0; i < this.f4836c.length; i++) {
            zzann.zzy(this.f4836c[i]);
            zzano.m6669b(this.f4836c[i]);
            this.f4836c[i] = zzano.zze(this.f4836c[i]);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && zzano.zza((Type) this, (Type) (ParameterizedType) obj);
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.f4836c.clone();
    }

    public Type getOwnerType() {
        return this.f4834a;
    }

    public Type getRawType() {
        return this.f4835b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f4836c) ^ this.f4835b.hashCode()) ^ zzano.m6667b((Object) this.f4834a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f4836c.length + 1) * 30);
        sb.append(zzano.zzg(this.f4835b));
        if (this.f4836c.length == 0) {
            return sb.toString();
        }
        sb.append("<").append(zzano.zzg(this.f4836c[0]));
        for (int i = 1; i < this.f4836c.length; i++) {
            sb.append(", ").append(zzano.zzg(this.f4836c[i]));
        }
        return sb.append(">").toString();
    }
}
