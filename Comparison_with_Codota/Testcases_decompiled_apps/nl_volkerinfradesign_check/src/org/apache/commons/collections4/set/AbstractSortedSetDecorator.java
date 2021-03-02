package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class AbstractSortedSetDecorator<E> extends AbstractSetDecorator<E> implements SortedSet<E> {
    private static final long serialVersionUID = -3462240946294214398L;

    protected AbstractSortedSetDecorator() {
    }

    protected AbstractSortedSetDecorator(Set<E> set) {
        super(set);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return decorated().subSet(e, e2);
    }

    public SortedSet<E> headSet(E e) {
        return decorated().headSet(e);
    }

    public SortedSet<E> tailSet(E e) {
        return decorated().tailSet(e);
    }

    public E first() {
        return decorated().first();
    }

    public E last() {
        return decorated().last();
    }

    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }
}
