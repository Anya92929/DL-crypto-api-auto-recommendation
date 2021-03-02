package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableMapIterator<K, V> implements MapIterator<K, V>, Unmodifiable {

    /* renamed from: a */
    private final MapIterator<? extends K, ? extends V> f6560a;

    public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<? extends K, ? extends V> mapIterator) {
        if (mapIterator != null) {
            return mapIterator instanceof Unmodifiable ? mapIterator : new UnmodifiableMapIterator(mapIterator);
        }
        throw new IllegalArgumentException("MapIterator must not be null");
    }

    private UnmodifiableMapIterator(MapIterator<? extends K, ? extends V> mapIterator) {
        this.f6560a = mapIterator;
    }

    public boolean hasNext() {
        return this.f6560a.hasNext();
    }

    public K next() {
        return this.f6560a.next();
    }

    public K getKey() {
        return this.f6560a.getKey();
    }

    public V getValue() {
        return this.f6560a.getValue();
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
