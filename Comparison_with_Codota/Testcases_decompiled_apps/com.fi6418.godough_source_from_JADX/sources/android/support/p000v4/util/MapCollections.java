package android.support.p000v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.util.MapCollections */
abstract class MapCollections<K, V> {

    /* renamed from: b */
    MapCollections<K, V>.EntrySet f1112b;

    /* renamed from: c */
    MapCollections<K, V>.KeySet f1113c;

    /* renamed from: d */
    MapCollections<K, V>.ValuesCollection f1114d;

    /* renamed from: android.support.v4.util.MapCollections$ArrayIterator */
    final class ArrayIterator<T> implements Iterator<T> {

        /* renamed from: a */
        final int f1115a;

        /* renamed from: b */
        int f1116b;

        /* renamed from: c */
        int f1117c;

        /* renamed from: d */
        boolean f1118d = false;

        ArrayIterator(int i) {
            this.f1115a = i;
            this.f1116b = MapCollections.this.mo1917a();
        }

        public boolean hasNext() {
            return this.f1117c < this.f1116b;
        }

        public T next() {
            T a = MapCollections.this.mo1919a(this.f1117c, this.f1115a);
            this.f1117c++;
            this.f1118d = true;
            return a;
        }

        public void remove() {
            if (!this.f1118d) {
                throw new IllegalStateException();
            }
            this.f1117c--;
            this.f1116b--;
            this.f1118d = false;
            MapCollections.this.mo1921a(this.f1117c);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$EntrySet */
    final class EntrySet implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a = MapCollections.this.mo1917a();
            for (Map.Entry entry : collection) {
                MapCollections.this.mo1922a(entry.getKey(), entry.getValue());
            }
            return a != MapCollections.this.mo1917a();
        }

        public void clear() {
            MapCollections.this.mo1925c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = MapCollections.this.mo1918a(entry.getKey());
            if (a >= 0) {
                return ContainerHelpers.equal(MapCollections.this.mo1919a(a, 1), entry.getValue());
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
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int a = MapCollections.this.mo1917a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = MapCollections.this.mo1919a(a, 0);
                Object a3 = MapCollections.this.mo1919a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return MapCollections.this.mo1917a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
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
            return MapCollections.this.mo1917a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$KeySet */
    final class KeySet implements Set<K> {
        KeySet() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.mo1925c();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.mo1918a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(MapCollections.this.mo1924b(), collection);
        }

        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = MapCollections.this.mo1917a() - 1; a >= 0; a--) {
                Object a2 = MapCollections.this.mo1919a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return MapCollections.this.mo1917a() == 0;
        }

        public Iterator<K> iterator() {
            return new ArrayIterator(0);
        }

        public boolean remove(Object obj) {
            int a = MapCollections.this.mo1918a(obj);
            if (a < 0) {
                return false;
            }
            MapCollections.this.mo1921a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(MapCollections.this.mo1924b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(MapCollections.this.mo1924b(), collection);
        }

        public int size() {
            return MapCollections.this.mo1917a();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return MapCollections.this.toArrayHelper(tArr, 0);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$MapIterator */
    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f1122a;

        /* renamed from: b */
        int f1123b;

        /* renamed from: c */
        boolean f1124c = false;

        MapIterator() {
            this.f1122a = MapCollections.this.mo1917a() - 1;
            this.f1123b = -1;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f1124c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpers.equal(entry.getKey(), MapCollections.this.mo1919a(this.f1123b, 0)) || !ContainerHelpers.equal(entry.getValue(), MapCollections.this.mo1919a(this.f1123b, 1))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f1124c) {
                return MapCollections.this.mo1919a(this.f1123b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1124c) {
                return MapCollections.this.mo1919a(this.f1123b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1123b < this.f1122a;
        }

        public final int hashCode() {
            int i = 0;
            if (!this.f1124c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object a = MapCollections.this.mo1919a(this.f1123b, 0);
            Object a2 = MapCollections.this.mo1919a(this.f1123b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }

        public Map.Entry<K, V> next() {
            this.f1123b++;
            this.f1124c = true;
            return this;
        }

        public void remove() {
            if (!this.f1124c) {
                throw new IllegalStateException();
            }
            MapCollections.this.mo1921a(this.f1123b);
            this.f1123b--;
            this.f1122a--;
            this.f1124c = false;
        }

        public V setValue(V v) {
            if (this.f1124c) {
                return MapCollections.this.mo1920a(this.f1123b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$ValuesCollection */
    final class ValuesCollection implements Collection<V> {
        ValuesCollection() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            MapCollections.this.mo1925c();
        }

        public boolean contains(Object obj) {
            return MapCollections.this.mo1923b(obj) >= 0;
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
            return MapCollections.this.mo1917a() == 0;
        }

        public Iterator<V> iterator() {
            return new ArrayIterator(1);
        }

        public boolean remove(Object obj) {
            int b = MapCollections.this.mo1923b(obj);
            if (b < 0) {
                return false;
            }
            MapCollections.this.mo1921a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = MapCollections.this.mo1917a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(MapCollections.this.mo1919a(i, 1))) {
                    MapCollections.this.mo1921a(i);
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
            int a = MapCollections.this.mo1917a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(MapCollections.this.mo1919a(i, 1))) {
                    MapCollections.this.mo1921a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return MapCollections.this.mo1917a();
        }

        public Object[] toArray() {
            return MapCollections.this.toArrayHelper(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    MapCollections() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
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

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo1917a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo1918a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo1919a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo1920a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo1921a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo1922a(K k, V v);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo1923b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo1924b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo1925c();

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.f1112b == null) {
            this.f1112b = new EntrySet();
        }
        return this.f1112b;
    }

    public Set<K> getKeySet() {
        if (this.f1113c == null) {
            this.f1113c = new KeySet();
        }
        return this.f1113c;
    }

    public Collection<V> getValues() {
        if (this.f1114d == null) {
            this.f1114d = new ValuesCollection();
        }
        return this.f1114d;
    }

    public Object[] toArrayHelper(int i) {
        int a = mo1917a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo1919a(i2, i);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i) {
        int a = mo1917a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo1919a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }
}
