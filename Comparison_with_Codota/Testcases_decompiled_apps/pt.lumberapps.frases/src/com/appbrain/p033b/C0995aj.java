package com.appbrain.p033b;

import java.util.Iterator;

/* renamed from: com.appbrain.b.aj */
final class C0995aj implements Iterator {

    /* renamed from: a */
    Iterator f2617a = this.f2618b.f2613a.iterator();

    /* renamed from: b */
    final /* synthetic */ C0993ah f2618b;

    C0995aj(C0993ah ahVar) {
        this.f2618b = ahVar;
    }

    public final boolean hasNext() {
        return this.f2617a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f2617a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
