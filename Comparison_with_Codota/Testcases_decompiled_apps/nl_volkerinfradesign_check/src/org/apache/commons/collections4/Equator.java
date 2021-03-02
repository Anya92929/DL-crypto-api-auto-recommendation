package org.apache.commons.collections4;

public interface Equator<T> {
    boolean equate(T t, T t2);

    int hash(T t);
}
