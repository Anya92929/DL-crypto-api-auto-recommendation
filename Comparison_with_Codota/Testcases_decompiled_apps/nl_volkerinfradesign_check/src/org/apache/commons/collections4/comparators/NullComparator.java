package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

public class NullComparator<E> implements Serializable, Comparator<E> {
    private static final long serialVersionUID = -5820772575483504339L;

    /* renamed from: a */
    private final Comparator<? super E> f6405a;

    /* renamed from: b */
    private final boolean f6406b;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    public NullComparator(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z) {
        this(ComparatorUtils.NATURAL_COMPARATOR, z);
    }

    public NullComparator(Comparator<? super E> comparator, boolean z) {
        this.f6405a = comparator;
        this.f6406b = z;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }

    public int compare(E e, E e2) {
        int i = -1;
        if (e == e2) {
            return 0;
        }
        if (e == null) {
            if (!this.f6406b) {
                return -1;
            }
            return 1;
        } else if (e2 != null) {
            return this.f6405a.compare(e, e2);
        } else {
            if (!this.f6406b) {
                i = 1;
            }
            return i;
        }
    }

    public int hashCode() {
        return (this.f6406b ? -1 : 1) * this.f6405a.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        if (this.f6406b != nullComparator.f6406b || !this.f6405a.equals(nullComparator.f6405a)) {
            z = false;
        }
        return z;
    }
}
