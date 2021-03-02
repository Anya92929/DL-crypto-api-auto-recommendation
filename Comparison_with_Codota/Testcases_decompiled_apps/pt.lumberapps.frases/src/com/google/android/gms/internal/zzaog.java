package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaog implements zzani {

    /* renamed from: a */
    private final zzanp f5841a;

    /* renamed from: b */
    private final zzamo f5842b;

    /* renamed from: c */
    private final zzanq f5843c;

    public final class zza extends zzanh {

        /* renamed from: a */
        private final zzanu f5844a;

        /* renamed from: b */
        private final Map f5845b;

        private zza(zzanu zzanu, Map map) {
            this.f5844a = zzanu;
            this.f5845b = map;
        }

        /* synthetic */ zza(zzanu zzanu, Map map, C1458bw bwVar) {
            this(zzanu, map);
        }

        public void zza(zzaoo zzaoo, Object obj) {
            if (obj == null) {
                zzaoo.mo7926l();
                return;
            }
            zzaoo.mo7924j();
            try {
                for (C1459bx bxVar : this.f5845b.values()) {
                    if (bxVar.mo7122a(obj)) {
                        zzaoo.zztr(bxVar.f4904g);
                        bxVar.mo7121a(zzaoo, obj);
                    }
                }
                zzaoo.mo7925k();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public Object zzb(zzaom zzaom) {
            if (zzaom.mo7902b() == zzaon.NULL) {
                zzaom.nextNull();
                return null;
            }
            Object zzczu = this.f5844a.zzczu();
            try {
                zzaom.beginObject();
                while (zzaom.hasNext()) {
                    C1459bx bxVar = (C1459bx) this.f5845b.get(zzaom.nextName());
                    if (bxVar == null || !bxVar.f4906i) {
                        zzaom.skipValue();
                    } else {
                        bxVar.mo7120a(zzaom, zzczu);
                    }
                }
                zzaom.endObject();
                return zzczu;
            } catch (IllegalStateException e) {
                throw new zzane((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public zzaog(zzanp zzanp, zzamo zzamo, zzanq zzanq) {
        this.f5841a = zzanp;
        this.f5842b = zzamo;
        this.f5843c = zzanq;
    }

    /* renamed from: a */
    private C1459bx m6714a(zzamp zzamp, Field field, String str, zzaol zzaol, boolean z, boolean z2) {
        return new C1458bw(this, str, z, z2, zzamp, field, zzaol, zzanv.zzk(zzaol.mo7939m()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.google.android.gms.internal.zzaob.m6698a(r2.f5841a, r3, r5, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzanh m6715a(com.google.android.gms.internal.zzamp r3, java.lang.reflect.Field r4, com.google.android.gms.internal.zzaol r5) {
        /*
            r2 = this;
            java.lang.Class<com.google.android.gms.internal.zzanj> r0 = com.google.android.gms.internal.zzanj.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            com.google.android.gms.internal.zzanj r0 = (com.google.android.gms.internal.zzanj) r0
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.internal.zzanp r1 = r2.f5841a
            com.google.android.gms.internal.zzanh r0 = com.google.android.gms.internal.zzaob.m6698a(r1, r3, r5, r0)
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            return r0
        L_0x0013:
            com.google.android.gms.internal.zzanh r0 = r3.zza((com.google.android.gms.internal.zzaol) r5)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaog.m6715a(com.google.android.gms.internal.zzamp, java.lang.reflect.Field, com.google.android.gms.internal.zzaol):com.google.android.gms.internal.zzanh");
    }

    /* renamed from: a */
    static List m6717a(zzamo zzamo, Field field) {
        zzank zzank = (zzank) field.getAnnotation(zzank.class);
        LinkedList linkedList = new LinkedList();
        if (zzank == null) {
            linkedList.add(zzamo.zzc(field));
        } else {
            linkedList.add(zzank.value());
            for (String add : zzank.zzczs()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private List m6718a(Field field) {
        return m6717a(this.f5842b, field);
    }

    /* renamed from: a */
    private Map m6719a(zzamp zzamp, zzaol zzaol, Class<Object> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type n = zzaol.mo7940n();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zza2 = zza(field, true);
                boolean zza3 = zza(field, false);
                if (zza2 || zza3) {
                    field.setAccessible(true);
                    Type zza4 = zzano.zza(zzaol.mo7940n(), (Class) cls, field.getGenericType());
                    List a = m6718a(field);
                    C1459bx bxVar = null;
                    int i = 0;
                    while (i < a.size()) {
                        String str = (String) a.get(i);
                        if (i != 0) {
                            zza2 = false;
                        }
                        C1459bx bxVar2 = (C1459bx) linkedHashMap.put(str, m6714a(zzamp, field, str, zzaol.zzl(zza4), zza2, zza3));
                        if (bxVar != null) {
                            bxVar2 = bxVar;
                        }
                        i++;
                        bxVar = bxVar2;
                    }
                    if (bxVar != null) {
                        String valueOf = String.valueOf(n);
                        String str2 = bxVar.f4904g;
                        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(str2).length()).append(valueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            zzaol = zzaol.zzl(zzano.zza(zzaol.mo7940n(), (Class) cls, cls.getGenericSuperclass()));
            cls = zzaol.mo7939m();
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    static boolean m6720a(Field field, boolean z, zzanq zzanq) {
        return !zzanq.zza((Class) field.getType(), z) && !zzanq.zza(field, z);
    }

    public zzanh zza(zzamp zzamp, zzaol zzaol) {
        Class m = zzaol.mo7939m();
        if (!Object.class.isAssignableFrom(m)) {
            return null;
        }
        return new zza(this.f5841a.zzb(zzaol), m6719a(zzamp, zzaol, m), (C1458bw) null);
    }

    public boolean zza(Field field, boolean z) {
        return m6720a(field, z, this.f5843c);
    }
}
