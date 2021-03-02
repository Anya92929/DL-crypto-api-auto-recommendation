package org.apache.commons.collections4.map;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

public final class UnmodifiableEntrySet<K, V> extends AbstractSetDecorator<Map.Entry<K, V>> implements Unmodifiable {
    private static final long serialVersionUID = 1678353579659253473L;

    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        return set instanceof Unmodifiable ? set : new UnmodifiableEntrySet(set);
    }

    private UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        super(set);
    }

    public boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
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

    public Iterator<Map.Entry<K, V>> iterator() {
        return new C1919b(decorated().iterator());
    }

    public Object[] toArray() {
        Object[] array = decorated().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= array.length) {
                return array;
            }
            array[i2] = new C1918a((Map.Entry) array[i2]);
            i = i2 + 1;
        }
    }

    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        if (tArr.length > 0) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 0);
        } else {
            tArr2 = tArr;
        }
        T[] array = decorated().toArray(tArr2);
        for (int i = 0; i < array.length; i++) {
            array[i] = new C1918a((Map.Entry) array[i]);
        }
        if (array.length > tArr.length) {
            return (Object[]) array;
        }
        System.arraycopy(array, 0, tArr, 0, array.length);
        if (tArr.length > array.length) {
            tArr[array.length] = null;
        }
        return tArr;
    }

    /* renamed from: org.apache.commons.collections4.map.UnmodifiableEntrySet$b */
    class C1919b extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected C1919b(Iterator<Map.Entry<K, V>> it) {
            super(it);
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return new C1918a((Map.Entry) getIterator().next());
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.UnmodifiableEntrySet$a */
    class C1918a extends AbstractMapEntryDecorator<K, V> {
        protected C1918a(Map.Entry<K, V> entry) {
            super(entry);
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }
}
