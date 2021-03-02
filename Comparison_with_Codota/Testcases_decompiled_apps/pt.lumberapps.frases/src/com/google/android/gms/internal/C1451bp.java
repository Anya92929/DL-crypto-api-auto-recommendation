package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.android.gms.internal.bp */
final class C1451bp extends zzanh {

    /* renamed from: a */
    private final zzanh f4891a;

    /* renamed from: b */
    private final zzanu f4892b;

    public C1451bp(zzamp zzamp, Type type, zzanh zzanh, zzanu zzanu) {
        this.f4891a = new C1463ca(zzamp, zzanh, type);
        this.f4892b = zzanu;
    }

    /* renamed from: a */
    public Collection zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        Collection collection = (Collection) this.f4892b.zzczu();
        zzaom.beginArray();
        while (zzaom.hasNext()) {
            collection.add(this.f4891a.zzb(zzaom));
        }
        zzaom.endArray();
        return collection;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Collection collection) {
        if (collection == null) {
            zzaoo.mo7926l();
            return;
        }
        zzaoo.mo7922h();
        for (Object zza : collection) {
            this.f4891a.zza(zzaoo, zza);
        }
        zzaoo.mo7923i();
    }
}
