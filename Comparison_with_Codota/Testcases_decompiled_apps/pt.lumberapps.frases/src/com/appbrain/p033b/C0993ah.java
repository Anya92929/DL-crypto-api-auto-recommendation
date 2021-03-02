package com.appbrain.p033b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.appbrain.b.ah */
public final class C0993ah extends AbstractList implements C1017u, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1017u f2613a;

    public C0993ah(C1017u uVar) {
        this.f2613a = uVar;
    }

    /* renamed from: a */
    public final C1002f mo3941a(int i) {
        return this.f2613a.mo3941a(i);
    }

    /* renamed from: a */
    public final List mo3942a() {
        return this.f2613a.mo3942a();
    }

    /* renamed from: a */
    public final void mo3943a(C1002f fVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public final C1017u mo3944b() {
        return this;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return (String) this.f2613a.get(i);
    }

    public final Iterator iterator() {
        return new C0995aj(this);
    }

    public final ListIterator listIterator(int i) {
        return new C0994ai(this, i);
    }

    public final int size() {
        return this.f2613a.size();
    }
}
