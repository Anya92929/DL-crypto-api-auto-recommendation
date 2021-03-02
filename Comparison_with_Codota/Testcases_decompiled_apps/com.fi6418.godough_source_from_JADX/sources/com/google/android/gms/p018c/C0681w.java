package com.google.android.gms.p018c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.c.w */
final class C0681w implements Set<Map.Entry<K, V>> {

    /* renamed from: a */
    final /* synthetic */ C0679u f4391a;

    C0681w(C0679u uVar) {
        this.f4391a = uVar;
    }

    /* renamed from: a */
    public boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        int a = this.f4391a.mo7250a();
        for (Map.Entry entry : collection) {
            this.f4391a.mo7255a(entry.getKey(), entry.getValue());
        }
        return a != this.f4391a.mo7250a();
    }

    public void clear() {
        this.f4391a.mo7258c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        int a = this.f4391a.mo7251a(entry.getKey());
        if (a >= 0) {
            return C0678t.m3919a(this.f4391a.mo7252a(a, 1), entry.getValue());
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0679u.m3921a(this, obj);
    }

    public int hashCode() {
        int a = this.f4391a.mo7250a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f4391a.mo7252a(a, 0);
            Object a3 = this.f4391a.mo7252a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f4391a.mo7250a() == 0;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new C0683y(this.f4391a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f4391a.mo7250a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
