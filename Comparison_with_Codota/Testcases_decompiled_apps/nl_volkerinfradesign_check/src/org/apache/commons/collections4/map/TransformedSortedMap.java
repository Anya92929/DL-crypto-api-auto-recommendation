package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedMap<K, V> extends TransformedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = -8751771676410385778L;

    public static <K, V> TransformedSortedMap<K, V> transformingSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedSortedMap<>(sortedMap, transformer, transformer2);
    }

    public static <K, V> TransformedSortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedSortedMap<K, V> transformedSortedMap = new TransformedSortedMap<>(sortedMap, transformer, transformer2);
        if (sortedMap.size() > 0) {
            Map<K, V> transformMap = transformedSortedMap.transformMap(sortedMap);
            transformedSortedMap.clear();
            transformedSortedMap.decorated().putAll(transformMap);
        }
        return transformedSortedMap;
    }

    protected TransformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(sortedMap, transformer, transformer2);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> getSortedMap() {
        return (SortedMap) this.f6624a;
    }

    public K firstKey() {
        return getSortedMap().firstKey();
    }

    public K lastKey() {
        return getSortedMap().lastKey();
    }

    public Comparator<? super K> comparator() {
        return getSortedMap().comparator();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return new TransformedSortedMap(getSortedMap().subMap(k, k2), this.keyTransformer, this.valueTransformer);
    }

    public SortedMap<K, V> headMap(K k) {
        return new TransformedSortedMap(getSortedMap().headMap(k), this.keyTransformer, this.valueTransformer);
    }

    public SortedMap<K, V> tailMap(K k) {
        return new TransformedSortedMap(getSortedMap().tailMap(k), this.keyTransformer, this.valueTransformer);
    }
}
