package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

public class UnmodifiableTrie<K, V> implements Serializable, Trie<K, V>, Unmodifiable {
    private static final long serialVersionUID = -7156426030315945159L;

    /* renamed from: a */
    private final Trie<K, V> f6818a;

    public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> trie) {
        return trie instanceof Unmodifiable ? trie : new UnmodifiableTrie(trie);
    }

    public UnmodifiableTrie(Trie<K, ? extends V> trie) {
        if (trie == null) {
            throw new IllegalArgumentException("Trie must not be null");
        }
        this.f6818a = trie;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.f6818a.entrySet());
    }

    public Set<K> keySet() {
        return Collections.unmodifiableSet(this.f6818a.keySet());
    }

    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.f6818a.values());
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return this.f6818a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f6818a.containsValue(obj);
    }

    public V get(Object obj) {
        return this.f6818a.get(obj);
    }

    public boolean isEmpty() {
        return this.f6818a.isEmpty();
    }

    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f6818a.size();
    }

    public K firstKey() {
        return this.f6818a.firstKey();
    }

    public SortedMap<K, V> headMap(K k) {
        return Collections.unmodifiableSortedMap(this.f6818a.headMap(k));
    }

    public K lastKey() {
        return this.f6818a.lastKey();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return Collections.unmodifiableSortedMap(this.f6818a.subMap(k, k2));
    }

    public SortedMap<K, V> tailMap(K k) {
        return Collections.unmodifiableSortedMap(this.f6818a.tailMap(k));
    }

    public SortedMap<K, V> prefixMap(K k) {
        return Collections.unmodifiableSortedMap(this.f6818a.prefixMap(k));
    }

    public Comparator<? super K> comparator() {
        return this.f6818a.comparator();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(this.f6818a.mapIterator());
    }

    public K nextKey(K k) {
        return this.f6818a.nextKey(k);
    }

    public K previousKey(K k) {
        return this.f6818a.previousKey(k);
    }

    public int hashCode() {
        return this.f6818a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f6818a.equals(obj);
    }

    public String toString() {
        return this.f6818a.toString();
    }
}
