package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return new PredicatedSortedSet<>(sortedSet, predicate);
    }

    protected PredicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        super(sortedSet, predicate);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }

    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    public E first() {
        return decorated().first();
    }

    public E last() {
        return decorated().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return new PredicatedSortedSet(decorated().subSet(e, e2), this.predicate);
    }

    public SortedSet<E> headSet(E e) {
        return new PredicatedSortedSet(decorated().headSet(e), this.predicate);
    }

    public SortedSet<E> tailSet(E e) {
        return new PredicatedSortedSet(decorated().tailSet(e), this.predicate);
    }
}
