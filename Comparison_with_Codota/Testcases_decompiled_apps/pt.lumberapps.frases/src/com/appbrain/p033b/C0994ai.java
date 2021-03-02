package com.appbrain.p033b;

import java.util.ListIterator;

/* renamed from: com.appbrain.b.ai */
final class C0994ai implements ListIterator {

    /* renamed from: a */
    ListIterator f2614a = this.f2616c.f2613a.listIterator(this.f2615b);

    /* renamed from: b */
    final /* synthetic */ int f2615b;

    /* renamed from: c */
    final /* synthetic */ C0993ah f2616c;

    C0994ai(C0993ah ahVar, int i) {
        this.f2616c = ahVar;
        this.f2615b = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f2614a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f2614a.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f2614a.next();
    }

    public final int nextIndex() {
        return this.f2614a.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f2614a.previous();
    }

    public final int previousIndex() {
        return this.f2614a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
