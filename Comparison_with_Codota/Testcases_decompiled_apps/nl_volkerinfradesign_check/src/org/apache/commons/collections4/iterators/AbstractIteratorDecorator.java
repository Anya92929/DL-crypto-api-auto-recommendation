package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public abstract class AbstractIteratorDecorator<E> extends AbstractUntypedIteratorDecorator<E, E> {
    public AbstractIteratorDecorator(Iterator<E> it) {
        super(it);
    }

    public E next() {
        return getIterator().next();
    }
}
