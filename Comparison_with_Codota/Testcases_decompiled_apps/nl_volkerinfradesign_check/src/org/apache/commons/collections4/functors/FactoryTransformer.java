package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

public class FactoryTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = -6817674502475353160L;

    /* renamed from: a */
    private final Factory<? extends O> f6424a;

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> factory) {
        if (factory != null) {
            return new FactoryTransformer(factory);
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public FactoryTransformer(Factory<? extends O> factory) {
        this.f6424a = factory;
    }

    public O transform(I i) {
        return this.f6424a.create();
    }

    public Factory<? extends O> getFactory() {
        return this.f6424a;
    }
}
