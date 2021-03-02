package org.apache.commons.collections4.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class LoopingListIterator<E> implements ResettableListIterator<E> {

    /* renamed from: a */
    private final List<E> f6519a;

    /* renamed from: b */
    private ListIterator<E> f6520b;

    public LoopingListIterator(List<E> list) {
        if (list == null) {
            throw new NullPointerException("The list must not be null");
        }
        this.f6519a = list;
        m7068a();
    }

    public boolean hasNext() {
        return !this.f6519a.isEmpty();
    }

    public E next() {
        if (this.f6519a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.f6520b.hasNext()) {
            reset();
        }
        return this.f6520b.next();
    }

    public int nextIndex() {
        if (this.f6519a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (!this.f6520b.hasNext()) {
            return 0;
        } else {
            return this.f6520b.nextIndex();
        }
    }

    public boolean hasPrevious() {
        return !this.f6519a.isEmpty();
    }

    public E previous() {
        if (this.f6519a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (this.f6520b.hasPrevious()) {
            return this.f6520b.previous();
        } else {
            E e = null;
            while (this.f6520b.hasNext()) {
                e = this.f6520b.next();
            }
            this.f6520b.previous();
            return e;
        }
    }

    public int previousIndex() {
        if (this.f6519a.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        } else if (!this.f6520b.hasPrevious()) {
            return this.f6519a.size() - 1;
        } else {
            return this.f6520b.previousIndex();
        }
    }

    public void remove() {
        this.f6520b.remove();
    }

    public void add(E e) {
        this.f6520b.add(e);
    }

    public void set(E e) {
        this.f6520b.set(e);
    }

    public void reset() {
        m7068a();
    }

    /* renamed from: a */
    private void m7068a() {
        this.f6520b = this.f6519a.listIterator();
    }

    public int size() {
        return this.f6519a.size();
    }
}
