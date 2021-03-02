package org.apache.commons.collections4.iterators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ListIteratorWrapper<E> implements ResettableListIterator<E> {

    /* renamed from: a */
    private final Iterator<? extends E> f6512a;

    /* renamed from: b */
    private final List<E> f6513b = new ArrayList();

    /* renamed from: c */
    private int f6514c = 0;

    /* renamed from: d */
    private int f6515d = 0;

    /* renamed from: e */
    private boolean f6516e;

    public ListIteratorWrapper(Iterator<? extends E> it) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.f6512a = it;
    }

    public void add(E e) throws UnsupportedOperationException {
        if (this.f6512a instanceof ListIterator) {
            ((ListIterator) this.f6512a).add(e);
            return;
        }
        throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
    }

    public boolean hasNext() {
        if (this.f6514c == this.f6515d || (this.f6512a instanceof ListIterator)) {
            return this.f6512a.hasNext();
        }
        return true;
    }

    public boolean hasPrevious() {
        if (this.f6512a instanceof ListIterator) {
            return ((ListIterator) this.f6512a).hasPrevious();
        }
        return this.f6514c > 0;
    }

    public E next() throws NoSuchElementException {
        if (this.f6512a instanceof ListIterator) {
            return this.f6512a.next();
        }
        if (this.f6514c < this.f6515d) {
            this.f6514c++;
            return this.f6513b.get(this.f6514c - 1);
        }
        E next = this.f6512a.next();
        this.f6513b.add(next);
        this.f6514c++;
        this.f6515d++;
        this.f6516e = true;
        return next;
    }

    public int nextIndex() {
        if (this.f6512a instanceof ListIterator) {
            return ((ListIterator) this.f6512a).nextIndex();
        }
        return this.f6514c;
    }

    public E previous() throws NoSuchElementException {
        if (this.f6512a instanceof ListIterator) {
            return ((ListIterator) this.f6512a).previous();
        }
        if (this.f6514c == 0) {
            throw new NoSuchElementException();
        }
        this.f6516e = this.f6515d == this.f6514c;
        List<E> list = this.f6513b;
        int i = this.f6514c - 1;
        this.f6514c = i;
        return list.get(i);
    }

    public int previousIndex() {
        if (this.f6512a instanceof ListIterator) {
            return ((ListIterator) this.f6512a).previousIndex();
        }
        return this.f6514c - 1;
    }

    public void remove() throws UnsupportedOperationException {
        if (this.f6512a instanceof ListIterator) {
            this.f6512a.remove();
            return;
        }
        int i = this.f6514c;
        if (this.f6514c == this.f6515d) {
            i--;
        }
        if (!this.f6516e || this.f6515d - this.f6514c > 1) {
            throw new IllegalStateException(MessageFormat.format("Cannot remove element at index {0}.", new Object[]{Integer.valueOf(i)}));
        }
        this.f6512a.remove();
        this.f6513b.remove(i);
        this.f6514c = i;
        this.f6515d--;
        this.f6516e = false;
    }

    public void set(E e) throws UnsupportedOperationException {
        if (this.f6512a instanceof ListIterator) {
            ((ListIterator) this.f6512a).set(e);
            return;
        }
        throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
    }

    public void reset() {
        if (this.f6512a instanceof ListIterator) {
            ListIterator listIterator = (ListIterator) this.f6512a;
            while (listIterator.previousIndex() >= 0) {
                listIterator.previous();
            }
            return;
        }
        this.f6514c = 0;
    }
}
