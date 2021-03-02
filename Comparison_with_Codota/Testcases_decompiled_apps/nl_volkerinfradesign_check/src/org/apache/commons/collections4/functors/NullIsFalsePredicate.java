package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NullIsFalsePredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -2997501534564735525L;

    /* renamed from: a */
    private final Predicate<? super T> f6445a;

    public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new NullIsFalsePredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public NullIsFalsePredicate(Predicate<? super T> predicate) {
        this.f6445a = predicate;
    }

    public boolean evaluate(T t) {
        if (t == null) {
            return false;
        }
        return this.f6445a.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6445a};
    }
}
