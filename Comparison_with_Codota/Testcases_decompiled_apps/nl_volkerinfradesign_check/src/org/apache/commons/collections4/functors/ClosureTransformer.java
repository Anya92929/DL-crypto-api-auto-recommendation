package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

public class ClosureTransformer<T> implements Serializable, Transformer<T, T> {
    private static final long serialVersionUID = 478466901448617286L;

    /* renamed from: a */
    private final Closure<? super T> f6414a;

    public static <T> Transformer<T, T> closureTransformer(Closure<? super T> closure) {
        if (closure != null) {
            return new ClosureTransformer(closure);
        }
        throw new IllegalArgumentException("Closure must not be null");
    }

    public ClosureTransformer(Closure<? super T> closure) {
        this.f6414a = closure;
    }

    public T transform(T t) {
        this.f6414a.execute(t);
        return t;
    }

    public Closure<? super T> getClosure() {
        return this.f6414a;
    }
}
