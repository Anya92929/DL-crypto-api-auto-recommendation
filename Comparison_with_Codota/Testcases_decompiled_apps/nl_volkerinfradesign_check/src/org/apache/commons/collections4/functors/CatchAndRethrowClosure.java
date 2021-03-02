package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

public abstract class CatchAndRethrowClosure<E> implements Closure<E> {
    /* access modifiers changed from: protected */
    public abstract void executeAndThrow(E e) throws Throwable;

    public void execute(E e) {
        try {
            executeAndThrow(e);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }
}
