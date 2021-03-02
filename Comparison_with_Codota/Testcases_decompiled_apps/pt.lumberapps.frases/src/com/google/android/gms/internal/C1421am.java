package com.google.android.gms.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* renamed from: com.google.android.gms.internal.am */
final class C1421am implements Serializable, WildcardType {

    /* renamed from: a */
    private final Type f4837a;

    /* renamed from: b */
    private final Type f4838b;

    public C1421am(Type[] typeArr, Type[] typeArr2) {
        boolean z = true;
        zzann.zzbo(typeArr2.length <= 1);
        zzann.zzbo(typeArr.length == 1);
        if (typeArr2.length == 1) {
            zzann.zzy(typeArr2[0]);
            zzano.m6669b(typeArr2[0]);
            zzann.zzbo(typeArr[0] != Object.class ? false : z);
            this.f4838b = zzano.zze(typeArr2[0]);
            this.f4837a = Object.class;
            return;
        }
        zzann.zzy(typeArr[0]);
        zzano.m6669b(typeArr[0]);
        this.f4838b = null;
        this.f4837a = zzano.zze(typeArr[0]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && zzano.zza((Type) this, (Type) (WildcardType) obj);
    }

    public Type[] getLowerBounds() {
        if (this.f4838b == null) {
            return zzano.f5795a;
        }
        return new Type[]{this.f4838b};
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.f4837a};
    }

    public int hashCode() {
        return (this.f4838b != null ? this.f4838b.hashCode() + 31 : 1) ^ (this.f4837a.hashCode() + 31);
    }

    public String toString() {
        if (this.f4838b != null) {
            String valueOf = String.valueOf(zzano.zzg(this.f4838b));
            return valueOf.length() != 0 ? "? super ".concat(valueOf) : new String("? super ");
        } else if (this.f4837a == Object.class) {
            return "?";
        } else {
            String valueOf2 = String.valueOf(zzano.zzg(this.f4837a));
            return valueOf2.length() != 0 ? "? extends ".concat(valueOf2) : new String("? extends ");
        }
    }
}
