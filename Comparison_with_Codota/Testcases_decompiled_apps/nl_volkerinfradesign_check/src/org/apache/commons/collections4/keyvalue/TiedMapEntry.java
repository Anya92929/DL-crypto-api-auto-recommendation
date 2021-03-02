package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.KeyValue;

public class TiedMapEntry<K, V> implements Serializable, Map.Entry<K, V>, KeyValue<K, V> {
    private static final long serialVersionUID = -8453869361373831205L;

    /* renamed from: a */
    private final Map<K, V> f6567a;

    /* renamed from: b */
    private final K f6568b;

    public TiedMapEntry(Map<K, V> map, K k) {
        this.f6567a = map;
        this.f6568b = k;
    }

    public K getKey() {
        return this.f6568b;
    }

    public V getValue() {
        return this.f6567a.get(this.f6568b);
    }

    public V setValue(V v) {
        if (v != this) {
            return this.f6567a.put(this.f6568b, v);
        }
        throw new IllegalArgumentException("Cannot set value to this map entry");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object value = getValue();
        if (this.f6568b == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f6568b.equals(entry.getKey())) {
            return false;
        }
        if (value == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!value.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        Object value = getValue();
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
