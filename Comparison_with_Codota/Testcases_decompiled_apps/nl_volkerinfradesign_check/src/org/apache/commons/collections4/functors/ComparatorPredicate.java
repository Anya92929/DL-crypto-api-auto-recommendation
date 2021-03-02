package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.Predicate;

public class ComparatorPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -1863209236504077399L;

    /* renamed from: a */
    private final T f6415a;

    /* renamed from: b */
    private final Comparator<T> f6416b;

    /* renamed from: c */
    private final Criterion f6417c;

    public enum Criterion {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator) {
        return comparatorPredicate(t, comparator, Criterion.EQUAL);
    }

    public static <T> Predicate<T> comparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator must not be null.");
        } else if (criterion != null) {
            return new ComparatorPredicate(t, comparator, criterion);
        } else {
            throw new IllegalArgumentException("Criterion must not be null.");
        }
    }

    public ComparatorPredicate(T t, Comparator<T> comparator, Criterion criterion) {
        this.f6415a = t;
        this.f6416b = comparator;
        this.f6417c = criterion;
    }

    public boolean evaluate(T t) {
        int compare = this.f6416b.compare(this.f6415a, t);
        switch (this.f6417c) {
            case EQUAL:
                if (compare == 0) {
                    return true;
                }
                return false;
            case GREATER:
                if (compare <= 0) {
                    return false;
                }
                return true;
            case LESS:
                if (compare >= 0) {
                    return false;
                }
                return true;
            case GREATER_OR_EQUAL:
                if (compare < 0) {
                    return false;
                }
                return true;
            case LESS_OR_EQUAL:
                if (compare > 0) {
                    return false;
                }
                return true;
            default:
                throw new IllegalStateException("The current criterion '" + this.f6417c + "' is invalid.");
        }
    }
}
