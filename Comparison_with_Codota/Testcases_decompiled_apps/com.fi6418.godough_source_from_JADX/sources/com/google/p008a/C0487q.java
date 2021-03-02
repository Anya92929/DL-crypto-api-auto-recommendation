package com.google.p008a;

import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.q */
class C0487q<T> extends C0363al<T> {

    /* renamed from: a */
    private C0363al<T> f3633a;

    C0487q() {
    }

    /* renamed from: a */
    public void mo6526a(C0363al<T> alVar) {
        if (this.f3633a != null) {
            throw new AssertionError();
        }
        this.f3633a = alVar;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        if (this.f3633a == null) {
            throw new IllegalStateException();
        }
        this.f3633a.mo6309a(dVar, t);
    }

    /* renamed from: b */
    public T mo6310b(C0470a aVar) {
        if (this.f3633a != null) {
            return this.f3633a.mo6310b(aVar);
        }
        throw new IllegalStateException();
    }
}
