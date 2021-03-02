package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class NonePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 2007613066565892961L;

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>... predicateArr) {
        C1320jj.m5718b((Predicate<?>[]) predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate(C1320jj.m5715a(predicateArr));
    }

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<T>> collection) {
        Predicate[] a = C1320jj.m5714a(collection);
        if (a.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate(a);
    }

    public NonePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public boolean evaluate(T t) {
        for (Predicate evaluate : this.iPredicates) {
            if (evaluate.evaluate(t)) {
                return false;
            }
        }
        return true;
    }
}
