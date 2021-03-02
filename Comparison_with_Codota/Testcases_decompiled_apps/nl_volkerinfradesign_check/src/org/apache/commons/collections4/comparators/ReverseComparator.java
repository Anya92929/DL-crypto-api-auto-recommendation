package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

public class ReverseComparator<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = 2858887242028539265L;

    /* renamed from: a */
    private final Comparator<E> f6407a;

    public ReverseComparator() {
        this((Comparator) null);
    }

    public ReverseComparator(Comparator<? super E> comparator) {
        this.f6407a = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
    }

    public int compare(E e, E e2) {
        return this.f6407a.compare(e2, e);
    }

    public int hashCode() {
        return "ReverseComparator".hashCode() ^ this.f6407a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return this.f6407a.equals(((ReverseComparator) obj).f6407a);
    }
}
