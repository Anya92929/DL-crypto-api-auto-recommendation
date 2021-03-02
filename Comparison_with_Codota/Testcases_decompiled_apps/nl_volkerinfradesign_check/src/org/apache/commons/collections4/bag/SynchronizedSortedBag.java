package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SortedBag;

public class SynchronizedSortedBag<E> extends SynchronizedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 722374056718497858L;

    public static <E> SynchronizedSortedBag<E> synchronizedSortedBag(SortedBag<E> sortedBag) {
        return new SynchronizedSortedBag<>(sortedBag);
    }

    protected SynchronizedSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    protected SynchronizedSortedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }

    /* access modifiers changed from: protected */
    public SortedBag<E> getSortedBag() {
        return (SortedBag) decorated();
    }

    public synchronized E first() {
        E first;
        synchronized (this.lock) {
            first = getSortedBag().first();
        }
        return first;
    }

    public synchronized E last() {
        E last;
        synchronized (this.lock) {
            last = getSortedBag().last();
        }
        return last;
    }

    public synchronized Comparator<? super E> comparator() {
        Comparator<? super E> comparator;
        synchronized (this.lock) {
            comparator = getSortedBag().comparator();
        }
        return comparator;
    }
}
