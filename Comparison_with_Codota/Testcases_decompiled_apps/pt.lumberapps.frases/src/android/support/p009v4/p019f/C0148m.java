package android.support.p009v4.p019f;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: android.support.v4.f.m */
final class C0148m implements Collection {

    /* renamed from: a */
    final /* synthetic */ C0143h f220a;

    C0148m(C0143h hVar) {
        this.f220a = hVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f220a.mo1049c();
    }

    public boolean contains(Object obj) {
        return this.f220a.mo1047b(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f220a.mo1041a() == 0;
    }

    public Iterator iterator() {
        return new C0144i(this.f220a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f220a.mo1047b(obj);
        if (b < 0) {
            return false;
        }
        this.f220a.mo1045a(b);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f220a.mo1041a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f220a.mo1043a(i, 1))) {
                this.f220a.mo1045a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f220a.mo1041a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f220a.mo1043a(i, 1))) {
                this.f220a.mo1045a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f220a.mo1041a();
    }

    public Object[] toArray() {
        return this.f220a.mo1082b(1);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f220a.mo1081a(objArr, 1);
    }
}
