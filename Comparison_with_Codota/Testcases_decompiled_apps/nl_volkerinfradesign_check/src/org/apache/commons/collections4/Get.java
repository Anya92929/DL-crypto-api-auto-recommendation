package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Get<K, V> {
    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Set<Map.Entry<K, V>> entrySet();

    V get(Object obj);

    boolean isEmpty();

    Set<K> keySet();

    V remove(Object obj);

    int size();

    Collection<V> values();
}
