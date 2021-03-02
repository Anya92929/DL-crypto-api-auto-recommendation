package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NullPredicate<T> implements Serializable, Predicate<T> {
    public static final Predicate INSTANCE = new NullPredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    public static <T> Predicate<T> nullPredicate() {
        return INSTANCE;
    }

    private NullPredicate() {
    }

    public boolean evaluate(T t) {
        return t == null;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
