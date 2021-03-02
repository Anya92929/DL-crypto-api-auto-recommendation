package com.google.p008a.p010b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.a.b.ac */
abstract class C0429ac<T> implements Iterator<T> {

    /* renamed from: b */
    C0430ad<K, V> f3493b;

    /* renamed from: c */
    C0430ad<K, V> f3494c;

    /* renamed from: d */
    int f3495d;

    /* renamed from: e */
    final /* synthetic */ C0463w f3496e;

    private C0429ac(C0463w wVar) {
        this.f3496e = wVar;
        this.f3493b = this.f3496e.f3565e.f3500d;
        this.f3494c = null;
        this.f3495d = this.f3496e.f3564d;
    }

    /* synthetic */ C0429ac(C0463w wVar, C0464x xVar) {
        this(wVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C0430ad<K, V> mo6425b() {
        C0430ad<K, V> adVar = this.f3493b;
        if (adVar == this.f3496e.f3565e) {
            throw new NoSuchElementException();
        } else if (this.f3496e.f3564d != this.f3495d) {
            throw new ConcurrentModificationException();
        } else {
            this.f3493b = adVar.f3500d;
            this.f3494c = adVar;
            return adVar;
        }
    }

    public final boolean hasNext() {
        return this.f3493b != this.f3496e.f3565e;
    }

    public final void remove() {
        if (this.f3494c == null) {
            throw new IllegalStateException();
        }
        this.f3496e.mo6475a(this.f3494c, true);
        this.f3494c = null;
        this.f3495d = this.f3496e.f3564d;
    }
}
