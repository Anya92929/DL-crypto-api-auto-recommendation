package com.google.p008a.p010b;

import java.util.AbstractSet;
import java.util.Iterator;

/* renamed from: com.google.a.b.aa */
final class C0427aa extends AbstractSet<K> {

    /* renamed from: a */
    final /* synthetic */ C0463w f3491a;

    C0427aa(C0463w wVar) {
        this.f3491a = wVar;
    }

    public void clear() {
        this.f3491a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3491a.containsKey(obj);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.a.b.ab, java.util.Iterator<K>] */
    public Iterator<K> iterator() {
        return new C0428ab(this);
    }

    public boolean remove(Object obj) {
        return this.f3491a.mo6476b(obj) != null;
    }

    public int size() {
        return this.f3491a.f3563c;
    }
}
