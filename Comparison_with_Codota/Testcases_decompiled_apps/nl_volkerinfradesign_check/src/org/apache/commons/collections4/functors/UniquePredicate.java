package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

public final class UniquePredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -3319417438027438040L;

    /* renamed from: a */
    private final Set<T> f6464a = new HashSet();

    public static <T> Predicate<T> uniquePredicate() {
        return new UniquePredicate();
    }

    public boolean evaluate(T t) {
        return this.f6464a.add(t);
    }
}
