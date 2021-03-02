package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class AllPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -3094696765038308799L;

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicateArr) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (predicateArr.length == 1) {
            return C1320jj.m5712a(predicateArr[0]);
        }
        return new AllPredicate(C1320jj.m5715a(predicateArr));
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<T>> collection) {
        Predicate<T>[] a = C1320jj.m5714a(collection);
        if (a.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (a.length == 1) {
            return a[0];
        }
        return new AllPredicate(a);
    }

    public AllPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public boolean evaluate(T t) {
        for (Predicate evaluate : this.iPredicates) {
            if (!evaluate.evaluate(t)) {
                return false;
            }
        }
        return true;
    }
}
