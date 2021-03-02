package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class SwitchClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;

    /* renamed from: a */
    private final Predicate<? super E>[] f6454a;

    /* renamed from: b */
    private final Closure<? super E>[] f6455b;

    /* renamed from: c */
    private final Closure<? super E> f6456c;

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        C1320jj.m5717b((Closure<?>[]) closureArr);
        if (predicateArr.length != closureArr.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        } else if (predicateArr.length != 0) {
            return new SwitchClosure(predicateArr, closureArr, closure);
        } else {
            if (closure == null) {
                return NOPClosure.nopClosure();
            }
            return closure;
        }
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and closure map must not be null");
        }
        Closure<E> remove = map.remove((Object) null);
        int size = map.size();
        if (size != 0) {
            Closure[] closureArr = new Closure[size];
            Predicate[] predicateArr = new Predicate[size];
            int i = 0;
            for (Map.Entry next : map.entrySet()) {
                predicateArr[i] = (Predicate) next.getKey();
                closureArr[i] = (Closure) next.getValue();
                i++;
            }
            return new SwitchClosure(false, predicateArr, closureArr, remove);
        } else if (remove == null) {
            return NOPClosure.nopClosure();
        } else {
            return remove;
        }
    }

    private SwitchClosure(boolean z, Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this.f6454a = z ? C1320jj.m5715a((Predicate<? super T>[]) predicateArr) : predicateArr;
        this.f6455b = z ? C1320jj.m5713a(closureArr) : closureArr;
        this.f6456c = closure == null ? NOPClosure.nopClosure() : closure;
    }

    public SwitchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this(true, predicateArr, closureArr, closure);
    }

    public void execute(E e) {
        for (int i = 0; i < this.f6454a.length; i++) {
            if (this.f6454a[i].evaluate(e)) {
                this.f6455b[i].execute(e);
                return;
            }
        }
        this.f6456c.execute(e);
    }

    public Predicate<? super E>[] getPredicates() {
        return C1320jj.m5715a((Predicate<? super T>[]) this.f6454a);
    }

    public Closure<? super E>[] getClosures() {
        return C1320jj.m5713a(this.f6455b);
    }

    public Closure<? super E> getDefaultClosure() {
        return this.f6456c;
    }
}
