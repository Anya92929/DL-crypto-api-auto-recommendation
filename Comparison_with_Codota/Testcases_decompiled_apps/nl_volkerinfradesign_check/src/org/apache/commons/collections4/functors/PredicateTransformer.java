package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class PredicateTransformer<T> implements Serializable, Transformer<T, Boolean> {
    private static final long serialVersionUID = 5278818408044349346L;

    /* renamed from: a */
    private final Predicate<? super T> f6449a;

    public static <T> Transformer<T, Boolean> predicateTransformer(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new PredicateTransformer(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public PredicateTransformer(Predicate<? super T> predicate) {
        this.f6449a = predicate;
    }

    public Boolean transform(T t) {
        return Boolean.valueOf(this.f6449a.evaluate(t));
    }

    public Predicate<? super T> getPredicate() {
        return this.f6449a;
    }
}
