package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class OrPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -8791518325735182855L;

    /* renamed from: a */
    private final Predicate<? super T> f6447a;

    /* renamed from: b */
    private final Predicate<? super T> f6448b;

    public static <T> Predicate<T> orPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        if (predicate != null && predicate2 != null) {
            return new OrPredicate(predicate, predicate2);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public OrPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        this.f6447a = predicate;
        this.f6448b = predicate2;
    }

    public boolean evaluate(T t) {
        return this.f6447a.evaluate(t) || this.f6448b.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6447a, this.f6448b};
    }
}
