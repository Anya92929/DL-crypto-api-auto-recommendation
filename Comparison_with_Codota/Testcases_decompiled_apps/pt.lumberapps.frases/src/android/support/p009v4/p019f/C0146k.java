package android.support.p009v4.p019f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: android.support.v4.f.k */
final class C0146k implements Set {

    /* renamed from: a */
    final /* synthetic */ C0143h f215a;

    C0146k(C0143h hVar) {
        this.f215a = hVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f215a.mo1049c();
    }

    public boolean contains(Object obj) {
        return this.f215a.mo1042a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return C0143h.m356a(this.f215a.mo1048b(), collection);
    }

    public boolean equals(Object obj) {
        return C0143h.m357a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f215a.mo1041a() - 1; a >= 0; a--) {
            Object a2 = this.f215a.mo1043a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f215a.mo1041a() == 0;
    }

    public Iterator iterator() {
        return new C0144i(this.f215a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f215a.mo1042a(obj);
        if (a < 0) {
            return false;
        }
        this.f215a.mo1045a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return C0143h.m358b(this.f215a.mo1048b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return C0143h.m359c(this.f215a.mo1048b(), collection);
    }

    public int size() {
        return this.f215a.mo1041a();
    }

    public Object[] toArray() {
        return this.f215a.mo1082b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f215a.mo1081a(objArr, 0);
    }
}
