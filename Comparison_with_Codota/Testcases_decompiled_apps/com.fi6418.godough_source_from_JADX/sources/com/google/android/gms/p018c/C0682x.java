package com.google.android.gms.p018c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.c.x */
final class C0682x implements Set<K> {

    /* renamed from: a */
    final /* synthetic */ C0679u f4392a;

    C0682x(C0679u uVar) {
        this.f4392a = uVar;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f4392a.mo7258c();
    }

    public boolean contains(Object obj) {
        return this.f4392a.mo7251a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return C0679u.m3920a(this.f4392a.mo7257b(), collection);
    }

    public boolean equals(Object obj) {
        return C0679u.m3921a(this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f4392a.mo7250a() - 1; a >= 0; a--) {
            Object a2 = this.f4392a.mo7252a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f4392a.mo7250a() == 0;
    }

    public Iterator<K> iterator() {
        return new C0680v(this.f4392a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f4392a.mo7251a(obj);
        if (a < 0) {
            return false;
        }
        this.f4392a.mo7254a(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return C0679u.m3922b(this.f4392a.mo7257b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return C0679u.m3923c(this.f4392a.mo7257b(), collection);
    }

    public int size() {
        return this.f4392a.mo7250a();
    }

    public Object[] toArray() {
        return this.f4392a.mo7260b(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f4392a.mo7259a(tArr, 0);
    }
}
