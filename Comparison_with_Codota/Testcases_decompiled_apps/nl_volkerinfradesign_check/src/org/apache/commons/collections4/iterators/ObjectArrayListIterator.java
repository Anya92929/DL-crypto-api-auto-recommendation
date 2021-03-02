package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ResettableListIterator<E> {

    /* renamed from: e */
    private int f6527e = -1;

    public ObjectArrayListIterator(E... eArr) {
        super(eArr);
    }

    public ObjectArrayListIterator(E[] eArr, int i) {
        super(eArr, i);
    }

    public ObjectArrayListIterator(E[] eArr, int i, int i2) {
        super(eArr, i, i2);
    }

    public boolean hasPrevious() {
        return this.f6526d > getStartIndex();
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f6526d - 1;
        this.f6526d = i;
        this.f6527e = i;
        return this.f6523a[this.f6526d];
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6527e = this.f6526d;
        E[] eArr = this.f6523a;
        int i = this.f6526d;
        this.f6526d = i + 1;
        return eArr[i];
    }

    public int nextIndex() {
        return this.f6526d - getStartIndex();
    }

    public int previousIndex() {
        return (this.f6526d - getStartIndex()) - 1;
    }

    public void add(E e) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    public void set(E e) {
        if (this.f6527e == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        this.f6523a[this.f6527e] = e;
    }

    public void reset() {
        super.reset();
        this.f6527e = -1;
    }
}
