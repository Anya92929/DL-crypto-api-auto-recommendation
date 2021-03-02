package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class IfClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;

    /* renamed from: a */
    private final Predicate<? super E> f6428a;

    /* renamed from: b */
    private final Closure<? super E> f6429b;

    /* renamed from: c */
    private final Closure<? super E> f6430c;

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        return ifClosure(predicate, closure, NOPClosure.nopClosure());
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        } else if (closure != null && closure2 != null) {
            return new IfClosure(predicate, closure, closure2);
        } else {
            throw new IllegalArgumentException("Closures must not be null");
        }
    }

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        this(predicate, closure, NOPClosure.nopClosure());
    }

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> closure, Closure<? super E> closure2) {
        this.f6428a = predicate;
        this.f6429b = closure;
        this.f6430c = closure2;
    }

    public void execute(E e) {
        if (this.f6428a.evaluate(e)) {
            this.f6429b.execute(e);
        } else {
            this.f6430c.execute(e);
        }
    }

    public Predicate<? super E> getPredicate() {
        return this.f6428a;
    }

    public Closure<? super E> getTrueClosure() {
        return this.f6429b;
    }

    public Closure<? super E> getFalseClosure() {
        return this.f6430c;
    }
}
