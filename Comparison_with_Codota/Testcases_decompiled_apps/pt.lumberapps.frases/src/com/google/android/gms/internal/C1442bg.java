package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.bg */
final class C1442bg implements Map.Entry {

    /* renamed from: a */
    C1442bg f4875a;

    /* renamed from: b */
    C1442bg f4876b;

    /* renamed from: c */
    C1442bg f4877c;

    /* renamed from: d */
    C1442bg f4878d;

    /* renamed from: e */
    C1442bg f4879e;

    /* renamed from: f */
    final Object f4880f;

    /* renamed from: g */
    Object f4881g;

    /* renamed from: h */
    int f4882h;

    C1442bg() {
        this.f4880f = null;
        this.f4879e = this;
        this.f4878d = this;
    }

    C1442bg(C1442bg bgVar, Object obj, C1442bg bgVar2, C1442bg bgVar3) {
        this.f4875a = bgVar;
        this.f4880f = obj;
        this.f4882h = 1;
        this.f4878d = bgVar2;
        this.f4879e = bgVar3;
        bgVar3.f4878d = this;
        bgVar2.f4879e = this;
    }

    /* renamed from: a */
    public C1442bg mo7095a() {
        for (C1442bg bgVar = this.f4876b; bgVar != null; bgVar = bgVar.f4876b) {
            this = bgVar;
        }
        return this;
    }

    /* renamed from: b */
    public C1442bg mo7096b() {
        for (C1442bg bgVar = this.f4877c; bgVar != null; bgVar = bgVar.f4877c) {
            this = bgVar;
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            boolean r1 = r4 instanceof java.util.Map.Entry
            if (r1 == 0) goto L_0x001c
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r1 = r3.f4880f
            if (r1 != 0) goto L_0x001d
            java.lang.Object r1 = r4.getKey()
            if (r1 != 0) goto L_0x001c
        L_0x0011:
            java.lang.Object r1 = r3.f4881g
            if (r1 != 0) goto L_0x002a
            java.lang.Object r1 = r4.getValue()
            if (r1 != 0) goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            return r0
        L_0x001d:
            java.lang.Object r1 = r3.f4880f
            java.lang.Object r2 = r4.getKey()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            goto L_0x0011
        L_0x002a:
            java.lang.Object r1 = r3.f4881g
            java.lang.Object r2 = r4.getValue()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1442bg.equals(java.lang.Object):boolean");
    }

    public Object getKey() {
        return this.f4880f;
    }

    public Object getValue() {
        return this.f4881g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f4880f == null ? 0 : this.f4880f.hashCode();
        if (this.f4881g != null) {
            i = this.f4881g.hashCode();
        }
        return hashCode ^ i;
    }

    public Object setValue(Object obj) {
        Object obj2 = this.f4881g;
        this.f4881g = obj;
        return obj2;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f4880f);
        String valueOf2 = String.valueOf(this.f4881g);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}
