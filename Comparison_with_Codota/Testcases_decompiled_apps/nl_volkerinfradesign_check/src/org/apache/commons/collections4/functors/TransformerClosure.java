package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

public class TransformerClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -5194992589193388969L;

    /* renamed from: a */
    private final Transformer<? super E, ?> f6462a;

    public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> transformer) {
        if (transformer == null) {
            return NOPClosure.nopClosure();
        }
        return new TransformerClosure(transformer);
    }

    public TransformerClosure(Transformer<? super E, ?> transformer) {
        this.f6462a = transformer;
    }

    public void execute(E e) {
        this.f6462a.transform(e);
    }

    public Transformer<? super E, ?> getTransformer() {
        return this.f6462a;
    }
}
