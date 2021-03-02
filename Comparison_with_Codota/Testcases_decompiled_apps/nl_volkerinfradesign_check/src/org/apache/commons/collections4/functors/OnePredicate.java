package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class OnePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... predicateArr) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return predicateArr[0];
        }
        return new OnePredicate(C1320jj.m5715a(predicateArr));
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<T>> collection) {
        return new OnePredicate(C1320jj.m5714a(collection));
    }

    public OnePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public boolean evaluate(T t) {
        boolean z = false;
        for (Predicate evaluate : this.iPredicates) {
            if (evaluate.evaluate(t)) {
                if (z) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }
}
