package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;

public class FuzzyKeyMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final MemoryCacheAware<K, V> cache;
    private final Comparator<K> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> cache2, Comparator<K> keyComparator2) {
        this.cache = cache2;
        this.keyComparator = keyComparator2;
    }

    public synchronized boolean put(K key, V value) {
        K keyToRemove = null;
        for (K cacheKey : this.cache.keys()) {
            if (this.keyComparator.compare(key, cacheKey) == 0) {
                keyToRemove = cacheKey;
            }
        }
        this.cache.remove(keyToRemove);
        return this.cache.put(key, value);
    }

    public synchronized V get(K key) {
        return this.cache.get(key);
    }

    public synchronized void remove(K key) {
        this.cache.remove(key);
    }

    public synchronized void clear() {
        this.cache.clear();
    }

    public synchronized Collection<K> keys() {
        return this.cache.keys();
    }
}
