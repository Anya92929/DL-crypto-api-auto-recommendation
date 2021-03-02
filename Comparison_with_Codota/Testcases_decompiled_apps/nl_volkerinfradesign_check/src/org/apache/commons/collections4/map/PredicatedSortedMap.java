package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Predicate;

public class PredicatedSortedMap<K, V> extends PredicatedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 3359846175935304332L;

    public static <K, V> PredicatedSortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return new PredicatedSortedMap<>(sortedMap, predicate, predicate2);
    }

    protected PredicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        super(sortedMap, predicate, predicate2);
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
        return new PredicatedSortedMap(getSortedMap().subMap(k, k2), this.keyPredicate, this.valuePredicate);
    }

    public SortedMap<K, V> headMap(K k) {
        return new PredicatedSortedMap(getSortedMap().headMap(k), this.keyPredicate, this.valuePredicate);
    }

    public SortedMap<K, V> tailMap(K k) {
        return new PredicatedSortedMap(getSortedMap().tailMap(k), this.keyPredicate, this.valuePredicate);
    }
}
