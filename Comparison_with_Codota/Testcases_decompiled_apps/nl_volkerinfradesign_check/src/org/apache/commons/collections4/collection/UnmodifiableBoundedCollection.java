package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public final class UnmodifiableBoundedCollection<E> extends AbstractCollectionDecorator<E> implements BoundedCollection<E>, Unmodifiable {
    private static final long serialVersionUID = -7112672385450340330L;

    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(BoundedCollection<? extends E> boundedCollection) {
        return boundedCollection instanceof Unmodifiable ? boundedCollection : new UnmodifiableBoundedCollection(boundedCollection);
    }

    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(Collection<? extends E> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("The collection must not be null");
        }
        Collection<? extends E> collection2 = collection;
        for (int i = 0; i < 1000 && !(collection2 instanceof BoundedCollection); i++) {
            if (collection2 instanceof AbstractCollectionDecorator) {
                collection2 = ((AbstractCollectionDecorator) collection2).decorated();
            } else if (collection2 instanceof SynchronizedCollection) {
                collection2 = ((SynchronizedCollection) collection2).decorated();
            }
        }
        if (collection2 instanceof BoundedCollection) {
            return new UnmodifiableBoundedCollection((BoundedCollection) collection2);
        }
        throw new IllegalArgumentException("The collection is not a bounded collection");
    }

    private UnmodifiableBoundedCollection(BoundedCollection<? extends E> boundedCollection) {
        super(boundedCollection);
    }

    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean isFull() {
        return decorated().isFull();
    }

    public int maxSize() {
        return decorated().maxSize();
    }

    /* access modifiers changed from: protected */
    public BoundedCollection<E> decorated() {
        return (BoundedCollection) super.decorated();
    }
}
