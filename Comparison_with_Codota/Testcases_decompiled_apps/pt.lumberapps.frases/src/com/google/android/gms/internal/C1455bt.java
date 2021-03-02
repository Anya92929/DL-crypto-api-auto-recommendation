package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.bt */
final class C1455bt extends zzanh {

    /* renamed from: a */
    final /* synthetic */ zzaoe f4893a;

    /* renamed from: b */
    private final zzanh f4894b;

    /* renamed from: c */
    private final zzanh f4895c;

    /* renamed from: d */
    private final zzanu f4896d;

    public C1455bt(zzaoe zzaoe, zzamp zzamp, Type type, zzanh zzanh, Type type2, zzanh zzanh2, zzanu zzanu) {
        this.f4893a = zzaoe;
        this.f4894b = new C1463ca(zzamp, zzanh, type);
        this.f4895c = new C1463ca(zzamp, zzanh2, type2);
        this.f4896d = zzanu;
    }

    /* renamed from: a */
    private String m6280a(zzamv zzamv) {
        if (zzamv.zzczi()) {
            zzanb zzczm = zzamv.zzczm();
            if (zzczm.zzczp()) {
                return String.valueOf(zzczm.zzcze());
            }
            if (zzczm.zzczo()) {
                return Boolean.toString(zzczm.getAsBoolean());
            }
            if (zzczm.zzczq()) {
                return zzczm.zzczf();
            }
            throw new AssertionError();
        } else if (zzamv.zzczj()) {
            return "null";
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public Map zzb(zzaom zzaom) {
        zzaon b = zzaom.mo7902b();
        if (b == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        Map map = (Map) this.f4896d.zzczu();
        if (b == zzaon.BEGIN_ARRAY) {
            zzaom.beginArray();
            while (zzaom.hasNext()) {
                zzaom.beginArray();
                Object zzb = this.f4894b.zzb(zzaom);
                if (map.put(zzb, this.f4895c.zzb(zzaom)) != null) {
                    String valueOf = String.valueOf(zzb);
                    throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                }
                zzaom.endArray();
            }
            zzaom.endArray();
            return map;
        }
        zzaom.beginObject();
        while (zzaom.hasNext()) {
            zzanr.beV.zzi(zzaom);
            Object zzb2 = this.f4894b.zzb(zzaom);
            if (map.put(zzb2, this.f4895c.zzb(zzaom)) != null) {
                String valueOf2 = String.valueOf(zzb2);
                throw new zzane(new StringBuilder(String.valueOf(valueOf2).length() + 15).append("duplicate key: ").append(valueOf2).toString());
            }
        }
        zzaom.endObject();
        return map;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Map map) {
        int i = 0;
        if (map == null) {
            zzaoo.mo7926l();
        } else if (!this.f4893a.f5839b) {
            zzaoo.mo7924j();
            for (Map.Entry entry : map.entrySet()) {
                zzaoo.zztr(String.valueOf(entry.getKey()));
                this.f4895c.zza(zzaoo, entry.getValue());
            }
            zzaoo.mo7925k();
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry entry2 : map.entrySet()) {
                zzamv zzcj = this.f4894b.zzcj(entry2.getKey());
                arrayList.add(zzcj);
                arrayList2.add(entry2.getValue());
                z = (zzcj.zzczg() || zzcj.zzczh()) | z;
            }
            if (z) {
                zzaoo.mo7922h();
                while (i < arrayList.size()) {
                    zzaoo.mo7922h();
                    zzanw.zzb((zzamv) arrayList.get(i), zzaoo);
                    this.f4895c.zza(zzaoo, arrayList2.get(i));
                    zzaoo.mo7923i();
                    i++;
                }
                zzaoo.mo7923i();
                return;
            }
            zzaoo.mo7924j();
            while (i < arrayList.size()) {
                zzaoo.zztr(m6280a((zzamv) arrayList.get(i)));
                this.f4895c.zza(zzaoo, arrayList2.get(i));
                i++;
            }
            zzaoo.mo7925k();
        }
    }
}
