package org.apache.commons.collections4.bidimap;

import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractMapDecorator;

public abstract class AbstractBidiMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements BidiMap<K, V> {
    protected AbstractBidiMapDecorator(BidiMap<K, V> bidiMap) {
        super(bidiMap);
    }

    /* access modifiers changed from: protected */
    public BidiMap<K, V> decorated() {
        return (BidiMap) super.decorated();
    }

    public MapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    public K getKey(Object obj) {
        return decorated().getKey(obj);
    }

    public K removeValue(Object obj) {
        return decorated().removeValue(obj);
    }

    public BidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }

    public Set<V> values() {
        return decorated().values();
    }
}
