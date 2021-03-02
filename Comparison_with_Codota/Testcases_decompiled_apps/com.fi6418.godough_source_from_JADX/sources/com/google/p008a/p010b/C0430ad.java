package com.google.p008a.p010b;

import java.util.Map;

/* renamed from: com.google.a.b.ad */
final class C0430ad<K, V> implements Map.Entry<K, V> {

    /* renamed from: a */
    C0430ad<K, V> f3497a;

    /* renamed from: b */
    C0430ad<K, V> f3498b;

    /* renamed from: c */
    C0430ad<K, V> f3499c;

    /* renamed from: d */
    C0430ad<K, V> f3500d;

    /* renamed from: e */
    C0430ad<K, V> f3501e;

    /* renamed from: f */
    final K f3502f;

    /* renamed from: g */
    V f3503g;

    /* renamed from: h */
    int f3504h;

    C0430ad() {
        this.f3502f = null;
        this.f3501e = this;
        this.f3500d = this;
    }

    C0430ad(C0430ad<K, V> adVar, K k, C0430ad<K, V> adVar2, C0430ad<K, V> adVar3) {
        this.f3497a = adVar;
        this.f3502f = k;
        this.f3504h = 1;
        this.f3500d = adVar2;
        this.f3501e = adVar3;
        adVar3.f3500d = this;
        adVar2.f3501e = this;
    }

    /* renamed from: a */
    public C0430ad<K, V> mo6428a() {
        for (C0430ad<K, V> adVar = this.f3498b; adVar != null; adVar = adVar.f3498b) {
            this = adVar;
        }
        return this;
    }

    /* renamed from: b */
    public C0430ad<K, V> mo6429b() {
        for (C0430ad<K, V> adVar = this.f3499c; adVar != null; adVar = adVar.f3499c) {
            this = adVar;
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
            K r1 = r3.f3502f
            if (r1 != 0) goto L_0x001d
            java.lang.Object r1 = r4.getKey()
            if (r1 != 0) goto L_0x001c
        L_0x0011:
            V r1 = r3.f3503g
            if (r1 != 0) goto L_0x002a
            java.lang.Object r1 = r4.getValue()
            if (r1 != 0) goto L_0x001c
        L_0x001b:
            r0 = 1
        L_0x001c:
            return r0
        L_0x001d:
            K r1 = r3.f3502f
            java.lang.Object r2 = r4.getKey()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            goto L_0x0011
        L_0x002a:
            V r1 = r3.f3503g
            java.lang.Object r2 = r4.getValue()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p008a.p010b.C0430ad.equals(java.lang.Object):boolean");
    }

    public K getKey() {
        return this.f3502f;
    }

    public V getValue() {
        return this.f3503g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f3502f == null ? 0 : this.f3502f.hashCode();
        if (this.f3503g != null) {
            i = this.f3503g.hashCode();
        }
        return hashCode ^ i;
    }

    public V setValue(V v) {
        V v2 = this.f3503g;
        this.f3503g = v;
        return v2;
    }

    public String toString() {
        return this.f3502f + "=" + this.f3503g;
    }
}
