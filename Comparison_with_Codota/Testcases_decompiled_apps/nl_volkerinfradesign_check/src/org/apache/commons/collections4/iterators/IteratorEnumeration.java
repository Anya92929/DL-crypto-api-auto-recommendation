package org.apache.commons.collections4.iterators;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration<E> implements Enumeration<E> {

    /* renamed from: a */
    private Iterator<? extends E> f6504a;

    public IteratorEnumeration() {
    }

    public IteratorEnumeration(Iterator<? extends E> it) {
        this.f6504a = it;
    }

    public boolean hasMoreElements() {
        return this.f6504a.hasNext();
    }

    public E nextElement() {
        return this.f6504a.next();
    }

    public Iterator<? extends E> getIterator() {
        return this.f6504a;
    }

    public void setIterator(Iterator<? extends E> it) {
        this.f6504a = it;
    }
}
