package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ArrayStack;

public class PushbackIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private final Iterator<? extends E> f6543a;

    /* renamed from: b */
    private ArrayStack<E> f6544b = new ArrayStack<>();

    public static <E> PushbackIterator<E> pushbackIterator(Iterator<? extends E> it) {
        if (it == null) {
            throw new IllegalArgumentException("Iterator must not be null");
        } else if (it instanceof PushbackIterator) {
            return (PushbackIterator) it;
        } else {
            return new PushbackIterator<>(it);
        }
    }

    public PushbackIterator(Iterator<? extends E> it) {
        this.f6543a = it;
    }

    public void pushback(E e) {
        this.f6544b.push(e);
    }

    public boolean hasNext() {
        if (!this.f6544b.isEmpty()) {
            return true;
        }
        return this.f6543a.hasNext();
    }

    public E next() {
        return !this.f6544b.isEmpty() ? this.f6544b.pop() : this.f6543a.next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
