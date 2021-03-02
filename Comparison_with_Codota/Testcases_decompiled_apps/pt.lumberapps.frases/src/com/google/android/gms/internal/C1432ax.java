package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* renamed from: com.google.android.gms.internal.ax */
class C1432ax implements zzanu {

    /* renamed from: a */
    final /* synthetic */ Type f4857a;

    /* renamed from: b */
    final /* synthetic */ zzanp f4858b;

    C1432ax(zzanp zzanp, Type type) {
        this.f4858b = zzanp;
        this.f4857a = type;
    }

    public Object zzczu() {
        if (this.f4857a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f4857a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            String valueOf = String.valueOf(this.f4857a.toString());
            throw new zzamw(valueOf.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf) : new String("Invalid EnumSet type: "));
        }
        String valueOf2 = String.valueOf(this.f4857a.toString());
        throw new zzamw(valueOf2.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf2) : new String("Invalid EnumSet type: "));
    }
}
