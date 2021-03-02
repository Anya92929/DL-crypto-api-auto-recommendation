package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;

public class DualTreeBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable, SortedBidiMap<K, V> {
    private static final long serialVersionUID = 721969328361809L;

    /* renamed from: g */
    private final Comparator<? super K> f6338g;

    /* renamed from: h */
    private final Comparator<? super V> f6339h;

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.f6338g = null;
        this.f6339h = null;
    }

    public DualTreeBidiMap(Map<? extends K, ? extends V> map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.f6338g = null;
        this.f6339h = null;
    }

    public DualTreeBidiMap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator), new TreeMap(comparator2));
        this.f6338g = comparator;
        this.f6339h = comparator2;
    }

    protected DualTreeBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        super(map, map2, bidiMap);
        this.f6338g = ((SortedMap) map).comparator();
        this.f6339h = ((SortedMap) map2).comparator();
    }

    /* access modifiers changed from: protected */
    public DualTreeBidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap) {
        return new DualTreeBidiMap<>(map, map2, bidiMap);
    }

    public Comparator<? super K> comparator() {
        return ((SortedMap) this.f6332a).comparator();
    }

    public Comparator<? super V> valueComparator() {
        return ((SortedMap) this.f6333b).comparator();
    }

    public K firstKey() {
        return ((SortedMap) this.f6332a).firstKey();
    }

    public K lastKey() {
        return ((SortedMap) this.f6332a).lastKey();
    }

    public K nextKey(K k) {
        if (isEmpty()) {
            return null;
        }
        if (this.f6332a instanceof OrderedMap) {
            return ((OrderedMap) this.f6332a).nextKey(k);
        }
        Iterator it = ((SortedMap) this.f6332a).tailMap(k).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public K previousKey(K k) {
        if (isEmpty()) {
            return null;
        }
        if (this.f6332a instanceof OrderedMap) {
            return ((OrderedMap) this.f6332a).previousKey(k);
        }
        SortedMap headMap = ((SortedMap) this.f6332a).headMap(k);
        if (headMap.isEmpty()) {
            return null;
        }
        return headMap.lastKey();
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    public SortedBidiMap<V, K> inverseSortedBidiMap() {
        return inverseBidiMap();
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        return inverseBidiMap();
    }

    public SortedMap<K, V> headMap(K k) {
        return new ViewMap(this, ((SortedMap) this.f6332a).headMap(k));
    }

    public SortedMap<K, V> tailMap(K k) {
        return new ViewMap(this, ((SortedMap) this.f6332a).tailMap(k));
    }

    public SortedMap<K, V> subMap(K k, K k2) {
        return new ViewMap(this, ((SortedMap) this.f6332a).subMap(k, k2));
    }

    public SortedBidiMap<V, K> inverseBidiMap() {
        return (SortedBidiMap) super.inverseBidiMap();
    }

    public static class ViewMap<K, V> extends AbstractSortedMapDecorator<K, V> {
        protected ViewMap(DualTreeBidiMap<K, V> dualTreeBidiMap, SortedMap<K, V> sortedMap) {
            super(new DualTreeBidiMap(sortedMap, dualTreeBidiMap.f6333b, dualTreeBidiMap.f6334c));
        }

        public boolean containsValue(Object obj) {
            return decorated().f6332a.containsValue(obj);
        }

        public void clear() {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        public SortedMap<K, V> headMap(K k) {
            return new ViewMap(decorated(), super.headMap(k));
        }

        public SortedMap<K, V> tailMap(K k) {
            return new ViewMap(decorated(), super.tailMap(k));
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return new ViewMap(decorated(), super.subMap(k, k2));
        }

        /* access modifiers changed from: protected */
        public DualTreeBidiMap<K, V> decorated() {
            return (DualTreeBidiMap) super.decorated();
        }

        public K previousKey(K k) {
            return decorated().previousKey(k);
        }

        public K nextKey(K k) {
            return decorated().nextKey(k);
        }
    }

    public static class BidiOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {

        /* renamed from: a */
        private final AbstractDualBidiMap<K, V> f6340a;

        /* renamed from: b */
        private ListIterator<Map.Entry<K, V>> f6341b;

        /* renamed from: c */
        private Map.Entry<K, V> f6342c = null;

        protected BidiOrderedMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.f6340a = abstractDualBidiMap;
            this.f6341b = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        public boolean hasNext() {
            return this.f6341b.hasNext();
        }

        public K next() {
            this.f6342c = this.f6341b.next();
            return this.f6342c.getKey();
        }

        public boolean hasPrevious() {
            return this.f6341b.hasPrevious();
        }

        public K previous() {
            this.f6342c = this.f6341b.previous();
            return this.f6342c.getKey();
        }

        public void remove() {
            this.f6341b.remove();
            this.f6340a.remove(this.f6342c.getKey());
            this.f6342c = null;
        }

        public K getKey() {
            if (this.f6342c != null) {
                return this.f6342c.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            if (this.f6342c != null) {
                return this.f6342c.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            if (this.f6342c == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            } else if (!this.f6340a.f6333b.containsKey(v) || this.f6340a.f6333b.get(v) == this.f6342c.getKey()) {
                V put = this.f6340a.put(this.f6342c.getKey(), v);
                this.f6342c.setValue(v);
                return put;
            } else {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
        }

        public void reset() {
            this.f6341b = new ArrayList(this.f6340a.entrySet()).listIterator();
            this.f6342c = null;
        }

        public String toString() {
            if (this.f6342c != null) {
                return "MapIterator[" + getKey() + "=" + getValue() + "]";
            }
            return "MapIterator[]";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6332a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6332a = new TreeMap(this.f6338g);
        this.f6333b = new TreeMap(this.f6339h);
        putAll((Map) objectInputStream.readObject());
    }
}
