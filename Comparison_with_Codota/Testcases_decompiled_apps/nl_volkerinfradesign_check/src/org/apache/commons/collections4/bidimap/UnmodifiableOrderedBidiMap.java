package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableOrderedBidiMap<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements Unmodifiable {

    /* renamed from: b */
    private UnmodifiableOrderedBidiMap<V, K> f6384b;

    public static <K, V> OrderedBidiMap<K, V> unmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> orderedBidiMap) {
        return orderedBidiMap instanceof Unmodifiable ? orderedBidiMap : new UnmodifiableOrderedBidiMap(orderedBidiMap);
    }

    private UnmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> orderedBidiMap) {
        super(orderedBidiMap);
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

    public OrderedBidiMap<V, K> inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(decorated().mapIterator());
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        if (this.f6384b == null) {
            this.f6384b = new UnmodifiableOrderedBidiMap<>(decorated().inverseBidiMap());
            this.f6384b.f6384b = this;
        }
        return this.f6384b;
    }
}
