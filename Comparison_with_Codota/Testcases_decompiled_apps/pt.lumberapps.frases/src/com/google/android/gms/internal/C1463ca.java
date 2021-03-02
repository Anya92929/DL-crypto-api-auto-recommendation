package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaog;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.android.gms.internal.ca */
final class C1463ca extends zzanh {

    /* renamed from: a */
    private final zzamp f4912a;

    /* renamed from: b */
    private final zzanh f4913b;

    /* renamed from: c */
    private final Type f4914c;

    C1463ca(zzamp zzamp, zzanh zzanh, Type type) {
        this.f4912a = zzamp;
        this.f4913b = zzanh;
        this.f4914c = type;
    }

    /* renamed from: a */
    private Type m6304a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void zza(zzaoo zzaoo, Object obj) {
        zzanh zzanh = this.f4913b;
        Type a = m6304a(this.f4914c, obj);
        if (a != this.f4914c) {
            zzanh = this.f4912a.zza(zzaol.zzl(a));
            if ((zzanh instanceof zzaog.zza) && !(this.f4913b instanceof zzaog.zza)) {
                zzanh = this.f4913b;
            }
        }
        zzanh.zza(zzaoo, obj);
    }

    public Object zzb(zzaom zzaom) {
        return this.f4913b.zzb(zzaom);
    }
}
