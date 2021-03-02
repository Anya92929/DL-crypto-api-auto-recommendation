package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import org.apache.commons.collections4.KeyValue;

public abstract class AbstractMapEntryDecorator<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {

    /* renamed from: a */
    private final Map.Entry<K, V> f6564a;

    public AbstractMapEntryDecorator(Map.Entry<K, V> entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Map Entry must not be null");
        }
        this.f6564a = entry;
    }

    public Map.Entry<K, V> getMapEntry() {
        return this.f6564a;
    }

    public K getKey() {
        return this.f6564a.getKey();
    }

    public V getValue() {
        return this.f6564a.getValue();
    }

    public V setValue(V v) {
        return this.f6564a.setValue(v);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.f6564a.equals(obj);
    }

    public int hashCode() {
        return this.f6564a.hashCode();
    }

    public String toString() {
        return this.f6564a.toString();
    }
}
