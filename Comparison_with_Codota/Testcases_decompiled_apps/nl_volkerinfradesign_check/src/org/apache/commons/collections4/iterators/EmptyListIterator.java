package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import org.apache.commons.collections4.ResettableListIterator;

public class EmptyListIterator<E> extends C1321jk<E> implements ResettableListIterator<E> {
    public static final ListIterator INSTANCE = RESETTABLE_INSTANCE;
    public static final ResettableListIterator RESETTABLE_INSTANCE = new EmptyListIterator();

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

    public static <E> ResettableListIterator<E> resettableEmptyListIterator() {
        return RESETTABLE_INSTANCE;
    }

    public static <E> ListIterator<E> emptyListIterator() {
        return INSTANCE;
    }

    protected EmptyListIterator() {
    }
}
