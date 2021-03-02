package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class LoopingIterator<E> implements ResettableIterator<E> {

    /* renamed from: a */
    private final Collection<? extends E> f6517a;

    /* renamed from: b */
    private Iterator<? extends E> f6518b;

    public LoopingIterator(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.f6517a = collection;
        reset();
    }

    public boolean hasNext() {
        return this.f6517a.size() > 0;
    }

    public E next() {
        if (this.f6517a.size() == 0) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.f6518b.hasNext()) {
            reset();
        }
        return this.f6518b.next();
    }

    public void remove() {
        this.f6518b.remove();
    }

    public void reset() {
        this.f6518b = this.f6517a.iterator();
    }

    public int size() {
        return this.f6517a.size();
    }
}
