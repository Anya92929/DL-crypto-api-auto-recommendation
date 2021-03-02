package com.google.android.gms.p018c;

import java.util.Iterator;

/* renamed from: com.google.android.gms.c.v */
final class C0680v<T> implements Iterator<T> {

    /* renamed from: a */
    final int f4386a;

    /* renamed from: b */
    int f4387b;

    /* renamed from: c */
    int f4388c;

    /* renamed from: d */
    boolean f4389d = false;

    /* renamed from: e */
    final /* synthetic */ C0679u f4390e;

    C0680v(C0679u uVar, int i) {
        this.f4390e = uVar;
        this.f4386a = i;
        this.f4387b = uVar.mo7250a();
    }

    public boolean hasNext() {
        return this.f4388c < this.f4387b;
    }

    public T next() {
        T a = this.f4390e.mo7252a(this.f4388c, this.f4386a);
        this.f4388c++;
        this.f4389d = true;
        return a;
    }

    public void remove() {
        if (!this.f4389d) {
            throw new IllegalStateException();
        }
        this.f4388c--;
        this.f4387b--;
        this.f4389d = false;
        this.f4390e.mo7254a(this.f4388c);
    }
}
