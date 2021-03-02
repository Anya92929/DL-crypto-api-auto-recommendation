package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public abstract class AbstractQuantifierPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -3094696765038308799L;
    protected final Predicate<? super T>[] iPredicates;

    public AbstractQuantifierPredicate(Predicate<? super T>... predicateArr) {
        this.iPredicates = predicateArr;
    }

    public Predicate<? super T>[] getPredicates() {
        return C1320jj.m5715a(this.iPredicates);
    }
}
