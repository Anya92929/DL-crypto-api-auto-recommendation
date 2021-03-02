package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator<E> implements ResettableIterator<E> {

    /* renamed from: a */
    final Object f6472a;

    /* renamed from: b */
    final int f6473b;

    /* renamed from: c */
    final int f6474c;

    /* renamed from: d */
    int f6475d;

    public ArrayIterator(Object obj) {
        this(obj, 0);
    }

    public ArrayIterator(Object obj, int i) {
        this(obj, i, Array.getLength(obj));
    }

    public ArrayIterator(Object obj, int i, int i2) {
        this.f6475d = 0;
        this.f6472a = obj;
        this.f6473b = i;
        this.f6474c = i2;
        this.f6475d = i;
        int length = Array.getLength(obj);
        checkBound(i, length, "start");
        checkBound(i2, length, "end");
        if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }

    /* access modifiers changed from: protected */
    public void checkBound(int i, int i2, String str) {
        if (i > i2) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s beyond the end of the array. ");
        } else if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s before the start of the array. ");
        }
    }

    public boolean hasNext() {
        return this.f6475d < this.f6474c;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f6472a;
        int i = this.f6475d;
        this.f6475d = i + 1;
        return Array.get(obj, i);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public Object getArray() {
        return this.f6472a;
    }

    public int getStartIndex() {
        return this.f6473b;
    }

    public int getEndIndex() {
        return this.f6474c;
    }

    public void reset() {
        this.f6475d = this.f6473b;
    }
}
