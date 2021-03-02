package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

public interface SortedBidiMap<K, V> extends SortedMap<K, V>, OrderedBidiMap<K, V> {
    SortedBidiMap<V, K> inverseBidiMap();

    Comparator<? super V> valueComparator();
}
