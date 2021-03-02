package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NotPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -2654603322338049674L;

    /* renamed from: a */
    private final Predicate<? super T> f6443a;

    public static <T> Predicate<T> notPredicate(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new NotPredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public NotPredicate(Predicate<? super T> predicate) {
        this.f6443a = predicate;
    }

    public boolean evaluate(T t) {
        return !this.f6443a.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6443a};
    }
}
