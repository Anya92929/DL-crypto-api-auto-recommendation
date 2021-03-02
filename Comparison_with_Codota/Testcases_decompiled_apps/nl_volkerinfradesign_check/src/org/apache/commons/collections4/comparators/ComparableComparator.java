package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;

public class ComparableComparator<E extends Comparable<? super E>> implements Serializable, Comparator<E> {
    public static final ComparableComparator INSTANCE = new ComparableComparator();
    private static final long serialVersionUID = -291439688585137865L;

    public static <E extends Comparable<? super E>> ComparableComparator<E> comparableComparator() {
        return INSTANCE;
    }

    public int compare(E e, E e2) {
        return e.compareTo(e2);
    }

    public int hashCode() {
        return "ComparableComparator".hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass().equals(getClass()));
    }
}
