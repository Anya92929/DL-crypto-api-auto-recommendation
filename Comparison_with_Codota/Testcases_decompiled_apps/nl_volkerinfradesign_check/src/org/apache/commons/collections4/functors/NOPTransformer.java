package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public class NOPTransformer<T> implements Serializable, Transformer<T, T> {
    public static final Transformer INSTANCE = new NOPTransformer();
    private static final long serialVersionUID = 2133891748318574490L;

    public static <T> Transformer<T, T> nopTransformer() {
        return INSTANCE;
    }

    private NOPTransformer() {
    }

    public T transform(T t) {
        return t;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
