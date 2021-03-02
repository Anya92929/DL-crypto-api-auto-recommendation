package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ResettableIterator;

public class IteratorIterable<E> implements Iterable<E> {

    /* renamed from: a */
    private final Iterator<? extends E> f6505a;

    /* renamed from: b */
    private final Iterator<E> f6506b;

    /* renamed from: a */
    private static <E> Iterator<E> m7066a(final Iterator<? extends E> it) {
        return new Iterator<E>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public E next() {
                return it.next();
            }

            public void remove() {
                it.remove();
            }
        };
    }

    public IteratorIterable(Iterator<? extends E> it) {
        this(it, false);
    }

    public IteratorIterable(Iterator<? extends E> it, boolean z) {
        if (!z || (it instanceof ResettableIterator)) {
            this.f6505a = it;
        } else {
            this.f6505a = new ListIteratorWrapper(it);
        }
        this.f6506b = m7066a(this.f6505a);
    }

    public Iterator<E> iterator() {
        if (this.f6505a instanceof ResettableIterator) {
            ((ResettableIterator) this.f6505a).reset();
        }
        return this.f6506b;
    }
}
