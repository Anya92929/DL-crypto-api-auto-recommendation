package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ArrayListIterator<E> extends ArrayIterator<E> implements ResettableListIterator<E> {

    /* renamed from: e */
    private int f6476e = -1;

    public ArrayListIterator(Object obj) {
        super(obj);
    }

    public ArrayListIterator(Object obj, int i) {
        super(obj, i);
    }

    public ArrayListIterator(Object obj, int i, int i2) {
        super(obj, i, i2);
    }

    public boolean hasPrevious() {
        return this.f6475d > this.f6473b;
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f6475d - 1;
        this.f6475d = i;
        this.f6476e = i;
        return Array.get(this.f6472a, this.f6475d);
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6476e = this.f6475d;
        Object obj = this.f6472a;
        int i = this.f6475d;
        this.f6475d = i + 1;
        return Array.get(obj, i);
    }

    public int nextIndex() {
        return this.f6475d - this.f6473b;
    }

    public int previousIndex() {
        return (this.f6475d - this.f6473b) - 1;
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    public void set(Object obj) {
        if (this.f6476e == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.f6472a, this.f6476e, obj);
    }

    public void reset() {
        super.reset();
        this.f6476e = -1;
    }
}
