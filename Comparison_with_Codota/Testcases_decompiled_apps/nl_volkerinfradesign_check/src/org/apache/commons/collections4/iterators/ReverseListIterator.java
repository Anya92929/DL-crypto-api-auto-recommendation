package org.apache.commons.collections4.iterators;

import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.ResettableListIterator;

public class ReverseListIterator<E> implements ResettableListIterator<E> {

    /* renamed from: a */
    private final List<E> f6545a;

    /* renamed from: b */
    private ListIterator<E> f6546b;

    /* renamed from: c */
    private boolean f6547c = true;

    public ReverseListIterator(List<E> list) {
        this.f6545a = list;
        this.f6546b = list.listIterator(list.size());
    }

    public boolean hasNext() {
        return this.f6546b.hasPrevious();
    }

    public E next() {
        E previous = this.f6546b.previous();
        this.f6547c = true;
        return previous;
    }

    public int nextIndex() {
        return this.f6546b.previousIndex();
    }

    public boolean hasPrevious() {
        return this.f6546b.hasNext();
    }

    public E previous() {
        E next = this.f6546b.next();
        this.f6547c = true;
        return next;
    }

    public int previousIndex() {
        return this.f6546b.nextIndex();
    }

    public void remove() {
        if (!this.f6547c) {
            throw new IllegalStateException("Cannot remove from list until next() or previous() called");
        }
        this.f6546b.remove();
    }

    public void set(E e) {
        if (!this.f6547c) {
            throw new IllegalStateException("Cannot set to list until next() or previous() called");
        }
        this.f6546b.set(e);
    }

    public void add(E e) {
        if (!this.f6547c) {
            throw new IllegalStateException("Cannot add to list until next() or previous() called");
        }
        this.f6547c = false;
        this.f6546b.add(e);
        this.f6546b.previous();
    }

    public void reset() {
        this.f6546b = this.f6545a.listIterator(this.f6545a.size());
    }
}
