package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EmptyOrderedIterator<E> extends C1321jk<E> implements OrderedIterator<E>, ResettableIterator<E> {
    public static final OrderedIterator INSTANCE = new EmptyOrderedIterator();

    public /* bridge */ /* synthetic */ void add(Object obj) {
        super.add(obj);
    }

    public /* bridge */ /* synthetic */ boolean hasNext() {
        return super.hasNext();
    }

    public /* bridge */ /* synthetic */ boolean hasPrevious() {
        return super.hasPrevious();
    }

    public /* bridge */ /* synthetic */ Object next() {
        return super.next();
    }

    public /* bridge */ /* synthetic */ int nextIndex() {
        return super.nextIndex();
    }

    public /* bridge */ /* synthetic */ Object previous() {
        return super.previous();
    }

    public /* bridge */ /* synthetic */ int previousIndex() {
        return super.previousIndex();
    }

    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public /* bridge */ /* synthetic */ void set(Object obj) {
        super.set(obj);
    }

    public static <E> OrderedIterator<E> emptyOrderedIterator() {
        return INSTANCE;
    }

    protected EmptyOrderedIterator() {
    }
}
