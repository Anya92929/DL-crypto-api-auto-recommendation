package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NullIsTruePredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -7625133768987126273L;

    /* renamed from: a */
    private final Predicate<? super T> f6446a;

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new NullIsTruePredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public NullIsTruePredicate(Predicate<? super T> predicate) {
        this.f6446a = predicate;
    }

    public boolean evaluate(T t) {
        if (t == null) {
            return true;
        }
        return this.f6446a.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6446a};
    }
}
