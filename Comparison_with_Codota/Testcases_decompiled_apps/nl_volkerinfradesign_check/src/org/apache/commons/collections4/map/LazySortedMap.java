package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

public class LazySortedMap<K, V> extends LazyMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 2715322183617658933L;

    public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return new LazySortedMap<>(sortedMap, factory);
    }

    public static <K, V> LazySortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return new LazySortedMap<>(sortedMap, transformer);
    }

    protected LazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        super(sortedMap, factory);
    }

    protected LazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        super(sortedMap, transformer);
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
        return new LazySortedMap(getSortedMap().subMap(k, k2), this.factory);
    }

    public SortedMap<K, V> headMap(K k) {
        return new LazySortedMap(getSortedMap().headMap(k), this.factory);
    }

    public SortedMap<K, V> tailMap(K k) {
        return new LazySortedMap(getSortedMap().tailMap(k), this.factory);
    }
}
