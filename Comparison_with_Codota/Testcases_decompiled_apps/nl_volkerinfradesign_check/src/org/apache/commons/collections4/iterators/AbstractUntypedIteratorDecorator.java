package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {

    /* renamed from: a */
    private final Iterator<I> f6471a;

    public AbstractUntypedIteratorDecorator(Iterator<I> it) {
        if (it == null) {
            throw new IllegalArgumentException("Iterator must not be null");
        }
        this.f6471a = it;
    }

    public Iterator<I> getIterator() {
        return this.f6471a;
    }

    public boolean hasNext() {
        return this.f6471a.hasNext();
    }

    public void remove() {
        this.f6471a.remove();
    }
}
