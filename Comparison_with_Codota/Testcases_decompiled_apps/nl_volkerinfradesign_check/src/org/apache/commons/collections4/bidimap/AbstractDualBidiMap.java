package org.apache.commons.collections4.bidimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;

public abstract class AbstractDualBidiMap<K, V> implements BidiMap<K, V> {

    /* renamed from: a */
    transient Map<K, V> f6332a;

    /* renamed from: b */
    transient Map<V, K> f6333b;

    /* renamed from: c */
    transient BidiMap<V, K> f6334c = null;

    /* renamed from: d */
    transient Set<K> f6335d = null;

    /* renamed from: e */
    transient Set<V> f6336e = null;

    /* renamed from: f */
    transient Set<Map.Entry<K, V>> f6337f = null;

    /* access modifiers changed from: protected */
    public abstract BidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap);

    protected AbstractDualBidiMap() {
    }

    protected AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2) {
        this.f6332a = map;
        this.f6333b = map2;
    }

    protected AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        this.f6332a = map;
        this.f6333b = map2;
        this.f6334c = bidiMap;
    }

    public V get(Object obj) {
        return this.f6332a.get(obj);
    }

    public int size() {
        return this.f6332a.size();
    }

    public boolean isEmpty() {
        return this.f6332a.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f6332a.containsKey(obj);
    }

    public boolean equals(Object obj) {
        return this.f6332a.equals(obj);
    }

    public int hashCode() {
        return this.f6332a.hashCode();
    }

    public String toString() {
        return this.f6332a.toString();
    }

    public V put(K k, V v) {
        if (this.f6332a.containsKey(k)) {
            this.f6333b.remove(this.f6332a.get(k));
        }
        if (this.f6333b.containsKey(v)) {
            this.f6332a.remove(this.f6333b.get(v));
        }
        V put = this.f6332a.put(k, v);
        this.f6333b.put(v, k);
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(Object obj) {
        if (!this.f6332a.containsKey(obj)) {
            return null;
        }
        V remove = this.f6332a.remove(obj);
        this.f6333b.remove(remove);
        return remove;
    }

    public void clear() {
        this.f6332a.clear();
        this.f6333b.clear();
    }

    public boolean containsValue(Object obj) {
        return this.f6333b.containsKey(obj);
    }

    public MapIterator<K, V> mapIterator() {
        return new BidiMapIterator(this);
    }

    public K getKey(Object obj) {
        return this.f6333b.get(obj);
    }

    public K removeValue(Object obj) {
        if (!this.f6333b.containsKey(obj)) {
            return null;
        }
        K remove = this.f6333b.remove(obj);
        this.f6332a.remove(remove);
        return remove;
    }

    public BidiMap<V, K> inverseBidiMap() {
        if (this.f6334c == null) {
            this.f6334c = createBidiMap(this.f6333b, this.f6332a, this);
        }
        return this.f6334c;
    }

    public Set<K> keySet() {
        if (this.f6335d == null) {
            this.f6335d = new KeySet(this);
        }
        return this.f6335d;
    }

    /* access modifiers changed from: protected */
    public Iterator<K> createKeySetIterator(Iterator<K> it) {
        return new KeySetIterator(it, this);
    }

    public Set<V> values() {
        if (this.f6336e == null) {
            this.f6336e = new Values(this);
        }
        return this.f6336e;
    }

    /* access modifiers changed from: protected */
    public Iterator<V> createValuesIterator(Iterator<V> it) {
        return new ValuesIterator(it, this);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6337f == null) {
            this.f6337f = new EntrySet(this);
        }
        return this.f6337f;
    }

    /* access modifiers changed from: protected */
    public Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> it) {
        return new EntrySetIterator(it, this);
    }

    public static abstract class View<K, V, E> extends AbstractCollectionDecorator<E> {
        private static final long serialVersionUID = 4621510560119690639L;
        protected final AbstractDualBidiMap<K, V> parent;

        protected View(Collection<E> collection, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(collection);
            this.parent = abstractDualBidiMap;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            if (!this.parent.isEmpty() && !collection.isEmpty()) {
                for (Object remove : collection) {
                    z |= remove(remove);
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean z = false;
            if (this.parent.isEmpty()) {
                return false;
            }
            if (collection.isEmpty()) {
                this.parent.clear();
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public void clear() {
            this.parent.clear();
        }
    }

    public static class KeySet<K> extends View<K, Object, K> implements Set<K> {
        private static final long serialVersionUID = -7107935777385040694L;

        protected KeySet(AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(abstractDualBidiMap.f6332a.keySet(), abstractDualBidiMap);
        }

        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator(super.iterator());
        }

        public boolean contains(Object obj) {
            return this.parent.f6332a.containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!this.parent.f6332a.containsKey(obj)) {
                return false;
            }
            this.parent.f6333b.remove(this.parent.f6332a.remove(obj));
            return true;
        }
    }

    public static class KeySetIterator<K> extends AbstractIteratorDecorator<K> {
        protected boolean canRemove = false;
        protected K lastKey = null;
        protected final AbstractDualBidiMap<K, ?> parent;

        protected KeySetIterator(Iterator<K> it, AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public K next() {
            this.lastKey = super.next();
            this.canRemove = true;
            return this.lastKey;
        }

        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V v = this.parent.f6332a.get(this.lastKey);
            super.remove();
            this.parent.f6333b.remove(v);
            this.lastKey = null;
            this.canRemove = false;
        }
    }

    public static class Values<V> extends View<Object, V, V> implements Set<V> {
        private static final long serialVersionUID = 4023777119829639864L;

        protected Values(AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.f6332a.values(), abstractDualBidiMap);
        }

        public Iterator<V> iterator() {
            return this.parent.createValuesIterator(super.iterator());
        }

        public boolean contains(Object obj) {
            return this.parent.f6333b.containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!this.parent.f6333b.containsKey(obj)) {
                return false;
            }
            this.parent.f6332a.remove(this.parent.f6333b.remove(obj));
            return true;
        }
    }

    public static class ValuesIterator<V> extends AbstractIteratorDecorator<V> {
        protected boolean canRemove = false;
        protected V lastValue = null;
        protected final AbstractDualBidiMap<Object, V> parent;

        protected ValuesIterator(Iterator<V> it, AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public V next() {
            this.lastValue = super.next();
            this.canRemove = true;
            return this.lastValue;
        }

        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            super.remove();
            this.parent.f6333b.remove(this.lastValue);
            this.lastValue = null;
            this.canRemove = false;
        }
    }

    public static class EntrySet<K, V> extends View<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4040410962603292348L;

        protected EntrySet(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.f6332a.entrySet(), abstractDualBidiMap);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator(super.iterator());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (!this.parent.containsKey(key)) {
                return false;
            }
            V v = this.parent.f6332a.get(key);
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            this.parent.f6332a.remove(key);
            this.parent.f6333b.remove(v);
            return true;
        }
    }

    public static class EntrySetIterator<K, V> extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected boolean canRemove = false;
        protected Map.Entry<K, V> last = null;
        protected final AbstractDualBidiMap<K, V> parent;

        protected EntrySetIterator(Iterator<Map.Entry<K, V>> it, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(it);
            this.parent = abstractDualBidiMap;
        }

        public Map.Entry<K, V> next() {
            this.last = new MapEntry((Map.Entry) super.next(), this.parent);
            this.canRemove = true;
            return this.last;
        }

        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V value = this.last.getValue();
            super.remove();
            this.parent.f6333b.remove(value);
            this.last = null;
            this.canRemove = false;
        }
    }

    public static class MapEntry<K, V> extends AbstractMapEntryDecorator<K, V> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected MapEntry(Map.Entry<K, V> entry, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(entry);
            this.parent = abstractDualBidiMap;
        }

        public V setValue(V v) {
            K key = getKey();
            if (!this.parent.f6333b.containsKey(v) || this.parent.f6333b.get(v) == key) {
                this.parent.put(key, v);
                return super.setValue(v);
            }
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
        }
    }

    public static class BidiMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        protected boolean canRemove = false;
        protected Iterator<Map.Entry<K, V>> iterator;
        protected Map.Entry<K, V> last = null;
        protected final AbstractDualBidiMap<K, V> parent;

        protected BidiMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = abstractDualBidiMap.f6332a.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public K next() {
            this.last = this.iterator.next();
            this.canRemove = true;
            return this.last.getKey();
        }

        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            V value = this.last.getValue();
            this.iterator.remove();
            this.parent.f6333b.remove(value);
            this.last = null;
            this.canRemove = false;
        }

        public K getKey() {
            if (this.last != null) {
                return this.last.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            if (this.last != null) {
                return this.last.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            } else if (!this.parent.f6333b.containsKey(v) || this.parent.f6333b.get(v) == this.last.getKey()) {
                return this.parent.put(this.last.getKey(), v);
            } else {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
        }

        public void reset() {
            this.iterator = this.parent.f6332a.entrySet().iterator();
            this.last = null;
            this.canRemove = false;
        }

        public String toString() {
            if (this.last != null) {
                return "MapIterator[" + getKey() + "=" + getValue() + "]";
            }
            return "MapIterator[]";
        }
    }
}
