package android.support.p009v4.p019f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.f.j */
final class C0145j implements Set {

    /* renamed from: a */
    final /* synthetic */ C0143h f214a;

    C0145j(C0143h hVar) {
        this.f214a = hVar;
    }

    /* renamed from: a */
    public boolean add(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        int a = this.f214a.mo1041a();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            this.f214a.mo1046a(entry.getKey(), entry.getValue());
        }
        return a != this.f214a.mo1041a();
    }

    public void clear() {
        this.f214a.mo1049c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        int a = this.f214a.mo1042a(entry.getKey());
        if (a >= 0) {
            return C0138c.m338a(this.f214a.mo1043a(a, 1), entry.getValue());
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0143h.m357a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f214a.mo1041a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f214a.mo1043a(a, 0);
            Object a3 = this.f214a.mo1043a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f214a.mo1041a() == 0;
    }

    public Iterator iterator() {
        return new C0147l(this.f214a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f214a.mo1041a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
