package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return predicateArr[0];
        }
        return new AnyPredicate(C1320jj.m5715a(predicateArr));
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<T>> collection) {
        Predicate<T>[] a = C1320jj.m5714a(collection);
        if (a.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (a.length == 1) {
            return a[0];
        }
        return new AnyPredicate(a);
    }

    public AnyPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public boolean evaluate(T t) {
        for (Predicate evaluate : this.iPredicates) {
            if (evaluate.evaluate(t)) {
                return true;
            }
        }
        return false;
    }
}
