package org.apache.commons.collections4.map;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;

public abstract class AbstractOrderedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V> {
    protected AbstractOrderedMapDecorator() {
    }

    public AbstractOrderedMapDecorator(OrderedMap<K, V> orderedMap) {
        super(orderedMap);
    }

    /* access modifiers changed from: protected */
    public OrderedMap<K, V> decorated() {
        return (OrderedMap) super.decorated();
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

    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }
}
