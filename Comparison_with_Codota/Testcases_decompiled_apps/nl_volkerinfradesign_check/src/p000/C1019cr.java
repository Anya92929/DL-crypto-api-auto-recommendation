package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: cr */
public abstract class C1019cr<K, V> {

    /* renamed from: b */
    C1019cr<K, V>.C0608b f4036b;

    /* renamed from: c */
    C1019cr<K, V>.C0650c f4037c;

    /* renamed from: d */
    C1019cr<K, V>.C1066e f4038d;

    /* renamed from: a */
    public abstract int mo1561a();

    /* renamed from: a */
    public abstract int mo1562a(Object obj);

    /* renamed from: a */
    public abstract Object mo1563a(int i, int i2);

    /* renamed from: a */
    public abstract V mo1564a(int i, V v);

    /* renamed from: a */
    public abstract void mo1565a(int i);

    /* renamed from: a */
    public abstract void mo1566a(K k, V v);

    /* renamed from: b */
    public abstract int mo1567b(Object obj);

    /* renamed from: b */
    public abstract Map<K, V> mo1568b();

    /* renamed from: c */
    public abstract void mo1569c();

    /* renamed from: cr$a */
    final class C1020a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f4039a;

        /* renamed from: b */
        int f4040b;

        /* renamed from: c */
        int f4041c;

        /* renamed from: d */
        boolean f4042d = false;

        C1020a(int i) {
            this.f4039a = i;
            this.f4040b = C1019cr.this.mo1561a();
        }

        public boolean hasNext() {
            return this.f4041c < this.f4040b;
        }

        public T next() {
            T a = C1019cr.this.mo1563a(this.f4041c, this.f4039a);
            this.f4041c++;
            this.f4042d = true;
            return a;
        }

        public void remove() {
            if (!this.f4042d) {
                throw new IllegalStateException();
            }
            this.f4041c--;
            this.f4040b--;
            this.f4042d = false;
            C1019cr.this.mo1565a(this.f4041c);
        }
    }

    /* renamed from: cr$d */
    final class C1023d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f4046a;

        /* renamed from: b */
        int f4047b;

        /* renamed from: c */
        boolean f4048c = false;

        C1023d() {
            this.f4046a = C1019cr.this.mo1561a() - 1;
            this.f4047b = -1;
        }

        public boolean hasNext() {
            return this.f4047b < this.f4046a;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            this.f4047b++;
            this.f4048c = true;
            return this;
        }

        public void remove() {
            if (!this.f4048c) {
                throw new IllegalStateException();
            }
            C1019cr.this.mo1565a(this.f4047b);
            this.f4047b--;
            this.f4046a--;
            this.f4048c = false;
        }

        public K getKey() {
            if (this.f4048c) {
                return C1019cr.this.mo1563a(this.f4047b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f4048c) {
                return C1019cr.this.mo1563a(this.f4047b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f4048c) {
                return C1019cr.this.mo1564a(this.f4047b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f4048c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!C1018cq.m4571a(entry.getKey(), C1019cr.this.mo1563a(this.f4047b, 0)) || !C1018cq.m4571a(entry.getValue(), C1019cr.this.mo1563a(this.f4047b, 1))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (!this.f4048c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object a = C1019cr.this.mo1563a(this.f4047b, 0);
            Object a2 = C1019cr.this.mo1563a(this.f4047b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: cr$b */
    final class C1021b implements Set<Map.Entry<K, V>> {
        C1021b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a = C1019cr.this.mo1561a();
            for (Map.Entry entry : collection) {
                C1019cr.this.mo1566a(entry.getKey(), entry.getValue());
            }
            return a != C1019cr.this.mo1561a();
        }

        public void clear() {
            C1019cr.this.mo1569c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = C1019cr.this.mo1562a(entry.getKey());
            if (a >= 0) {
                return C1018cq.m4571a(C1019cr.this.mo1563a(a, 1), entry.getValue());
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

        public boolean isEmpty() {
            return C1019cr.this.mo1561a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1023d();
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
            return C1019cr.this.mo1561a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C1019cr.m4575a(this, obj);
        }

        public int hashCode() {
            int a = C1019cr.this.mo1561a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = C1019cr.this.mo1563a(a, 0);
                Object a3 = C1019cr.this.mo1563a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }
    }

    /* renamed from: cr$c */
    final class C1022c implements Set<K> {
        C1022c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C1019cr.this.mo1569c();
        }

        public boolean contains(Object obj) {
            return C1019cr.this.mo1562a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C1019cr.m4574a(C1019cr.this.mo1568b(), collection);
        }

        public boolean isEmpty() {
            return C1019cr.this.mo1561a() == 0;
        }

        public Iterator<K> iterator() {
            return new C1020a(0);
        }

        public boolean remove(Object obj) {
            int a = C1019cr.this.mo1562a(obj);
            if (a < 0) {
                return false;
            }
            C1019cr.this.mo1565a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C1019cr.m4576b(C1019cr.this.mo1568b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C1019cr.m4577c(C1019cr.this.mo1568b(), collection);
        }

        public int size() {
            return C1019cr.this.mo1561a();
        }

        public Object[] toArray() {
            return C1019cr.this.mo8015b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return C1019cr.this.mo8014a(tArr, 0);
        }

        public boolean equals(Object obj) {
            return C1019cr.m4575a(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = C1019cr.this.mo1561a() - 1; a >= 0; a--) {
                Object a2 = C1019cr.this.mo1563a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    /* renamed from: cr$e */
    final class C1024e implements Collection<V> {
        C1024e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C1019cr.this.mo1569c();
        }

        public boolean contains(Object obj) {
            return C1019cr.this.mo1567b(obj) >= 0;
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
            return C1019cr.this.mo1561a() == 0;
        }

        public Iterator<V> iterator() {
            return new C1020a(1);
        }

        public boolean remove(Object obj) {
            int b = C1019cr.this.mo1567b(obj);
            if (b < 0) {
                return false;
            }
            C1019cr.this.mo1565a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = C1019cr.this.mo1561a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(C1019cr.this.mo1563a(i, 1))) {
                    C1019cr.this.mo1565a(i);
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
            int a = C1019cr.this.mo1561a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(C1019cr.this.mo1563a(i, 1))) {
                    C1019cr.this.mo1565a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return C1019cr.this.mo1561a();
        }

        public Object[] toArray() {
            return C1019cr.this.mo8015b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return C1019cr.this.mo8014a(tArr, 1);
        }
    }

    /* renamed from: a */
    public static <K, V> boolean m4574a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m4576b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m4577c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: b */
    public Object[] mo8015b(int i) {
        int a = mo1561a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo1563a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] mo8014a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo1561a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo1563a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    /* renamed from: a */
    public static <T> boolean m4575a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* renamed from: d */
    public Set<Map.Entry<K, V>> mo8016d() {
        if (this.f4036b == null) {
            this.f4036b = new C1021b();
        }
        return this.f4036b;
    }

    /* renamed from: e */
    public Set<K> mo8017e() {
        if (this.f4037c == null) {
            this.f4037c = new C1022c();
        }
        return this.f4037c;
    }

    /* renamed from: f */
    public Collection<V> mo8018f() {
        if (this.f4038d == null) {
            this.f4038d = new C1024e();
        }
        return this.f4038d;
    }
}
