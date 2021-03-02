package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Bag<E> extends Collection<E> {
    boolean add(E e);

    boolean add(E e, int i);

    boolean containsAll(Collection<?> collection);

    int getCount(Object obj);

    Iterator<E> iterator();

    boolean remove(Object obj);

    boolean remove(Object obj, int i);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int size();

    Set<E> uniqueSet();
}
