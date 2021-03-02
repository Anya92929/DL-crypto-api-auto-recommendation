package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedBag<E> extends TransformedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = -251737742649401930L;

    public static <E> TransformedSortedBag<E> transformingSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        return new TransformedSortedBag<>(sortedBag, transformer);
    }

    public static <E> TransformedSortedBag<E> transformedSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        TransformedSortedBag<E> transformedSortedBag = new TransformedSortedBag<>(sortedBag, transformer);
        if (!(transformer == null || sortedBag == null || sortedBag.size() <= 0)) {
            Object[] array = sortedBag.toArray();
            sortedBag.clear();
            for (Object transform : array) {
                transformedSortedBag.decorated().add(transformer.transform(transform));
            }
        }
        return transformedSortedBag;
    }

    protected TransformedSortedBag(SortedBag<E> sortedBag, Transformer<? super E, ? extends E> transformer) {
        super(sortedBag, transformer);
    }

    /* access modifiers changed from: protected */
    public SortedBag<E> getSortedBag() {
        return (SortedBag) decorated();
    }

    public E first() {
        return getSortedBag().first();
    }

    public E last() {
        return getSortedBag().last();
    }

    public Comparator<? super E> comparator() {
        return getSortedBag().comparator();
    }
}
