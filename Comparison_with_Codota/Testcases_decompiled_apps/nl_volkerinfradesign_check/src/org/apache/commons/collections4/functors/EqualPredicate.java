package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

public final class EqualPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = 5633766978029907089L;

    /* renamed from: a */
    private final T f6422a;

    /* renamed from: b */
    private final Equator<T> f6423b;

    public static <T> Predicate<T> equalPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t);
    }

    public static <T> Predicate<T> equalPredicate(T t, Equator<T> equator) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t, equator);
    }

    public EqualPredicate(T t) {
        this(t, (Equator) null);
    }

    public EqualPredicate(T t, Equator<T> equator) {
        this.f6422a = t;
        this.f6423b = equator;
    }

    public boolean evaluate(T t) {
        if (this.f6423b != null) {
            return this.f6423b.equate(this.f6422a, t);
        }
        return this.f6422a.equals(t);
    }

    public Object getValue() {
        return this.f6422a;
    }
}
