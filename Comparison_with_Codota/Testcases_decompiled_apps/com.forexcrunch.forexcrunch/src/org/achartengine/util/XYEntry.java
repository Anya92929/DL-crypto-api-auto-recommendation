package org.achartengine.util;

import java.util.Map;

public class XYEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public XYEntry(K key2, V value2) {
        this.key = key2;
        this.value = value2;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V object) {
        this.value = object;
        return this.value;
    }
}
