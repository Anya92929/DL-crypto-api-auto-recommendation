package org.apache.commons.collections4;

import java.util.Collection;

public interface MultiMap<K, V> extends IterableMap<K, Object> {
    boolean containsValue(Object obj);

    Object get(Object obj);

    Object put(K k, Object obj);

    Object remove(Object obj);

    boolean removeMapping(K k, V v);

    int size();

    Collection<Object> values();
}
