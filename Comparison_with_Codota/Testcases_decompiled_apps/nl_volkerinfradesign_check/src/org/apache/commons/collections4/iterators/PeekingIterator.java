package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator<E> implements Iterator<E> {

    /* renamed from: a */
    private final Iterator<? extends E> f6535a;

    /* renamed from: b */
    private boolean f6536b = false;

    /* renamed from: c */
    private boolean f6537c = false;

    /* renamed from: d */
    private E f6538d;

    public static <E> PeekingIterator<E> peekingIterator(Iterator<? extends E> it) {
        if (it == null) {
            throw new IllegalArgumentException("Iterator must not be null");
        } else if (it instanceof PeekingIterator) {
            return (PeekingIterator) it;
        } else {
            return new PeekingIterator<>(it);
        }
    }

    public PeekingIterator(Iterator<? extends E> it) {
        this.f6535a = it;
    }

    /* renamed from: a */
    private void m7069a() {
        if (!this.f6536b && !this.f6537c) {
            if (this.f6535a.hasNext()) {
                this.f6538d = this.f6535a.next();
                this.f6537c = true;
                return;
            }
            this.f6536b = true;
            this.f6538d = null;
            this.f6537c = false;
        }
    }

    public boolean hasNext() {
        if (this.f6536b) {
            return false;
        }
        if (this.f6537c) {
            return true;
        }
        return this.f6535a.hasNext();
    }

    public E peek() {
        m7069a();
        if (this.f6536b) {
            return null;
        }
        return this.f6538d;
    }

    public E element() {
        m7069a();
        if (!this.f6536b) {
            return this.f6538d;
        }
        throw new NoSuchElementException();
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E next = this.f6537c ? this.f6538d : this.f6535a.next();
        this.f6538d = null;
        this.f6537c = false;
        return next;
    }

    public void remove() {
        if (this.f6537c) {
            throw new IllegalStateException();
        }
        this.f6535a.remove();
    }
}
