package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableIterator<E> implements Iterator<E>, Unmodifiable {

    /* renamed from: a */
    private final Iterator<? extends E> f6558a;

    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> it) {
        if (it != null) {
            return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
        }
        throw new IllegalArgumentException("Iterator must not be null");
    }

    private UnmodifiableIterator(Iterator<? extends E> it) {
        this.f6558a = it;
    }

    public boolean hasNext() {
        return this.f6558a.hasNext();
    }

    public E next() {
        return this.f6558a.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
