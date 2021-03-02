package com.google.android.gms.internal;

import java.util.ArrayList;

public final class zzaof extends zzanh {
    public static final zzani bfu = new C1456bu();

    /* renamed from: a */
    private final zzamp f5840a;

    private zzaof(zzamp zzamp) {
        this.f5840a = zzamp;
    }

    /* synthetic */ zzaof(zzamp zzamp, C1456bu buVar) {
        this(zzamp);
    }

    public void zza(zzaoo zzaoo, Object obj) {
        if (obj == null) {
            zzaoo.mo7926l();
            return;
        }
        zzanh zzk = this.f5840a.zzk(obj.getClass());
        if (zzk instanceof zzaof) {
            zzaoo.mo7924j();
            zzaoo.mo7925k();
            return;
        }
        zzk.zza(zzaoo, obj);
    }

    public Object zzb(zzaom zzaom) {
        switch (C1457bv.f4897a[zzaom.mo7902b().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                zzaom.beginArray();
                while (zzaom.hasNext()) {
                    arrayList.add(zzb(zzaom));
                }
                zzaom.endArray();
                return arrayList;
            case 2:
                zzant zzant = new zzant();
                zzaom.beginObject();
                while (zzaom.hasNext()) {
                    zzant.put(zzaom.nextName(), zzb(zzaom));
                }
                zzaom.endObject();
                return zzant;
            case 3:
                return zzaom.nextString();
            case 4:
                return Double.valueOf(zzaom.nextDouble());
            case 5:
                return Boolean.valueOf(zzaom.nextBoolean());
            case 6:
                zzaom.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
