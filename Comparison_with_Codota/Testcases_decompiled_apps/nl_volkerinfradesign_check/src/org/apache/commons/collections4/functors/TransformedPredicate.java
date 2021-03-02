package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public final class TransformedPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -5596090919668315834L;

    /* renamed from: a */
    private final Transformer<? super T, ? extends T> f6460a;

    /* renamed from: b */
    private final Predicate<? super T> f6461b;

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        if (transformer == null) {
            throw new IllegalArgumentException("The transformer to call must not be null");
        } else if (predicate != null) {
            return new TransformedPredicate(transformer, predicate);
        } else {
            throw new IllegalArgumentException("The predicate to call must not be null");
        }
    }

    public TransformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        this.f6460a = transformer;
        this.f6461b = predicate;
    }

    public boolean evaluate(T t) {
        return this.f6461b.evaluate(this.f6460a.transform(t));
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.f6461b};
    }

    public Transformer<? super T, ? extends T> getTransformer() {
        return this.f6460a;
    }
}
