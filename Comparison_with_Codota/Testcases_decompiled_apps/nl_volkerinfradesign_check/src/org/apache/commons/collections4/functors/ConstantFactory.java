package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;

public class ConstantFactory<T> implements Serializable, Factory<T> {
    public static final Factory NULL_INSTANCE = new ConstantFactory((Object) null);
    private static final long serialVersionUID = -3520677225766901240L;

    /* renamed from: a */
    private final T f6420a;

    public static <T> Factory<T> constantFactory(T t) {
        if (t == null) {
            return NULL_INSTANCE;
        }
        return new ConstantFactory(t);
    }

    public ConstantFactory(T t) {
        this.f6420a = t;
    }

    public T create() {
        return this.f6420a;
    }

    public T getConstant() {
        return this.f6420a;
    }
}
