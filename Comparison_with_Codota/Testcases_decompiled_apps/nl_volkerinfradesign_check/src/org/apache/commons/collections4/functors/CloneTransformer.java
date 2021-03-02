package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public class CloneTransformer<T> implements Serializable, Transformer<T, T> {
    public static final Transformer INSTANCE = new CloneTransformer();
    private static final long serialVersionUID = -8188742709499652567L;

    public static <T> Transformer<T, T> cloneTransformer() {
        return INSTANCE;
    }

    private CloneTransformer() {
    }

    public T transform(T t) {
        if (t == null) {
            return null;
        }
        return PrototypeFactory.prototypeFactory(t).create();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
