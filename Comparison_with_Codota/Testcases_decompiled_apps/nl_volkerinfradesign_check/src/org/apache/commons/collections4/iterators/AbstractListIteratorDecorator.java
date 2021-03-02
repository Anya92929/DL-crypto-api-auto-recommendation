package org.apache.commons.collections4.iterators;

import java.util.ListIterator;

public class AbstractListIteratorDecorator<E> implements ListIterator<E> {

    /* renamed from: a */
    private final ListIterator<E> f6468a;

    public AbstractListIteratorDecorator(ListIterator<E> listIterator) {
        if (listIterator == null) {
            throw new IllegalArgumentException("ListIterator must not be null");
        }
        this.f6468a = listIterator;
    }

    public ListIterator<E> getListIterator() {
        return this.f6468a;
    }

    public boolean hasNext() {
        return this.f6468a.hasNext();
    }

    public E next() {
        return this.f6468a.next();
    }

    public int nextIndex() {
        return this.f6468a.nextIndex();
    }

    public boolean hasPrevious() {
        return this.f6468a.hasPrevious();
    }

    public E previous() {
        return this.f6468a.previous();
    }

    public int previousIndex() {
        return this.f6468a.previousIndex();
    }

    public void remove() {
        this.f6468a.remove();
    }

    public void set(E e) {
        this.f6468a.set(e);
    }

    public void add(E e) {
        this.f6468a.add(e);
    }
}
