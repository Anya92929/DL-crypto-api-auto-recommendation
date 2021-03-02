package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class IdentityPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -89901658494523293L;

    /* renamed from: a */
    private final T f6427a;

    public static <T> Predicate<T> identityPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new IdentityPredicate(t);
    }

    public IdentityPredicate(T t) {
        this.f6427a = t;
    }

    public boolean evaluate(T t) {
        return this.f6427a == t;
    }

    public T getValue() {
        return this.f6427a;
    }
}
