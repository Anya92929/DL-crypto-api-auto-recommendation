package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;

public class AbstractMapIteratorDecorator<K, V> implements MapIterator<K, V> {

    /* renamed from: a */
    private final MapIterator<K, V> f6469a;

    public AbstractMapIteratorDecorator(MapIterator<K, V> mapIterator) {
        if (mapIterator == null) {
            throw new IllegalArgumentException("MapIterator must not be null");
        }
        this.f6469a = mapIterator;
    }

    /* access modifiers changed from: protected */
    public MapIterator<K, V> getMapIterator() {
        return this.f6469a;
    }

    public boolean hasNext() {
        return this.f6469a.hasNext();
    }

    public K next() {
        return this.f6469a.next();
    }

    public void remove() {
        this.f6469a.remove();
    }

    public K getKey() {
        return this.f6469a.getKey();
    }

    public V getValue() {
        return this.f6469a.getValue();
    }

    public V setValue(V v) {
        return this.f6469a.setValue(v);
    }
}
