package com.google.p008a.p010b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.a.b.y */
class C0465y extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a */
    final /* synthetic */ C0463w f3568a;

    C0465y(C0463w wVar) {
        this.f3568a = wVar;
    }

    public void clear() {
        this.f3568a.clear();
    }

    public boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.f3568a.mo6474a((Map.Entry<?, ?>) (Map.Entry) obj) != null;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.a.b.z, java.util.Iterator<java.util.Map$Entry<K, V>>] */
    public Iterator<Map.Entry<K, V>> iterator() {
        return new C0466z(this);
    }

    public boolean remove(Object obj) {
        C0430ad a;
        if (!(obj instanceof Map.Entry) || (a = this.f3568a.mo6474a((Map.Entry<?, ?>) (Map.Entry) obj)) == null) {
            return false;
        }
        this.f3568a.mo6475a(a, true);
        return true;
    }

    public int size() {
        return this.f3568a.f3563c;
    }
}
