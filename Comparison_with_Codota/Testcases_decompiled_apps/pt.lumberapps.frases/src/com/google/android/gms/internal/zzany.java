package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;

public final class zzany extends zzanh {
    public static final zzani bfu = new C1450bo();

    /* renamed from: a */
    private final Class f5814a;

    /* renamed from: b */
    private final zzanh f5815b;

    public zzany(zzamp zzamp, zzanh zzanh, Class cls) {
        this.f5815b = new C1463ca(zzamp, zzanh, cls);
        this.f5814a = cls;
    }

    public void zza(zzaoo zzaoo, Object obj) {
        if (obj == null) {
            zzaoo.mo7926l();
            return;
        }
        zzaoo.mo7922h();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f5815b.zza(zzaoo, Array.get(obj, i));
        }
        zzaoo.mo7923i();
    }

    public Object zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzaom.beginArray();
        while (zzaom.hasNext()) {
            arrayList.add(this.f5815b.zzb(zzaom));
        }
        zzaom.endArray();
        Object newInstance = Array.newInstance(this.f5814a, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
