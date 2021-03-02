package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

public class ForClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -1190120533393621674L;

    /* renamed from: a */
    private final int f6425a;

    /* renamed from: b */
    private final Closure<? super E> f6426b;

    public static <E> Closure<E> forClosure(int i, Closure<? super E> closure) {
        if (i <= 0 || closure == null) {
            return NOPClosure.nopClosure();
        }
        return i != 1 ? new ForClosure(i, closure) : closure;
    }

    public ForClosure(int i, Closure<? super E> closure) {
        this.f6425a = i;
        this.f6426b = closure;
    }

    public void execute(E e) {
        for (int i = 0; i < this.f6425a; i++) {
            this.f6426b.execute(e);
        }
    }

    public Closure<? super E> getClosure() {
        return this.f6426b;
    }

    public int getCount() {
        return this.f6425a;
    }
}
