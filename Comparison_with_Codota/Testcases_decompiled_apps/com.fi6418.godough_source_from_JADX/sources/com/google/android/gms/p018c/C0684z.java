package com.google.android.gms.p018c;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.android.gms.c.z */
final class C0684z implements Collection<V> {

    /* renamed from: a */
    final /* synthetic */ C0679u f4397a;

    C0684z(C0679u uVar) {
        this.f4397a = uVar;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f4397a.mo7258c();
    }

    public boolean contains(Object obj) {
        return this.f4397a.mo7256b(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f4397a.mo7250a() == 0;
    }

    public Iterator<V> iterator() {
        return new C0680v(this.f4397a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f4397a.mo7256b(obj);
        if (b < 0) {
            return false;
        }
        this.f4397a.mo7254a(b);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.f4397a.mo7250a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f4397a.mo7252a(i, 1))) {
                this.f4397a.mo7254a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.f4397a.mo7250a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f4397a.mo7252a(i, 1))) {
                this.f4397a.mo7254a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f4397a.mo7250a();
    }

    public Object[] toArray() {
        return this.f4397a.mo7260b(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f4397a.mo7259a(tArr, 1);
    }
}
