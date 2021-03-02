package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.di */
final class C1498di extends zzanh {

    /* renamed from: a */
    private final Map f4930a = new HashMap();

    /* renamed from: b */
    private final Map f4931b = new HashMap();

    public C1498di(Class cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                String name = enumR.name();
                zzank zzank = (zzank) cls.getField(name).getAnnotation(zzank.class);
                if (zzank != null) {
                    name = zzank.value();
                    for (String put : zzank.zzczs()) {
                        this.f4930a.put(put, enumR);
                    }
                }
                String str = name;
                this.f4930a.put(str, enumR);
                this.f4931b.put(enumR, str);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public Enum zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return (Enum) this.f4930a.get(zzaom.nextString());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Enum enumR) {
        zzaoo.zzts(enumR == null ? null : (String) this.f4931b.get(enumR));
    }
}
