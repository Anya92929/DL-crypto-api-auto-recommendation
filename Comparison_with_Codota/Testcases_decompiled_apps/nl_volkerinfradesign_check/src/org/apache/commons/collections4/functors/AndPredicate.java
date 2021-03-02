package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class AndPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = 4189014213763186912L;

    /* renamed from: a */
    private final Predicate<? super T> f6410a;

    /* renamed from: b */
    private final Predicate<? super T> f6411b;

    public static <T> Predicate<T> andPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        if (predicate != null && predicate2 != null) {
            return new AndPredicate(predicate, predicate2);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public AndPredicate(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        this.f6410a = predicate;
        this.f6411b = predicate2;
    }

    public boolean evaluate(T t) {
        return this.f6410a.evaluate(t) && this.f6411b.evaluate(t);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6410a, this.f6411b};
    }
}
