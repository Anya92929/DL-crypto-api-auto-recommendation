package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.SortedBag;

public class PredicatedSortedBag<E> extends PredicatedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 3448581314086406616L;

    public static <E> PredicatedSortedBag<E> predicatedSortedBag(SortedBag<E> sortedBag, Predicate<? super E> predicate) {
        return new PredicatedSortedBag<>(sortedBag, predicate);
    }

    protected PredicatedSortedBag(SortedBag<E> sortedBag, Predicate<? super E> predicate) {
        super(sortedBag, predicate);
    }

    /* access modifiers changed from: protected */
    public SortedBag<E> decorated() {
        return (SortedBag) super.decorated();
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
