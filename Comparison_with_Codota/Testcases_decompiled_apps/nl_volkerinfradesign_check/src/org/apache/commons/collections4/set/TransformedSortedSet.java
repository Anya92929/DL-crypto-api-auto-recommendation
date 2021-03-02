package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedSet<E> extends TransformedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -1675486811351124386L;

    public static <E> TransformedSortedSet<E> transformingSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return new TransformedSortedSet<>(sortedSet, transformer);
    }

    public static <E> TransformedSortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        TransformedSortedSet<E> transformedSortedSet = new TransformedSortedSet<>(sortedSet, transformer);
        if (!(transformer == null || sortedSet == null || sortedSet.size() <= 0)) {
            Object[] array = sortedSet.toArray();
            sortedSet.clear();
            for (Object transform : array) {
                transformedSortedSet.decorated().add(transformer.transform(transform));
            }
        }
        return transformedSortedSet;
    }

    protected TransformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        super(sortedSet, transformer);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> getSortedSet() {
        return (SortedSet) decorated();
    }

    public E first() {
        return getSortedSet().first();
    }

    public E last() {
        return getSortedSet().last();
    }

    public Comparator<? super E> comparator() {
        return getSortedSet().comparator();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return new TransformedSortedSet(getSortedSet().subSet(e, e2), this.transformer);
    }

    public SortedSet<E> headSet(E e) {
        return new TransformedSortedSet(getSortedSet().headSet(e), this.transformer);
    }

    public SortedSet<E> tailSet(E e) {
        return new TransformedSortedSet(getSortedSet().tailSet(e), this.transformer);
    }
}
