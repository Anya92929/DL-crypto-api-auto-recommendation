package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapDecorator<K, V> extends AbstractIterableMap<K, V> {

    /* renamed from: a */
    public transient Map<K, V> f6624a;

    public AbstractMapDecorator() {
    }

    public AbstractMapDecorator(Map<K, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        this.f6624a = map;
    }

    public Map<K, V> decorated() {
        return this.f6624a;
    }

    public void clear() {
        decorated().clear();
    }

    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    public V get(Object obj) {
        return decorated().get(obj);
    }

    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public Set<K> keySet() {
        return decorated().keySet();
    }

    public V put(K k, V v) {
        return decorated().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(map);
    }

    public V remove(Object obj) {
        return decorated().remove(obj);
    }

    public int size() {
        return decorated().size();
    }

    public Collection<V> values() {
        return decorated().values();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    public String toString() {
        return decorated().toString();
    }
}
