package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableListIterator<E> implements ListIterator<E>, Unmodifiable {

    /* renamed from: a */
    private final ListIterator<? extends E> f6559a;

    public static <E> ListIterator<E> umodifiableListIterator(ListIterator<? extends E> listIterator) {
        if (listIterator != null) {
            return listIterator instanceof Unmodifiable ? listIterator : new UnmodifiableListIterator(listIterator);
        }
        throw new IllegalArgumentException("ListIterator must not be null");
    }

    private UnmodifiableListIterator(ListIterator<? extends E> listIterator) {
        this.f6559a = listIterator;
    }

    public boolean hasNext() {
        return this.f6559a.hasNext();
    }

    public E next() {
        return this.f6559a.next();
    }

    public int nextIndex() {
        return this.f6559a.nextIndex();
    }

    public boolean hasPrevious() {
        return this.f6559a.hasPrevious();
    }

    public E previous() {
        return this.f6559a.previous();
    }

    public int previousIndex() {
        return this.f6559a.previousIndex();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    public void set(E e) {
        throw new UnsupportedOperationException("set() is not supported");
    }

    public void add(E e) {
        throw new UnsupportedOperationException("add() is not supported");
    }
}
