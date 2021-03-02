package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class InstanceofPredicate implements Serializable, Predicate<Object> {
    private static final long serialVersionUID = -6682656911025165584L;

    /* renamed from: a */
    private final Class<?> f6431a;

    public static Predicate<Object> instanceOfPredicate(Class<?> cls) {
        if (cls != null) {
            return new InstanceofPredicate(cls);
        }
        throw new IllegalArgumentException("The type to check instanceof must not be null");
    }

    public InstanceofPredicate(Class<?> cls) {
        this.f6431a = cls;
    }

    public boolean evaluate(Object obj) {
        return this.f6431a.isInstance(obj);
    }

    public Class<?> getType() {
        return this.f6431a;
    }
}
