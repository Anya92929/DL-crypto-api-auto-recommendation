package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public final class ExceptionTransformer<I, O> implements Serializable, Transformer<I, O> {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return INSTANCE;
    }

    private ExceptionTransformer() {
    }

    public O transform(I i) {
        throw new FunctorException("ExceptionTransformer invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
