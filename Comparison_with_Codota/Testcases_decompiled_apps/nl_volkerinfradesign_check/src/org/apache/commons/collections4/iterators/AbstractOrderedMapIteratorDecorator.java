package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;

public class AbstractOrderedMapIteratorDecorator<K, V> implements OrderedMapIterator<K, V> {

    /* renamed from: a */
    private final OrderedMapIterator<K, V> f6470a;

    public AbstractOrderedMapIteratorDecorator(OrderedMapIterator<K, V> orderedMapIterator) {
        if (orderedMapIterator == null) {
            throw new IllegalArgumentException("OrderedMapIterator must not be null");
        }
        this.f6470a = orderedMapIterator;
    }

    /* access modifiers changed from: protected */
    public OrderedMapIterator<K, V> getOrderedMapIterator() {
        return this.f6470a;
    }

    public boolean hasNext() {
        return this.f6470a.hasNext();
    }

    public K next() {
        return this.f6470a.next();
    }

    public boolean hasPrevious() {
        return this.f6470a.hasPrevious();
    }

    public K previous() {
        return this.f6470a.previous();
    }

    public void remove() {
        this.f6470a.remove();
    }

    public K getKey() {
        return this.f6470a.getKey();
    }

    public V getValue() {
        return this.f6470a.getValue();
    }

    public V setValue(V v) {
        return this.f6470a.setValue(v);
    }
}
