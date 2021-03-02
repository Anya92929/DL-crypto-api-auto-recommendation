package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, Unmodifiable {

    /* renamed from: a */
    private final OrderedMapIterator<? extends K, ? extends V> f6561a;

    public static <K, V> OrderedMapIterator<K, V> unmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> orderedMapIterator) {
        if (orderedMapIterator != null) {
            return orderedMapIterator instanceof Unmodifiable ? orderedMapIterator : new UnmodifiableOrderedMapIterator(orderedMapIterator);
        }
        throw new IllegalArgumentException("OrderedMapIterator must not be null");
    }

    private UnmodifiableOrderedMapIterator(OrderedMapIterator<K, ? extends V> orderedMapIterator) {
        this.f6561a = orderedMapIterator;
    }

    public boolean hasNext() {
        return this.f6561a.hasNext();
    }

    public K next() {
        return this.f6561a.next();
    }

    public boolean hasPrevious() {
        return this.f6561a.hasPrevious();
    }

    public K previous() {
        return this.f6561a.previous();
    }

    public K getKey() {
        return this.f6561a.getKey();
    }

    public V getValue() {
        return this.f6561a.getValue();
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
