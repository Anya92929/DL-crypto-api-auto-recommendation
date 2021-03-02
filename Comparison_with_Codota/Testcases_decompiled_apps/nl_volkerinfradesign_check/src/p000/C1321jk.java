package p000;

import java.util.NoSuchElementException;

/* renamed from: jk */
public abstract class C1321jk<E> {
    public boolean hasNext() {
        return false;
    }

    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public boolean hasPrevious() {
        return false;
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public void add(E e) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    public void set(E e) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void reset() {
    }
}
