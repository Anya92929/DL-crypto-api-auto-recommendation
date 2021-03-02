package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections4.Closure;

public class ChainedClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -3520677225766901240L;

    /* renamed from: a */
    private final Closure<? super E>[] f6412a;

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        C1320jj.m5717b((Closure<?>[]) closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.nopClosure();
        }
        return new ChainedClosure(closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<Closure<E>> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Closure collection must not be null");
        } else if (collection.size() == 0) {
            return NOPClosure.nopClosure();
        } else {
            Closure[] closureArr = new Closure[collection.size()];
            int i = 0;
            for (Closure<E> closure : collection) {
                closureArr[i] = closure;
                i++;
            }
            C1320jj.m5717b((Closure<?>[]) closureArr);
            return new ChainedClosure(false, closureArr);
        }
    }

    private ChainedClosure(boolean z, Closure<? super E>... closureArr) {
        this.f6412a = z ? C1320jj.m5713a(closureArr) : closureArr;
    }

    public ChainedClosure(Closure<? super E>... closureArr) {
        this(true, closureArr);
    }

    public void execute(E e) {
        for (Closure<? super E> execute : this.f6412a) {
            execute.execute(e);
        }
    }

    public Closure<? super E>[] getClosures() {
        return C1320jj.m5713a(this.f6412a);
    }
}
