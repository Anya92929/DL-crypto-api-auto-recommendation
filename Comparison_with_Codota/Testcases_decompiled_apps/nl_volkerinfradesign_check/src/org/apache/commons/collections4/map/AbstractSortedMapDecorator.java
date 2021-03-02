package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {
    protected AbstractSortedMapDecorator() {
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    public SortedMap<K, V> decorated() {
        return (SortedMap) super.decorated();
    }

    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    public K firstKey() {
        return decorated().firstKey();
    }

    public K lastKey() {
        return decorated().lastKey();
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

    public K previousKey(K k) {
        SortedMap headMap = headMap(k);
        if (headMap.isEmpty()) {
            return null;
        }
        return headMap.lastKey();
    }

    public K nextKey(K k) {
        Iterator it = tailMap(k).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return new SortedMapIterator(entrySet());
    }

    public static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        protected SortedMapIterator(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        public synchronized void reset() {
            super.reset();
            this.f6646b = new ListIteratorWrapper(this.f6646b);
        }

        public boolean hasPrevious() {
            return ((ListIterator) this.f6646b).hasPrevious();
        }

        public K previous() {
            this.f6647c = (Map.Entry) ((ListIterator) this.f6646b).previous();
            return getKey();
        }
    }
}
