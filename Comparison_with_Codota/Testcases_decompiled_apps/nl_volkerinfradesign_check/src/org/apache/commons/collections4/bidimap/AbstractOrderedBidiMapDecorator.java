package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;

public abstract class AbstractOrderedBidiMapDecorator<K, V> extends AbstractBidiMapDecorator<K, V> implements OrderedBidiMap<K, V> {
    protected AbstractOrderedBidiMapDecorator(OrderedBidiMap<K, V> orderedBidiMap) {
        super(orderedBidiMap);
    }

    /* access modifiers changed from: protected */
    public OrderedBidiMap<K, V> decorated() {
        return (OrderedBidiMap) super.decorated();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    public K firstKey() {
        return decorated().firstKey();
    }

    public K lastKey() {
        return decorated().lastKey();
    }

    public K nextKey(K k) {
        return decorated().nextKey(k);
    }

    public K previousKey(K k) {
        return decorated().previousKey(k);
    }

    public OrderedBidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }
}
