package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class SingletonIterator<E> implements ResettableIterator<E> {

    /* renamed from: a */
    private final boolean f6548a;

    /* renamed from: b */
    private boolean f6549b;

    /* renamed from: c */
    private boolean f6550c;

    /* renamed from: d */
    private E f6551d;

    public SingletonIterator(E e) {
        this(e, true);
    }

    public SingletonIterator(E e, boolean z) {
        this.f6549b = true;
        this.f6550c = false;
        this.f6551d = e;
        this.f6548a = z;
    }

    public boolean hasNext() {
        return this.f6549b && !this.f6550c;
    }

    public E next() {
        if (!this.f6549b || this.f6550c) {
            throw new NoSuchElementException();
        }
        this.f6549b = false;
        return this.f6551d;
    }

    public void remove() {
        if (!this.f6548a) {
            throw new UnsupportedOperationException();
        } else if (this.f6550c || this.f6549b) {
            throw new IllegalStateException();
        } else {
            this.f6551d = null;
            this.f6550c = true;
        }
    }

    public void reset() {
        this.f6549b = true;
    }
}
