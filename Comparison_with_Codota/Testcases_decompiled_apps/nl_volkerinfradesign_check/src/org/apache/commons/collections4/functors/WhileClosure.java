package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class WhileClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -3110538116913760108L;

    /* renamed from: a */
    private final Predicate<? super E> f6465a;

    /* renamed from: b */
    private final Closure<? super E> f6466b;

    /* renamed from: c */
    private final boolean f6467c;

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        } else if (closure != null) {
            return new WhileClosure(predicate, closure, z);
        } else {
            throw new IllegalArgumentException("Closure must not be null");
        }
    }

    public WhileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        this.f6465a = predicate;
        this.f6466b = closure;
        this.f6467c = z;
    }

    public void execute(E e) {
        if (this.f6467c) {
            this.f6466b.execute(e);
        }
        while (this.f6465a.evaluate(e)) {
            this.f6466b.execute(e);
        }
    }

    public Predicate<? super E> getPredicate() {
        return this.f6465a;
    }

    public Closure<? super E> getClosure() {
        return this.f6466b;
    }

    public boolean isDoLoop() {
        return this.f6467c;
    }
}
