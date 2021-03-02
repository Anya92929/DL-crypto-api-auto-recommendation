package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MapBackedSet<E, V> implements Serializable, Set<E> {
    private static final long serialVersionUID = 6723912213766056587L;

    /* renamed from: a */
    private final Map<E, ? super V> f6760a;

    /* renamed from: b */
    private final V f6761b;

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map) {
        return mapBackedSet(map, (Object) null);
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map, V v) {
        if (map != null) {
            return new MapBackedSet<>(map, v);
        }
        throw new IllegalArgumentException("The map must not be null");
    }

    private MapBackedSet(Map<E, ? super V> map, V v) {
        this.f6760a = map;
        this.f6761b = v;
    }

    public int size() {
        return this.f6760a.size();
    }

    public boolean isEmpty() {
        return this.f6760a.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f6760a.keySet().iterator();
    }

    public boolean contains(Object obj) {
        return this.f6760a.containsKey(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f6760a.keySet().containsAll(collection);
    }

    public boolean add(E e) {
        int size = this.f6760a.size();
        this.f6760a.put(e, this.f6761b);
        return this.f6760a.size() != size;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = this.f6760a.size();
        for (Object put : collection) {
            this.f6760a.put(put, this.f6761b);
        }
        return this.f6760a.size() != size;
    }

    public boolean remove(Object obj) {
        int size = this.f6760a.size();
        this.f6760a.remove(obj);
        return this.f6760a.size() != size;
    }

    public boolean removeAll(Collection<?> collection) {
        return this.f6760a.keySet().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.f6760a.keySet().retainAll(collection);
    }

    public void clear() {
        this.f6760a.clear();
    }

    public Object[] toArray() {
        return this.f6760a.keySet().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f6760a.keySet().toArray(tArr);
    }

    public boolean equals(Object obj) {
        return this.f6760a.keySet().equals(obj);
    }

    public int hashCode() {
        return this.f6760a.keySet().hashCode();
    }
}
