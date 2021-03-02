package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap<K, V> implements Serializable, Cloneable, BoundedMap<K, V>, KeyValue<K, V>, OrderedMap<K, V> {
    private static final long serialVersionUID = -8931271118676803261L;

    /* renamed from: a */
    private final K f6706a;

    /* renamed from: b */
    private V f6707b;

    public SingletonMap() {
        this.f6706a = null;
    }

    public SingletonMap(K k, V v) {
        this.f6706a = k;
        this.f6707b = v;
    }

    public SingletonMap(KeyValue<K, V> keyValue) {
        this.f6706a = keyValue.getKey();
        this.f6707b = keyValue.getValue();
    }

    public SingletonMap(Map.Entry<? extends K, ? extends V> entry) {
        this.f6706a = entry.getKey();
        this.f6707b = entry.getValue();
    }

    public SingletonMap(Map<? extends K, ? extends V> map) {
        if (map.size() != 1) {
            throw new IllegalArgumentException("The map size must be 1");
        }
        Map.Entry next = map.entrySet().iterator().next();
        this.f6706a = next.getKey();
        this.f6707b = next.getValue();
    }

    public K getKey() {
        return this.f6706a;
    }

    public V getValue() {
        return this.f6707b;
    }

    public V setValue(V v) {
        V v2 = this.f6707b;
        this.f6707b = v;
        return v2;
    }

    public boolean isFull() {
        return true;
    }

    public int maxSize() {
        return 1;
    }

    public V get(Object obj) {
        if (isEqualKey(obj)) {
            return this.f6707b;
        }
        return null;
    }

    public int size() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    public V put(K k, V v) {
        if (isEqualKey(k)) {
            return setValue(v);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        switch (map.size()) {
            case 0:
                return;
            case 1:
                Map.Entry next = map.entrySet().iterator().next();
                put(next.getKey(), next.getValue());
                return;
            default:
                throw new IllegalArgumentException("The map size must be 0 or 1");
        }
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    public Set<K> keySet() {
        return Collections.singleton(this.f6706a);
    }

    public Collection<V> values() {
        return new C1907b(this);
    }

    public OrderedMapIterator<K, V> mapIterator() {
        return new C1906a(this);
    }

    public K firstKey() {
        return getKey();
    }

    public K lastKey() {
        return getKey();
    }

    public K nextKey(K k) {
        return null;
    }

    public K previousKey(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj) {
        if (obj == null) {
            return getKey() == null;
        }
        return obj.equals(getKey());
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj) {
        if (obj == null) {
            return getValue() == null;
        }
        return obj.equals(getValue());
    }

    /* renamed from: org.apache.commons.collections4.map.SingletonMap$a */
    static class C1906a<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {

        /* renamed from: a */
        private final SingletonMap<K, V> f6708a;

        /* renamed from: b */
        private boolean f6709b = true;

        /* renamed from: c */
        private boolean f6710c = false;

        C1906a(SingletonMap<K, V> singletonMap) {
            this.f6708a = singletonMap;
        }

        public boolean hasNext() {
            return this.f6709b;
        }

        public K next() {
            if (!this.f6709b) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.f6709b = false;
            this.f6710c = true;
            return this.f6708a.getKey();
        }

        public boolean hasPrevious() {
            return !this.f6709b;
        }

        public K previous() {
            if (this.f6709b) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.f6709b = true;
            return this.f6708a.getKey();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            if (this.f6710c) {
                return this.f6708a.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public V getValue() {
            if (this.f6710c) {
                return this.f6708a.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public V setValue(V v) {
            if (this.f6710c) {
                return this.f6708a.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public void reset() {
            this.f6709b = true;
        }

        public String toString() {
            if (this.f6709b) {
                return "Iterator[]";
            }
            return "Iterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    /* renamed from: org.apache.commons.collections4.map.SingletonMap$b */
    static class C1907b<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;

        /* renamed from: a */
        private final SingletonMap<?, V> f6711a;

        C1907b(SingletonMap<?, V> singletonMap) {
            this.f6711a = singletonMap;
        }

        public int size() {
            return 1;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object obj) {
            return this.f6711a.containsValue(obj);
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Iterator<V> iterator() {
            return new SingletonIterator(this.f6711a.getValue(), false);
        }
    }

    public SingletonMap<K, V> clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        return isEqualKey(entry.getKey()) && isEqualValue(entry.getValue());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return new StringBuilder(128).append('{').append(getKey() == this ? "(this Map)" : getKey()).append('=').append(getValue() == this ? "(this Map)" : getValue()).append('}').toString();
    }
}
