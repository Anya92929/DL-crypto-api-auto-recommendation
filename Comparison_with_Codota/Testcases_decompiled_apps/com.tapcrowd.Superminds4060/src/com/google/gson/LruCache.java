package com.google.gson;

import java.util.LinkedHashMap;
import java.util.Map;

final class LruCache<K, V> extends LinkedHashMap<K, V> implements Cache<K, V> {
    private static final long serialVersionUID = 1;
    private final int maxCapacity;

    LruCache(int maxCapacity2) {
        super(maxCapacity2, 0.7f, true);
        this.maxCapacity = maxCapacity2;
    }

    public void addElement(K key, V value) {
        put(key, value);
    }

    public void clear() {
        super.clear();
    }

    public V getElement(K key) {
        return get(key);
    }

    public V removeElement(K key) {
        return remove(key);
    }

    public int size() {
        return super.size();
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxCapacity;
    }
}
