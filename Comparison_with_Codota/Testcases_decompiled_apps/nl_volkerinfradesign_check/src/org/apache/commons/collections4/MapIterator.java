package org.apache.commons.collections4;

import java.util.Iterator;

public interface MapIterator<K, V> extends Iterator<K> {
    K getKey();

    V getValue();

    boolean hasNext();

    K next();

    void remove();

    V setValue(V v);
}
