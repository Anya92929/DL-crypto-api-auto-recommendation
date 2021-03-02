package com.google.p019b.p020a;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.google.b.a.k */
class C1346k extends LinkedHashMap<K, V> {

    /* renamed from: a */
    final /* synthetic */ C1345j f5548a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1346k(C1345j jVar, int i, float f, boolean z) {
        super(i, f, z);
        this.f5548a = jVar;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.f5548a.f5547b;
    }
}
