package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableSortedBidiMap<K, V> extends AbstractSortedBidiMapDecorator<K, V> implements Unmodifiable {

    /* renamed from: b */
    private UnmodifiableSortedBidiMap<V, K> f6385b;

    public static <K, V> SortedBidiMap<K, V> unmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> sortedBidiMap) {
        return sortedBidiMap instanceof Unmodifiable ? sortedBidiMap : new UnmodifiableSortedBidiMap(sortedBidiMap);
    }

    private UnmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> sortedBidiMap) {
        super(sortedBidiMap);
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
    }

    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(super.keySet());
    }

    public Set<V> values() {
        return UnmodifiableSet.unmodifiableSet(super.values());
    }

    public K removeValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(decorated().mapIterator());
    }

    public SortedBidiMap<V, K> inverseBidiMap() {
        if (this.f6385b == null) {
            this.f6385b = new UnmodifiableSortedBidiMap<>(decorated().inverseBidiMap());
            this.f6385b.f6385b = this;
        }
        return this.f6385b;
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().subMap(k, k2));
    }

    public SortedMap<K, V> headMap(K k) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().headMap(k));
    }

    public SortedMap<K, V> tailMap(K k) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().tailMap(k));
    }
}
