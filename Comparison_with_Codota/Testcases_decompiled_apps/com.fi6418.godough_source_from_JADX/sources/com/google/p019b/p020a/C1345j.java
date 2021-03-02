package com.google.p019b.p020a;

import java.util.LinkedHashMap;

/* renamed from: com.google.b.a.j */
class C1345j<K, V> {

    /* renamed from: a */
    private LinkedHashMap<K, V> f5546a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f5547b;

    public C1345j(int i) {
        this.f5547b = i;
        this.f5546a = new C1346k(this, ((i * 4) / 3) + 1, 0.75f, true);
    }

    /* renamed from: a */
    public synchronized V mo9257a(K k) {
        return this.f5546a.get(k);
    }

    /* renamed from: a */
    public synchronized void mo9258a(K k, V v) {
        this.f5546a.put(k, v);
    }
}
