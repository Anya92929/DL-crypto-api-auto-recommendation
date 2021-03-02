package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ObjectArrayIterator<E> implements ResettableIterator<E> {

    /* renamed from: a */
    final E[] f6523a;

    /* renamed from: b */
    final int f6524b;

    /* renamed from: c */
    final int f6525c;

    /* renamed from: d */
    int f6526d;

    public ObjectArrayIterator(E... eArr) {
        this(eArr, 0, eArr.length);
    }

    public ObjectArrayIterator(E[] eArr, int i) {
        this(eArr, i, eArr.length);
    }

    public ObjectArrayIterator(E[] eArr, int i, int i2) {
        this.f6526d = 0;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
        } else if (i2 > eArr.length) {
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        } else if (i > eArr.length) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
        } else if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index");
        } else {
            this.f6523a = eArr;
            this.f6524b = i;
            this.f6525c = i2;
            this.f6526d = i;
        }
    }

    public boolean hasNext() {
        return this.f6526d < this.f6525c;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E[] eArr = this.f6523a;
        int i = this.f6526d;
        this.f6526d = i + 1;
        return eArr[i];
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    public E[] getArray() {
        return this.f6523a;
    }

    public int getStartIndex() {
        return this.f6524b;
    }

    public int getEndIndex() {
        return this.f6525c;
    }

    public void reset() {
        this.f6526d = this.f6524b;
    }
}
