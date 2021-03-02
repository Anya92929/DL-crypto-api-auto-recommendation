package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class SplitMapUtils {
    private SplitMapUtils() {
    }

    /* renamed from: org.apache.commons.collections4.SplitMapUtils$a */
    static class C1842a<K, V> implements IterableMap<K, V>, Unmodifiable {

        /* renamed from: a */
        private final Get<K, V> f6319a;

        private C1842a(Get<K, V> get) {
            this.f6319a = get;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object obj) {
            return this.f6319a.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.f6319a.containsValue(obj);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return UnmodifiableEntrySet.unmodifiableEntrySet(this.f6319a.entrySet());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1842a) || !((C1842a) obj).f6319a.equals(this.f6319a)) {
                return false;
            }
            return true;
        }

        public V get(Object obj) {
            return this.f6319a.get(obj);
        }

        public int hashCode() {
            return ("WrappedGet".hashCode() << 4) | this.f6319a.hashCode();
        }

        public boolean isEmpty() {
            return this.f6319a.isEmpty();
        }

        public Set<K> keySet() {
            return UnmodifiableSet.unmodifiableSet(this.f6319a.keySet());
        }

        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        public V remove(Object obj) {
            return this.f6319a.remove(obj);
        }

        public int size() {
            return this.f6319a.size();
        }

        public Collection<V> values() {
            return UnmodifiableCollection.unmodifiableCollection(this.f6319a.values());
        }

        public MapIterator<K, V> mapIterator() {
            MapIterator entrySetToMapIteratorAdapter;
            if (this.f6319a instanceof IterableGet) {
                entrySetToMapIteratorAdapter = ((IterableGet) this.f6319a).mapIterator();
            } else {
                entrySetToMapIteratorAdapter = new EntrySetToMapIteratorAdapter(this.f6319a.entrySet());
            }
            return UnmodifiableMapIterator.unmodifiableMapIterator(entrySetToMapIteratorAdapter);
        }
    }

    /* renamed from: org.apache.commons.collections4.SplitMapUtils$b */
    static class C1843b<K, V> implements Map<K, V>, Put<K, V> {

        /* renamed from: a */
        private final Put<K, V> f6320a;

        private C1843b(Put<K, V> put) {
            this.f6320a = put;
        }

        public void clear() {
            this.f6320a.clear();
        }

        public boolean containsKey(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean containsValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1843b) || !((C1843b) obj).f6320a.equals(this.f6320a)) {
                return false;
            }
            return true;
        }

        public V get(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int hashCode() {
            return ("WrappedPut".hashCode() << 4) | this.f6320a.hashCode();
        }

        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        public Set<K> keySet() {
            throw new UnsupportedOperationException();
        }

        public V put(K k, V v) {
            return this.f6320a.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.f6320a.putAll(map);
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            throw new UnsupportedOperationException();
        }

        public Collection<V> values() {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> IterableMap<K, V> readableMap(Get<K, V> get) {
        if (get == null) {
            throw new IllegalArgumentException("Get must not be null");
        } else if (get instanceof Map) {
            return get instanceof IterableMap ? (IterableMap) get : MapUtils.iterableMap((Map) get);
        } else {
            return new C1842a(get);
        }
    }

    public static <K, V> Map<K, V> writableMap(Put<K, V> put) {
        if (put == null) {
            throw new IllegalArgumentException("Put must not be null");
        } else if (put instanceof Map) {
            return (Map) put;
        } else {
            return new C1843b(put);
        }
    }
}
