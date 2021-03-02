package com.appbrain.p033b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* renamed from: com.appbrain.b.ae */
final class C0990ae implements Iterator {

    /* renamed from: a */
    private final Stack f2606a;

    /* renamed from: b */
    private C1018v f2607b;

    private C0990ae(C1002f fVar) {
        this.f2606a = new Stack();
        this.f2607b = m4129a(fVar);
    }

    /* synthetic */ C0990ae(C1002f fVar, byte b) {
        this(fVar);
    }

    /* renamed from: a */
    private C1018v m4129a(C1002f fVar) {
        C1002f fVar2 = fVar;
        while (fVar2 instanceof C0988ac) {
            C0988ac acVar = (C0988ac) fVar2;
            this.f2606a.push(acVar);
            fVar2 = acVar.f2600e;
        }
        return (C1018v) fVar2;
    }

    /* renamed from: b */
    private C1018v m4130b() {
        boolean z;
        while (!this.f2606a.isEmpty()) {
            C1018v a = m4129a(((C0988ac) this.f2606a.pop()).f2601f);
            if (a.mo3919a() == 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final C1018v next() {
        if (this.f2607b == null) {
            throw new NoSuchElementException();
        }
        C1018v vVar = this.f2607b;
        this.f2607b = m4130b();
        return vVar;
    }

    public final boolean hasNext() {
        return this.f2607b != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
