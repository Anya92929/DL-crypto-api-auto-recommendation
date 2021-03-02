package org.apache.commons.collections4;

import java.util.Set;

public interface BidiMap<K, V> extends IterableMap<K, V> {
    K getKey(Object obj);

    BidiMap<V, K> inverseBidiMap();

    V put(K k, V v);

    K removeValue(Object obj);

    Set<V> values();
}
