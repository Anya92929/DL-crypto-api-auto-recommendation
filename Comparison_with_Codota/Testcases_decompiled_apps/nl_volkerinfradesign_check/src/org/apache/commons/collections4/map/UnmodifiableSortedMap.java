package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableSortedMap<K, V> extends AbstractSortedMapDecorator<K, V> implements Serializable, Unmodifiable {
    private static final long serialVersionUID = 5805344239827376360L;

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return sortedMap instanceof Unmodifiable ? sortedMap : new UnmodifiableSortedMap(sortedMap);
    }

    private UnmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        super(sortedMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    public void clear() {
        throw new UnsupportedOperationException();
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

    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
    }

    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(super.keySet());
    }

    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(super.values());
    }

    public K firstKey() {
        return decorated().firstKey();
    }

    public K lastKey() {
        return decorated().lastKey();
    }

    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return new UnmodifiableSortedMap(decorated().subMap(k, k2));
    }

    public SortedMap<K, V> headMap(K k) {
        return new UnmodifiableSortedMap(decorated().headMap(k));
    }

    public SortedMap<K, V> tailMap(K k) {
        return new UnmodifiableSortedMap(decorated().tailMap(k));
    }
}
