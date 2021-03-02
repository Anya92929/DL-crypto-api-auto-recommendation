package org.apache.commons.collections4.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.SortedBidiMap;

public abstract class AbstractSortedBidiMapDecorator<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements SortedBidiMap<K, V> {
    public AbstractSortedBidiMapDecorator(SortedBidiMap<K, V> sortedBidiMap) {
        super(sortedBidiMap);
    }

    /* access modifiers changed from: protected */
    public SortedBidiMap<K, V> decorated() {
        return (SortedBidiMap) super.decorated();
    }

    public SortedBidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }

    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    public Comparator<? super V> valueComparator() {
        return decorated().valueComparator();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return decorated().subMap(k, k2);
    }

    public SortedMap<K, V> headMap(K k) {
        return decorated().headMap(k);
    }

    public SortedMap<K, V> tailMap(K k) {
        return decorated().tailMap(k);
    }
}
