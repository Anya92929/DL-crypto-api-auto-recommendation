package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator<E> implements ResettableListIterator<E> {

    /* renamed from: a */
    private boolean f6552a = true;

    /* renamed from: b */
    private boolean f6553b = false;

    /* renamed from: c */
    private boolean f6554c = false;

    /* renamed from: d */
    private E f6555d;

    public SingletonListIterator(E e) {
        this.f6555d = e;
    }

    public boolean hasNext() {
        return this.f6552a && !this.f6554c;
    }

    public boolean hasPrevious() {
        return !this.f6552a && !this.f6554c;
    }

    public int nextIndex() {
        return this.f6552a ? 0 : 1;
    }

    public int previousIndex() {
        return this.f6552a ? -1 : 0;
    }

    public E next() {
        if (!this.f6552a || this.f6554c) {
            throw new NoSuchElementException();
        }
        this.f6552a = false;
        this.f6553b = true;
        return this.f6555d;
    }

    public E previous() {
        if (this.f6552a || this.f6554c) {
            throw new NoSuchElementException();
        }
        this.f6552a = true;
        return this.f6555d;
    }

    public void remove() {
        if (!this.f6553b || this.f6554c) {
            throw new IllegalStateException();
        }
        this.f6555d = null;
        this.f6554c = true;
    }

    public void add(E e) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    public void set(E e) {
        if (!this.f6553b || this.f6554c) {
            throw new IllegalStateException();
        }
        this.f6555d = e;
    }

    public void reset() {
        this.f6552a = true;
        this.f6553b = false;
    }
}
