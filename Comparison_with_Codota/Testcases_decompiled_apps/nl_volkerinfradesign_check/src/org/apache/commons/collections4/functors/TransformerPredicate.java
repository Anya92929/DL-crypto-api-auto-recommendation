package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public final class TransformerPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -2407966402920578741L;

    /* renamed from: a */
    private final Transformer<? super T, Boolean> f6463a;

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        if (transformer != null) {
            return new TransformerPredicate(transformer);
        }
        throw new IllegalArgumentException("The transformer to call must not be null");
    }

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.f6463a = transformer;
    }

    public boolean evaluate(T t) {
        Boolean transform = this.f6463a.transform(t);
        if (transform != null) {
            return transform.booleanValue();
        }
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.f6463a;
    }
}
